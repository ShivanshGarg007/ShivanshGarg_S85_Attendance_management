package com.school;

public class Student extends Person { // Extends Person
    // private static int nextStudentIdCounter = 1; // Removed, uses Person's ID
    // private int studentId;    // Removed, uses Person's id
    // private String name;      // Removed, uses Person's name

    private String gradeLevel; // Example new specific field

    public Student(String name, String gradeLevel) {
        super(name); // Calls Person constructor
        this.gradeLevel = gradeLevel;
    }

    // Getter for gradeLevel (optional for now, focus on display)
    public String getGradeLevel() {
        return gradeLevel;
    }

    @Override // Good practice to indicate overriding
    public void displayDetails() {
        super.displayDetails(); // Call Person's displayDetails
        System.out.println(", Grade Level: " + gradeLevel + " (Role: Student)");
    }
}