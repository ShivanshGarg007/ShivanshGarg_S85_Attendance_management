package com.school;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Student s1 = new Student();
        s1.setDetails(100, "Shivansh Garg");
        Student s2 = new Student();
        s2.setDetails(101, "Vikram");

        ArrayList<Student> Students = new ArrayList<>();
        Students.add(s1);
        Students.add(s2);

        for (Student student : Students) {
            student.displayDetails();
        }

        Course c1 = new Course();
        c1.setDetails(1, "Mastery Java in 100 Days");
        Course c2 = new Course();
        c2.setDetails(2, "Full Stack Web Development Course");

        ArrayList<Course> courses = new ArrayList<>();
        courses.add(c1);
        courses.add(c2);

        for (Course course : courses) {
            course.displayDetails();
        }

    }
}
