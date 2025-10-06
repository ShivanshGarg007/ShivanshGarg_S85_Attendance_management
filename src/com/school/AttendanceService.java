package com.school;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors; // For filtering

public class AttendanceService {
    private List<AttendanceRecord> attendanceLog;
    private FileStorageService storageService; // For saving/loading attendance
    private final String ATTENDANCE_FILE = "attendance_log.txt"; // Define filename

    public AttendanceService(FileStorageService storageService) {
        this.attendanceLog = new ArrayList<>();
        this.storageService = storageService;
        // In a real app, you'd load existing data here
        // loadAttendanceData();
    }

    // Overloaded method 1: Mark attendance with objects
    public void markAttendance(Student student, Course course, String status) {
        if (student == null || course == null) {
            System.out.println("Error: Student or Course object cannot be null.");
            return;
        }
        AttendanceRecord record = new AttendanceRecord(student, course, status);
        this.attendanceLog.add(record);
        System.out.println("Attendance marked for " + student.getName() + " in " + course.getCourseName() + " as " + record.getStatus());
    }

    // Overloaded method 2: Mark attendance with IDs (requires lookup)
    public void markAttendance(int studentId, int courseId, String status, List<Student> allStudents, List<Course> allCourses) {
        Student student = findStudentById(studentId, allStudents);
        Course course = findCourseById(courseId, allCourses);

        if (student == null) {
            System.out.println("Error: Student with ID " + studentId + " not found.");
            return;
        }
        if (course == null) {
            System.out.println("Error: Course with ID " + courseId + " not found.");
            return;
        }
        // Calls the first overloaded method
        markAttendance(student, course, status);
    }

    // Overloaded method 1: Display all attendance
    public void displayAttendanceLog() {
        System.out.println("\n--- Full Attendance Log ---");
        if (attendanceLog.isEmpty()) {
            System.out.println("No attendance records found.");
            return;
        }
        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }
    }

    // Overloaded method 2: Display attendance for a specific student
    public void displayAttendanceLog(Student student) {
        System.out.println("\n--- Attendance Log for Student: " + student.getName() + " (ID: " + student.getId() + ") ---");
        List<AttendanceRecord> studentRecords = attendanceLog.stream()
                .filter(record -> record.getStudent().getId() == student.getId())
                .collect(Collectors.toList());

        if (studentRecords.isEmpty()) {
            System.out.println("No attendance records found for this student.");
            return;
        }
        for (AttendanceRecord record : studentRecords) {
            record.displayRecord();
        }
    }

    // Overloaded method 3: Display attendance for a specific course
    public void displayAttendanceLog(Course course) {
        System.out.println("\n--- Attendance Log for Course: " + course.getCourseName() + " (ID: C" + course.getCourseId() + ") ---");
        List<AttendanceRecord> courseRecords = attendanceLog.stream()
                .filter(record -> record.getCourse().getCourseId() == course.getCourseId())
                .collect(Collectors.toList());
        if (courseRecords.isEmpty()) {
            System.out.println("No attendance records found for this course.");
            return;
        }
        for (AttendanceRecord record : courseRecords) {
            record.displayRecord();
        }
    }

    // Helper methods for lookup (could be in a separate utility or respective services)
    private Student findStudentById(int studentId, List<Student> students) {
        for (Student s : students) {
            if (s.getId() == studentId) return s;
        }
        return null;
    }

    private Course findCourseById(int courseId, List<Course> courses) {
        for (Course c : courses) {
            if (c.getCourseId() == courseId) return c;
        }
        return null;
    }

    // Method to save attendance data
    public void saveAttendanceData() {
        // The List<AttendanceRecord> directly implements List<? extends Storable>
        // because AttendanceRecord implements Storable.
        storageService.saveData(this.attendanceLog, ATTENDANCE_FILE);
    }

    // Placeholder for loading data - complex, involves parsing strings back to objects
    // public void loadAttendanceData() { ... }
}