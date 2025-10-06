package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void displaySchoolDirectory(List<Person> people) {
        System.out.println("\n--- School Directory ---");
        if (people.isEmpty()) {
            System.out.println("No people in the directory.");
            return;
        }
        for (Person person : people) {
            person.displayDetails();
        }
    }

    public static void main(String[] args) {
        System.out.println("--- School System (Overloading Demo) ---");

        // --- Setup Services ---
        FileStorageService storageService = new FileStorageService();
        AttendanceService attendanceService = new AttendanceService(storageService);

        // --- Data Setup: Students and Courses ---
        List<Student> allStudents = new ArrayList<>();
        Student student1 = new Student("Alice Wonderland", "Grade 10");
        Student student2 = new Student("Bob The Builder", "Grade 9");
        Student student3 = new Student("Charlie Chaplin", "Grade 10");
        allStudents.add(student1);
        allStudents.add(student2);
        allStudents.add(student3);

        List<Course> allCourses = new ArrayList<>();
        Course course1 = new Course("Intro to Programming"); // ID will be C101
        Course course2 = new Course("Data Structures");      // ID will be C102
        allCourses.add(course1);
        allCourses.add(course2);

        List<Person> schoolPeople = new ArrayList<>(allStudents);
        Teacher teacher1 = new Teacher("Dr. Emily Carter", "Physics");
        schoolPeople.add(teacher1);
        displaySchoolDirectory(schoolPeople);

        System.out.println("\n\n--- Marking Attendance (Overloaded Methods) ---");
        // 1. Mark attendance using Student and Course objects
        attendanceService.markAttendance(student1, course1, "Present");
        attendanceService.markAttendance(student2, course1, "Absent");

        // 2. Mark attendance using studentId and courseId (assuming IDs are known or looked up)
        // Alice (ID 1) in Data Structures (ID C102)
        attendanceService.markAttendance(student1.getId(), course2.getCourseId(), "Present", allStudents, allCourses);
        // Charlie (ID 3) in Intro to Programming (ID C101)
        attendanceService.markAttendance(student3.getId(), course1.getCourseId(), "Late", allStudents, allCourses); // Invalid status


        System.out.println("\n\n--- Querying Attendance (Overloaded Methods) ---");
        // 1. Display full attendance log
        attendanceService.displayAttendanceLog();

        // 2. Display attendance for a specific student (Alice)
        attendanceService.displayAttendanceLog(student1);

        // 3. Display attendance for a specific course (Intro to Programming)
        attendanceService.displayAttendanceLog(course1);

        // --- Saving Attendance Data ---
        System.out.println("\n\n--- Saving Attendance Data ---");
        attendanceService.saveAttendanceData(); // This will save to attendance_log.txt

        // For completeness, we might want to save students and courses too if they changed
        // storageService.saveData(allStudents, "students.txt");
        // storageService.saveData(allCourses, "courses.txt");
        System.out.println("Student and Course data can be saved similarly if needed.");


        System.out.println("\nSession 8: Overloaded Commands Demonstrated Complete.");
    }
}