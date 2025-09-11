package com.school;

public class Course implements Storable {
    private static int nextCourseIdCounter = 101;

    private int courseId;       // Made private
    private String courseName;  // Made private

    // Constructor
    public Course(String courseName) {
        this.courseId = nextCourseIdCounter++; // Auto-increment and assign ID
        this.courseName = courseName;          // Assign course name
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

    @Override
    public String toDataString() {
        // Format: courseId,courseName
        return courseId + "," + courseName;
    }
}