package com.school;

public class Staff extends Person implements Storable {
    private String role;

    public Staff(String name, String role) {
        super(name);
        this.role = role;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Staff Role: " + this.role + ", Role: Staff");
    }

    @Override
    public String toDataString() {
        return id + "," + name + "," + role;
    }
}