package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- School Administration & Attendance System ---"); // Title update

        // Creating different types of people
        System.out.println("\n--- Creating School Personnel ---");
        Student student1 = new Student("Alice Wonderland", "Grade 10");
        Student student2 = new Student("Bob The Builder", "Grade 9");
        Teacher teacher1 = new Teacher("Dr. Emily Carter", "Physics");
        Staff staff1 = new Staff("Mr. John Davis", "Librarian");

        System.out.println("\n--- School Personnel Details ---");
        student1.displayDetails();
        student2.displayDetails();
        teacher1.displayDetails();
        staff1.displayDetails();

        Course course1 = new Course("Intro to Quantum Physics"); // Updated course name
        System.out.println("\nAvailable Courses:");
        course1.displayDetails();


        // --- Attendance Recording (Modified to use Person's ID) ---
        System.out.println("\n--- Attendance Recording ---");
        List<AttendanceRecord> attendanceLog = new ArrayList<>();

        // Student1 attends course1
        AttendanceRecord record1 = new AttendanceRecord(student1.getId(), course1.getCourseId(), "Present");
        attendanceLog.add(record1);

        // Student2 attempts to attend course1 with an invalid status
        AttendanceRecord record2 = new AttendanceRecord(student2.getId(), course1.getCourseId(), "Daydreaming");
        attendanceLog.add(record2);

        System.out.println("\n--- Attendance Log ---");
        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }

        System.out.println("\nSession 5: Inheritance Hierarchy Established Complete.");
    }
}