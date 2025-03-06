package main;

public class Queen extends Piece {
    public Queen(String color, int row, int col) {
        super(color, row, col, color.equals("white") ? "\u2655" : "\u265B");
    }

    @Override
    public boolean isValidMove(int startRow, int startCol, int endRow, int endCol, String[][] board) {
        // Not implemented yet
        return false;
    }
}
