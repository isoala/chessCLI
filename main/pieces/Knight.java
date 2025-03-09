package main.pieces;

import main.board.Board;
import main.board.Move;

public class Knight extends Piece {

    public Knight(String color, int row, int col) {
        super(color, row, col, color.equals("white") ? "\u2658" : "\u265E");
    }

    @Override
    public boolean isValidMove(Move move, Board board) {
        // Knight's move logic...
        return true; // Or false based on move validation
    }

    @Override
    public String getSymbol() {
        return symbol;
    }
}