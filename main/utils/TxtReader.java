package main.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TxtReader {

    public static void printFile(String filePath) { //switched to grab string from Main.java


        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}