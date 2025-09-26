package com.school;

public class AttendanceRecord implements Storable {
    private Student student; // Changed from studentId to Student object
    private Course course;   // Changed from courseId to Course object
    private String status;

    public AttendanceRecord(Student student, Course course, String status) {
        this.student = student;
        this.course = course;
        if ("Present".equalsIgnoreCase(status) || "Absent".equalsIgnoreCase(status)) {
            this.status = status;
        } else {
            this.status = "Invalid";
            System.out.println("Warning: Invalid attendance status provided ('" + status + "'). Set to 'Invalid'.");
        }
    }

    public Student getStudent() { return student; } // Getter for Student object
    public Course getCourse() { return course; }   // Getter for Course object
    public String getStatus() { return status; }

    public void displayRecord() {
        // Now we can get details directly from the objects
        System.out.println("Attendance: Student " + student.getName() + " (ID: " + student.getId() + ")" +
                " in Course " + course.getCourseName() + " (ID: C" + course.getCourseId() + ")" +
                " - Status: " + status);
    }

    @Override
    public String toDataString() {
        // Save IDs for simplicity in file storage
        return student.getId() + "," + course.getCourseId() + "," + status;
    }
}