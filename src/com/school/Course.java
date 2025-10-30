package com.school;

import java.util.ArrayList; // Required for enrolledStudents list
import java.util.List;      // Required for List

public class Course implements Storable {
    private static int nextCourseIdCounter = 101;
    private int courseId;
    private String courseName;
    private int capacity; // New field
    private List<Student> enrolledStudents; // New field

    // Constructor updated to include capacity
    public Course(String courseName, int capacity) {
        this.courseId = nextCourseIdCounter++;
        this.courseName = courseName;
        this.capacity = capacity;
        this.enrolledStudents = new ArrayList<>(); // Initialize the list
    }

    public int getCourseId() { return courseId; }
    public String getCourseName() { return courseName; }
    public int getCapacity() { return capacity; }
    public List<Student> getEnrolledStudents() { return enrolledStudents; }
    public int getNumberOfEnrolledStudents() { return enrolledStudents.size(); }

    // Method to add a student if capacity allows
    public boolean addStudent(Student student) {
        if (enrolledStudents.size() < capacity) {
            enrolledStudents.add(student);
            return true;
        }
        return false; // Capacity full
    }

    public void displayDetails() {
        System.out.println("Course ID: C" + this.courseId + ", Name: " + this.courseName +
                ", Capacity: " + this.capacity +
                ", Enrolled: " + getNumberOfEnrolledStudents());
    }

    @Override
    public String toDataString() {
        // Format: courseId,courseName,capacity
        // We are not saving the enrolledStudents list directly in this string for simplicity.
        // Enrollment could be derived from AttendanceRecords or a separate enrollment file.
        return courseId + "," + courseName + "," + capacity;
    }
}