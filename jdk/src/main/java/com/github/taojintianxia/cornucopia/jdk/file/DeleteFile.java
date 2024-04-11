package com.github.taojintianxia.cornucopia.jdk.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public final class DeleteFile {
    
    private static final File TEST_FILE = new File("/tmp/test.txt");
    
    public static void main(String[] args) throws Exception {
        createFile(TEST_FILE);
        deleteFileExample1(TEST_FILE);
        
        createFile(TEST_FILE);
        deleteFileExample2(TEST_FILE);
    }
    
    private static void createFile(File testFile) throws IOException {
        Files.createFile(testFile.toPath());
    }
    
    private static void deleteFileExample1(File testFile) {
        boolean result = testFile.delete();
        if (result) {
            System.out.println("File is deleted successfully");
        } else {
            System.out.println("Failed to delete the file");
        }
    }
    
    private static void deleteFileExample2(File testFile) throws IOException {
        Files.delete(testFile.toPath());
    }
}
