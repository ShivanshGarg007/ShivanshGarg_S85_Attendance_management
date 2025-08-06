package com.school;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- School Attendance System ---");

        // Using constructors for initialization
        System.out.println("\nCreating Students and Courses using Constructors:");
        Student student1 = new Student("Alice Wonderland");
        Student student2 = new Student("Bob The Builder");

        Course course1 = new Course("Intro to Programming");
        Course course2 = new Course("Linear Algebra");

        System.out.println("\nRegistered Students:");
        student1.displayDetails();
        student2.displayDetails();

        System.out.println("\nAvailable Courses:");
        course1.displayDetails();
        course2.displayDetails();

        // Demonstrate auto-ID generation with new instances
        System.out.println("\n--- Auto-ID Generation Test ---");
        System.out.println("Creating one more student and course...");
        Student student3 = new Student("Charlie Chaplin");
        Course course3 = new Course("Data Structures");

        System.out.print("New Student: ");
        student3.displayDetails();
        System.out.print("New Course: ");
        course3.displayDetails();

        System.out.println("\nSession 3: Constructor Initialization & Auto-ID Generation Complete.");
    }
}