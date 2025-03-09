package main.utils;


import java.util.Scanner;

public class InputUtils {

    private static final Scanner scanner = new Scanner(System.in);

    public static int getValidInput() {
        while (true) {
            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                scanner.nextLine(); // Consume newline left-over
                return input;
            } else {
                System.out.println("Invalid input. Please enter 1, 2, or 3.");
                scanner.nextLine(); // Consume invalid input
            }
        }
    }
}