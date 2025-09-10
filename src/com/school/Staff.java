package com.school;

public class Staff extends Person {
    private String role; // e.g., "Librarian", "Administrator"

    public Staff(String name, String role) {
        super(name); // Calls Person constructor
        this.role = role;
    }

    // Getter for role (optional for now)
    public String getRole() {
        return role;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println(", Role: " + role + " (Role: Non-Teaching Staff)");
    }
}