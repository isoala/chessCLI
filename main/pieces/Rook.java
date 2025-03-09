package main.pieces;

public class Rook extends Piece {
    public Rook(String color, int row, int col) {
        super(color, row, col, color.equals("white") ? "\u2656" : "\u265C");
    }

    @Override
    public boolean isValidMove(int startRow, int startCol, int endRow, int endCol, String[][] board) {
        // Not implemented yet
        return false;
    }
}
