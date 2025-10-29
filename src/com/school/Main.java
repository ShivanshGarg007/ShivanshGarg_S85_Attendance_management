package com.school;

import java.util.List;

public class Main {

    public static void displaySchoolDirectory(RegistrationService regService) {
        System.out.println("\n--- School Directory ---");
        List<Person> people = regService.getAllPeople();
        if (people.isEmpty()) {
            System.out.println("No people in the directory.");
            return;
        }
        for (Person person : people) {
            person.displayDetails();
        }
    }

    public static void main(String[] args) {
        System.out.println("--- School Administration & Attendance System (Polymorphism Demo) ---");

        // Create services
        FileStorageService storageService = new FileStorageService();
        RegistrationService registrationService = new RegistrationService(storageService);
        AttendanceService attendanceService = new AttendanceService(storageService, registrationService);

        // Register students, teachers, staff, and courses
        registrationService.registerStudent("Alice Wonderland", "Grade 10");
        registrationService.registerStudent("Bob The Builder", "Grade 9");
        registrationService.registerTeacher("Dr. Emily Carter", "Physics");
        registrationService.registerStaff("Mr. John Davis", "Librarian");

        // Display school directory using RegistrationService
        displaySchoolDirectory(registrationService);

        // Create courses
        registrationService.createCourse("Intro to Quantum Physics");
        registrationService.createCourse("Advanced Algorithms");

        System.out.println("\n\n--- Available Courses ---");
        for (Course c : registrationService.getCourses()) {
            c.displayDetails();
        }

        // Get students and courses for attendance marking
        List<Student> students = registrationService.getStudents();
        List<Course> courses = registrationService.getCourses();

        // Mark attendance using object-based method
        if (students.size() >= 2 && courses.size() >= 1) {
            attendanceService.markAttendance(students.get(0), courses.get(0), "Present");
            attendanceService.markAttendance(students.get(1), courses.get(0), "Absent");
        }

        // Mark attendance using ID-based method
        if (students.size() >= 1 && courses.size() >= 2) {
            attendanceService.markAttendance(students.get(0).getId(), courses.get(1).getCourseId(), "Daydreaming");
        }

        // Display attendance logs
        attendanceService.displayAttendanceLog();
        if (students.size() >= 1) {
            attendanceService.displayAttendanceLog(students.get(0));
        }
        if (courses.size() >= 1) {
            attendanceService.displayAttendanceLog(courses.get(0));
        }

        // Save all data
        System.out.println("\n\n--- Saving Data to Files ---");
        registrationService.saveAllRegistrations();
        attendanceService.saveAttendanceData();

        System.out.println("\nSession Complete: All data saved successfully.");
    }
}