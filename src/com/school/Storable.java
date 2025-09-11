package com.school;

public interface Storable {
    String toDataString(); // To convert object data to a savable string format
    // A static fromDataString would be ideal but complicates pre-Java 8.
    // We'll handle parsing in constructors or dedicated static methods in implementing classes for now.
}