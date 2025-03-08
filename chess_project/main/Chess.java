package main;

import main.game.*;
import main.utils.*;



public class Chess {
    
    public static void main(String[] args) {

        String filePath = "chess_project/main/art/art.txt";
        TxtReader.printFile(filePath);
        
        
        // Get user input (1, 2, or 3)
        int input = InputUtils.getValidInput();
        System.out.println("You entered: " + input);

        // Prompt user for color selection
        System.out.println("Select your color:");
        System.out.println("1. White");
        System.out.println("2. Black");

        int colorChoice = InputUtils.getValidInput(); // Get color choice (1 or 2)

        Player player;
        if (colorChoice == 1) {
            player = new Player("white");
        } else {
            player = new Player("black");
        }




        Game game = new Game(player);
        game.start();
    }
}