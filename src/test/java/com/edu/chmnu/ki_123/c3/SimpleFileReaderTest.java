package com.edu.chmnu.ki_123.c3;

import org.junit.jupiter.api.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleFileReaderTest {
    private static final String testFilePath = "src/file_for_test.txt";
    private final String testContent = "Test data";
    private static File testFile;

    @BeforeAll
    static void setup() {
        testFile = new File(testFilePath);
    }

    @Test
    void testFileCreation() {
        try {
            if (!testFile.exists()) {
                boolean isCreated = testFile.createNewFile();
                assertTrue(isCreated, "File should be created.");
            }
        } catch (IOException e) {
            fail("Exception during file creation: " + e.getMessage());
        }
    }

    @Test
    void testFileWriting() {
        try (FileWriter writer = new FileWriter(testFile)) {
            writer.write(testContent);
        } catch (IOException e) {
            fail("Exception during file writing: " + e.getMessage());
        }
    }

    @Test
    void testFileReading() {
        StringBuilder readContent = new StringBuilder();
        try (FileReader reader = new FileReader(testFile)) {
            int c;
            while ((c = reader.read()) != -1) {
                readContent.append((char) c);
            }
            assertEquals(testContent, readContent.toString(), "File content should match the written content.");
        } catch (IOException e) {
            fail("Exception during file reading: " + e.getMessage());
        }
    }
}