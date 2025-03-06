package main.pieces;

import main.Piece;

public class King extends Piece {
    public King(String color, int row, int col) {
        super(color, row, col, color.equals("white") ? "\u2654" : "\u265A");
    }

    @Override
    public boolean isValidMove(int startRow, int startCol, int endRow, int endCol, String[][] board) {
        // Not implemented yet
        return false;
    }
}
