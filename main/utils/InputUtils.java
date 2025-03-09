package main.utils;

import java.util.Scanner;

public class InputUtils {

    public static int getValidInput() {
        Scanner scanner = new Scanner(System.in);
        int userInput;

        while (true) {
            if (scanner.hasNextInt()) {
                userInput = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                return userInput; // Return any integer
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine(); // Consume the invalid input line
            }
        }
    }

    public static int getValidInput(int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int userInput;

        while (true) {
            if (scanner.hasNextInt()) {
                userInput = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                if (userInput >= min && userInput <= max) {
                    return userInput; // Valid input, return the value
                } else {
                    System.out.println("Invalid input. Please enter a number between " + min + " and " + max + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine(); // Consume the invalid input line
            }
        }
    }
}