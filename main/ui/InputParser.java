package main.ui;

import main.board.Move;

public class InputParser {

    public Move parseMove(String input) {
        if (input == null || input.length() < 2) {
            return null; // Invalid input
        }

        try {
            int startCol = input.charAt(0) - 'a';
            int startRow = 8 - (input.charAt(1) - '0');
            int endCol = input.charAt(2) - 'a';
            int endRow = 8 - (input.charAt(3) - '0');

            if (startRow >= 0 && startRow < 8 && startCol >= 0 && startCol < 8 &&
                endRow >= 0 && endRow < 8 && endCol >= 0 && endCol < 8) {
                return new Move(startRow, startCol, endRow, endCol);
            } else {
                return null; // Out of bounds
            }
        } catch (Exception e) {
            return null; // Parsing error
        }
    }
}