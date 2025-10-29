package com.school;

import java.util.ArrayList;
import java.util.List;

public class RegistrationService {
    private final List<Student> students;
    private final List<Teacher> teachers;
    private final List<Staff> staffMembers;
    private final List<Course> courses;
    private final FileStorageService storageService;

    public RegistrationService(FileStorageService storageService) {
        this.storageService = storageService;
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
        this.staffMembers = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    // Registration methods
    public void registerStudent(String name, String gradeLevel) {
        Student student = new Student(name, gradeLevel);
        students.add(student);
    }

    public void registerTeacher(String name, String subjectTaught) {
        Teacher teacher = new Teacher(name, subjectTaught);
        teachers.add(teacher);
    }

    public void registerStaff(String name, String role) {
        Staff staff = new Staff(name, role);
        staffMembers.add(staff);
    }

    public void createCourse(String courseName) {
        Course course = new Course(courseName);
        courses.add(course);
    }

    // Getters for lists
    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }

    public List<Teacher> getTeachers() {
        return new ArrayList<>(teachers);
    }

    public List<Staff> getStaffMembers() {
        return new ArrayList<>(staffMembers);
    }

    public List<Course> getCourses() {
        return new ArrayList<>(courses);
    }

    // Finder methods
    public Student findStudentById(int id) {
        for (Student s : students) {
            if (s != null && s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    public Course findCourseById(int id) {
        for (Course c : courses) {
            if (c != null && c.getCourseId() == id) {
                return c;
            }
        }
        return null;
    }

    // Get all people (polymorphic list)
    public List<Person> getAllPeople() {
        List<Person> allPeople = new ArrayList<>();
        allPeople.addAll(students);
        allPeople.addAll(teachers);
        allPeople.addAll(staffMembers);
        return allPeople;
    }

    // Save all registrations
    public void saveAllRegistrations() {
        if (!students.isEmpty()) {
            storageService.saveData(students, "students.txt");
        }
        if (!teachers.isEmpty()) {
            storageService.saveData(teachers, "teachers.txt");
        }
        if (!staffMembers.isEmpty()) {
            storageService.saveData(staffMembers, "staff.txt");
        }
        if (!courses.isEmpty()) {
            storageService.saveData(courses, "courses.txt");
        }
    }
}