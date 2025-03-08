package main.utils;
import java.util.Scanner;


public class InputUtils {

    public static int getValidInput() {
        Scanner scanner = new Scanner(System.in);
        int userInput;

        while (true) {
            System.out.print("Enter 1, 2, or 3: ");

            if (scanner.hasNextInt()) {
                userInput = scanner.nextInt();
                if (userInput == 1 || userInput == 2 || userInput == 3) {
                    return userInput; // Valid input, return the value
                } else {
                    System.out.println("Invalid input. Please enter 1, 2, or 3.");
                }
            } else {
                System.out.println("Invalid input. Please enter 1, 2, or 3.");
                scanner.next(); // Consume the invalid input to prevent infinite loop
            }
        }
    }

    public static void main(String[] args) {
        int input = getValidInput();
        System.out.println("You entered: " + input);
    }
}