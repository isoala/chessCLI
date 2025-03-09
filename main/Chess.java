package main;

import main.game.*;
import main.utils.*;

public class Chess {

    public static void main(String[] args) {

        TxtReader.printFile("art.txt");

        // color selection
        System.out.println("Select your color:");
        System.out.println("1. White");
        System.out.println("2. Black");

        Player player = null;

        while (player == null) {
            int colorChoice = InputUtils.getValidInput(1, 2);

            if (colorChoice == 1) {
                player = new Player("white");
                break; // Exit the loop after a valid choice
            } else if (colorChoice == 2) {
                player = new Player("black");
                break; // Exit the loop after a valid choice
            } else {
                System.out.println("Invalid, Please enter 1 or 2.");
            }
        }

        System.out.println("Select difficulty:");
        System.out.println("1. Easy");
        System.out.println("2. Medium");
        System.out.println("3. Hard");

        int difficultyChoice = InputUtils.getValidInput(1, 3);
        System.out.println("You entered: " + difficultyChoice);

        Game game = new Game(player, difficultyChoice);
        game.start();
    }
}