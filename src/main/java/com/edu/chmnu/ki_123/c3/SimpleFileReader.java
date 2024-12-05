package com.edu.chmnu.ki_123.c3;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SimpleFileReader {
    public static void main(String[] args) {
        String filePath = "src/test_file.txt";

        try {
            File file = new File(filePath);

            if (file.createNewFile()) {
                System.out.println("File created: " + file.getAbsolutePath());
            } else {
                System.out.println("File already exists: " + file.getAbsolutePath());
            }

            FileWriter writer = new FileWriter(file);
            writer.write("This is a simple file reader example.");
            writer.close();
            System.out.println("Data written to file successfully.");

            FileReader reader = new FileReader(file);
            System.out.println("Reading file content:");

            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}