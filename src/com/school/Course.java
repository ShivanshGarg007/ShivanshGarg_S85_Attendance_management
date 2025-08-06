package com.school;

public class Course {
    private static int nextCourseIdCounter = 101;

    private int courseId;
    private String courseName;

    // Constructor
    public Course(String courseName) {
        this.courseId = nextCourseIdCounter++;
        this.courseName = courseName;
    }

    // Getter for courseId
    public int getCourseId() {
        return courseId;
    }

    // Getter for courseName
    public String getCourseName() {
        return courseName;
    }

    public void displayDetails() {
        System.out.println("Course ID: C" + this.courseId + ", Name: " + this.courseName);
    }
}