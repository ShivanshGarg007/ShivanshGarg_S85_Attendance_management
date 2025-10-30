package com.school;

import java.util.List;

public class Main {

    // displaySchoolDirectory is now better placed in RegistrationService or a ReportService
    // For now, let's make it use RegistrationService data
    public static void displaySchoolDirectory(RegistrationService regService) {
        System.out.println("\n--- School Directory ---");
        List<Person> people = regService.getAllPeople();
        if (people.isEmpty()) {
            System.out.println("No people registered.");
            return;
        }
        for (Person person : people) {
            person.displayDetails();
        }
    }

    public static void main(String[] args) {
        System.out.println("--- School System (Capacity Management & SOLID Reflection) ---");

        FileStorageService storageService = new FileStorageService();
        RegistrationService registrationService = new RegistrationService(storageService);
        AttendanceService attendanceService = new AttendanceService(storageService, registrationService);

        System.out.println("\n--- Registering People ---");
        Student student1 = registrationService.registerStudent("Alice Wonderland", "Grade 10");
        Student student2 = registrationService.registerStudent("Bob The Builder", "Grade 9");
        Student student3 = registrationService.registerStudent("Charlie Chaplin", "Grade 10"); // For capacity test

        System.out.println("\n--- Creating Courses with Capacity ---");
        Course courseCS101 = registrationService.createCourse("Intro to Programming", 2); // Capacity of 2
        Course courseMA202 = registrationService.createCourse("Linear Algebra", 30);

        System.out.println("\n--- Enrolling Students in Courses ---");
        registrationService.enrollStudentInCourse(student1, courseCS101);
        registrationService.enrollStudentInCourse(student2, courseCS101);
        registrationService.enrollStudentInCourse(student3, courseCS101); // This one should fail or show full

        registrationService.enrollStudentInCourse(student1, courseMA202); // Should succeed

        System.out.println("\n--- Updated Course Details ---");
        courseCS101.displayDetails();
        courseMA202.displayDetails();

        System.out.println("\n\n--- Marking Attendance ---");
        // Student 1 in CS101
        if (courseCS101.getEnrolledStudents().contains(student1)) { // Check enrollment before marking
            attendanceService.markAttendance(student1, courseCS101, "Present");
        } else {
            System.out.println("Cannot mark attendance: " + student1.getName() + " not enrolled in " + courseCS101.getCourseName());
        }
        // Student 3 in CS101 (should not have been enrolled if capacity was 2)
        if (courseCS101.getEnrolledStudents().contains(student3)) {
            attendanceService.markAttendance(student3, courseCS101, "Absent");
        } else {
            System.out.println("Cannot mark attendance: " + student3.getName() + " not enrolled in " + courseCS101.getCourseName());
        }


        System.out.println("\n\n--- Attendance Log for CS101 ---");
        attendanceService.displayAttendanceLog(courseCS101);

        System.out.println("\n\n--- Saving All Data ---");
        registrationService.saveAllRegistrations(); // Will save courses with their capacity
        attendanceService.saveAttendanceData();

        System.out.println("\nSession 10: Capacity Management & SOLID Reflection Complete.");
        System.out.println("Project Finished! Congratulations!");
    }
}