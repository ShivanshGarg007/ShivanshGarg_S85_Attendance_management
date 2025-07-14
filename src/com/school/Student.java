package com.school;

public class Student {
    int studentID;
    String name;

    public void setDetails(int studentID, String name) {
        this.studentID = studentID;
        this.name = name;
    }

    public void displayDetails() {
        System.out.println("Student ID: " + this.studentID + " ,Name: " + this.name);
    }


}
