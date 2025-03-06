package main;

public class Pawn extends Piece {
    public Pawn(String color, int row, int col) {
        super(color, row, col, color.equals("white") ? "\u2657" : "\u265D");
    }

    @Override
    public boolean isValidMove(int startRow, int startCol, int endRow, int endCol, String[][] board) {
        // Not implemented yet
        return false;
    }
}
