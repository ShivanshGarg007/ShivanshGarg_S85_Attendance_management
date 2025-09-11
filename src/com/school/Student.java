package com.school;

public class Student extends Person implements Storable { // Extends Person

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

    @Override
    public String toDataString() {
        // Format: id,name,gradeLevel
        return getId() + "," + getName() + "," + gradeLevel;
    }
}