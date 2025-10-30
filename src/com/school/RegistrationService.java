package com.school;

import java.util.ArrayList;
import java.util.List;

public class RegistrationService {
    private List<Student> students;
    private List<Teacher> teachers;
    private List<Staff> staffMembers;
    private List<Course> courses; // Managing courses here for now
    private FileStorageService storageService;

    private final String STUDENTS_FILE = "students.txt";
    private final String TEACHERS_FILE = "teachers.txt";
    private final String STAFF_FILE = "staff.txt";
    private final String COURSES_FILE = "courses.txt";


    public RegistrationService(FileStorageService storageService) {
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
        this.staffMembers = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.storageService = storageService;
        // In a real app, load data here
    }

    public Student registerStudent(String name, String gradeLevel) {
        Student student = new Student(name, gradeLevel);
        this.students.add(student);
        System.out.println("Student registered: " + name + " (ID: " + student.getId() + ")");
        return student;
    }

    public Teacher registerTeacher(String name, String subject) {
        Teacher teacher = new Teacher(name, subject);
        this.teachers.add(teacher);
        System.out.println("Teacher registered: " + name + " (ID: " + teacher.getId() + ")");
        return teacher;
    }

    public Staff registerStaff(String name, String role) {
        Staff staff = new Staff(name, role);
        this.staffMembers.add(staff);
        System.out.println("Staff registered: " + name + " (ID: " + staff.getId() + ")");
        return staff;
    }

    // Updated to accept capacity
    public Course createCourse(String courseName, int capacity) {
        Course course = new Course(courseName, capacity);
        this.courses.add(course);
        System.out.println("Course created: " + courseName + " (ID: C" + course.getCourseId() + ", Capacity: " + capacity + ")");
        return course;
    }

    public boolean enrollStudentInCourse(Student student, Course course) {
        if (student == null || course == null) {
            System.out.println("Error: Student or Course cannot be null for enrollment.");
            return false;
        }
        // Check if student is already enrolled (optional, good practice)
        if (course.getEnrolledStudents().contains(student)) {
            System.out.println("Info: Student " + student.getName() + " is already enrolled in " + course.getCourseName());
            return true; // Or false if re-enrollment is an error
        }

        if (course.addStudent(student)) {
            System.out.println("Student " + student.getName() + " successfully enrolled in " + course.getCourseName());
            return true;
        } else {
            System.out.println("Failed to enroll student " + student.getName() + " in " + course.getCourseName() + ". Course is full.");
            return false;
        }
    }

    public List<Student> getStudents() { return students; }
    public List<Teacher> getTeachers() { return teachers; }
    public List<Staff> getStaffMembers() { return staffMembers; }
    public List<Course> getCourses() { return courses; }

    public Student findStudentById(int studentId) {
        for (Student s : students) {
            if (s.getId() == studentId) return s;
        }
        return null;
    }

    public Course findCourseById(int courseId) {
        for (Course c : courses) {
            if (c.getCourseId() == courseId) return c;
        }
        return null;
    }

    public List<Person> getAllPeople() {
        List<Person> allPeople = new ArrayList<>();
        allPeople.addAll(students);
        allPeople.addAll(teachers);
        allPeople.addAll(staffMembers);
        return allPeople;
    }

    public void saveAllRegistrations() {
        storageService.saveData(students, STUDENTS_FILE);
        storageService.saveData(teachers, TEACHERS_FILE);
        storageService.saveData(staffMembers, STAFF_FILE);
        storageService.saveData(courses, COURSES_FILE);
        System.out.println("All registration data saved.");
    }
}