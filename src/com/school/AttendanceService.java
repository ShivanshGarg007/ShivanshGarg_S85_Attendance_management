package com.school;

import java.util.ArrayList;
import java.util.List;

public class AttendanceService {
    private final List<AttendanceRecord> attendanceLog;
    private final FileStorageService storageService;
    private final RegistrationService registrationService;

    public AttendanceService(FileStorageService storageService, RegistrationService registrationService) {
        this.storageService = storageService;
        this.registrationService = registrationService;
        this.attendanceLog = new ArrayList<>();
    }

    // Overload 1: mark using objects
    public void markAttendance(Student student, Course course, String status) {
        if (student == null || course == null) {
            System.out.println("Cannot mark attendance: student or course is null.");
            return;
        }
        AttendanceRecord record = new AttendanceRecord(student, course, status);
        attendanceLog.add(record);
    }

    // Overload 2: mark using ids, uses RegistrationService for lookups
    public void markAttendance(int studentId, int courseId, String status) {
        Student student = registrationService.findStudentById(studentId);
        Course course = registrationService.findCourseById(courseId);

        if (student == null) {
            System.out.println("Student with ID " + studentId + " not found. Skipping attendance.");
            return;
        }
        if (course == null) {
            System.out.println("Course with ID " + courseId + " not found. Skipping attendance.");
            return;
        }

        markAttendance(student, course, status);
    }

    // Display methods
    public void displayAttendanceLog() {
        System.out.println("\n\n--- Attendance Log ---");
        if (attendanceLog.isEmpty()) {
            System.out.println("No attendance records yet.");
            return;
        }
        for (AttendanceRecord ar : attendanceLog) {
            ar.displayRecord();
        }
    }

    public void displayAttendanceLog(Student student) {
        System.out.println(
                "\n\n--- Attendance Log for Student: " + (student != null ? student.getName() : "<null>") + " ---");
        if (student == null) {
            System.out.println("No student provided.");
            return;
        }
        boolean any = false;
        for (AttendanceRecord ar : attendanceLog) {
            if (ar.getStudent().getId() == student.getId()) {
                ar.displayRecord();
                any = true;
            }
        }
        if (!any)
            System.out.println("No records for this student.");
    }

    public void displayAttendanceLog(Course course) {
        System.out.println(
                "\n\n--- Attendance Log for Course: " + (course != null ? course.getCourseName() : "<null>") + " ---");
        if (course == null) {
            System.out.println("No course provided.");
            return;
        }
        boolean any = false;
        for (AttendanceRecord ar : attendanceLog) {
            if (ar.getCourse().getCourseId() == course.getCourseId()) {
                ar.displayRecord();
                any = true;
            }
        }
        if (!any)
            System.out.println("No records for this course.");
    }

    public void saveAttendanceData() {
        storageService.saveData(attendanceLog, "attendance_log.txt");
    }
}