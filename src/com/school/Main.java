package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- School Attendance System ---");

        Student student1 = new Student("Alice Wonderland");
        Student student2 = new Student("Bob The Builder");
        Course course1 = new Course("Intro to Programming");

        System.out.println("\nRegistered Students:");
        student1.displayDetails();
        student2.displayDetails();

        System.out.println("\nAvailable Courses:");
        course1.displayDetails();

        // --- Attendance Recording ---
        System.out.println("\n--- Attendance Recording ---");
        List<AttendanceRecord> attendanceLog = new ArrayList<>();

        // Record valid attendance
        AttendanceRecord record1 = new AttendanceRecord(student1.getStudentId(), course1.getCourseId(), "Present");
        attendanceLog.add(record1);

        // Attempt to record invalid attendance status
        AttendanceRecord record2 = new AttendanceRecord(student2.getStudentId(), course1.getCourseId(), "Late");
        attendanceLog.add(record2); // Will be stored as "Invalid"

        // Record another valid attendance
        AttendanceRecord record3 = new AttendanceRecord(student2.getStudentId(), course1.getCourseId(), "Absent");
        // We'll update record2's student for this scenario (or make a new student for course1)
        // For simplicity, let's assume student2 also takes course1 and we are just making a new record.
        attendanceLog.add(record3);


        System.out.println("\n--- Attendance Log ---");
        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }

        System.out.println("\nSession 4: Data Encapsulation & Attendance Recording Complete.");
    }
}