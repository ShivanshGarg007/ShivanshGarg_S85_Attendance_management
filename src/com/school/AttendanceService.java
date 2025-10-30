package com.school;

import java.util.ArrayList;
import java.util.List;

public class AttendanceService {
    private List<AttendanceRecord> attendanceLog;
    private FileStorageService storageService;
    private RegistrationService registrationService; // Dependency
    private final String ATTENDANCE_FILE = "attendance_log.txt";

    public AttendanceService(FileStorageService storageService, RegistrationService registrationService) {
        this.attendanceLog = new ArrayList<>();
        this.storageService = storageService;
        this.registrationService = registrationService; // Store the reference
    }

    // Overloaded method 1: Mark attendance with objects - NO CHANGE
    public void markAttendance(Student student, Course course, String status) {
        if (student == null || course == null) { /* ... */ return; }
        AttendanceRecord record = new AttendanceRecord(student, course, status);
        this.attendanceLog.add(record);
        System.out.println("Attendance marked for " + student.getName() + " in " + course.getCourseName() + " as " + record.getStatus());
    }

    // Overloaded method 2: Mark attendance with IDs (uses RegistrationService for lookup)
    public void markAttendance(int studentId, int courseId, String status) { // Removed List params
        Student student = registrationService.findStudentById(studentId); // Use injected service
        Course course = registrationService.findCourseById(courseId);     // Use injected service

        if (student == null) { /* ... */ return; }
        if (course == null) { /* ... */ return; }
        markAttendance(student, course, status);
    }

    // displayAttendanceLog() methods remain the same
    public void displayAttendanceLog() { /* ... */ }
    public void displayAttendanceLog(Student student) { /* ... */ }
    public void displayAttendanceLog(Course course) { /* ... */ }


    // Helper methods for lookup are now removed as RegistrationService handles it
    // private Student findStudentById(int studentId, List<Student> students) { ... }
    // private Course findCourseById(int courseId, List<Course> courses) { ... }

    public void saveAttendanceData() {
        storageService.saveData(this.attendanceLog, ATTENDANCE_FILE);
    }
}