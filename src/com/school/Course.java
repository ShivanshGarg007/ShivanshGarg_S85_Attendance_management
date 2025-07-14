package com.school;

public class Course {
    int courseID;
    String courseName;

    public void setDetails(int courseID, String courseName) {
        this.courseID = courseID;
        this.courseName = courseName;
    }

    public void displayDetails() {
        System.out.println("Course ID: " + this.courseID + " ,Course Name: " + this.courseName);
    }
}
