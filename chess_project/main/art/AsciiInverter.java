package main.art;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//scrap this nonsense

public class AsciiInverter {

    public static void invertAndPrintAscii(String inputFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(invertLine(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String invertLine(String line) {
        StringBuilder invertedLine = new StringBuilder();
        for (char c : line.toCharArray()) {
            if (c == ' ') {
                invertedLine.append('#');
            } else if (c == '#') {
                invertedLine.append(' ');
            } else {
                invertedLine.append(c);
            }
        }
        return invertedLine.toString();
    }

    public static void main(String[] args) {//idk why i thought this would work
        String inputFile = "chess_project/main/art/art2.txt";
        invertAndPrintAscii(inputFile);
    }
}