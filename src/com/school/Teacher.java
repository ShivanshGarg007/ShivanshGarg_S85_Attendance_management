package com.school;

public class Teacher extends Person {
    private String subjectTaught;

    public Teacher(String name, String subjectTaught) {
        super(name); // Calls Person constructor
        this.subjectTaught = subjectTaught;
    }

    // Getter for subjectTaught (optional for now)
    public String getSubjectTaught() {
        return subjectTaught;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println(", Subject: " + subjectTaught + " (Role: Teacher)");
    }
}