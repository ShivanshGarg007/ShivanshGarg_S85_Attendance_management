package com.school;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FileStorageService {

    public void saveData(List<? extends Storable> items, String filename) {
        // Using try-with-resources for automatic closing of PrintWriter/FileWriter
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {  //List<? extends Storable> items → A list of objects that implement the Storable interface.
            //✅ This ensures every object passed here knows how to convert itself into a string (via toDataString() method).

            // String filename → The name of the file where data will be stored.
            for (Storable item : items) {
                writer.println(item.toDataString());
            }
            System.out.println("Data successfully saved to " + filename);
        } catch (IOException e) {
            System.err.println("Error saving data to " + filename + ": " + e.getMessage());
        }
    }

    // Loading data is more complex and will be discussed or tackled later.
    // For example, a loadStudents(String filename) method would read lines,
    // parse them, and create Student objects. This requires knowing the type.
}