package main.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TxtReader {

    public static void printFile(String fileName) {// specifically grabs from the art dir folder 
        try (InputStream inputStream = TxtReader.class.getResourceAsStream("/main/art/" + fileName);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            if (inputStream == null) {
                System.err.println("File not found in classpath: art/" + fileName);
                return;
            }

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