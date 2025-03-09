package main.pieces;

import main.board.Board;
import main.board.Move;

public class King extends Piece {

    public King(String color, int row, int col) {
        super(color, row, col, color.equals("white") ? "\u2654" : "\u265A");
    }

    @Override
    public boolean isValidMove(Move move, Board board) {
        int startRow = move.getStartRow();
        int startCol = move.getStartCol();
        int endRow = move.getEndRow();
        int endCol = move.getEndCol();

        int rowDiff = Math.abs(endRow - startRow);
        int colDiff = Math.abs(endCol - startCol);

        // Check if the move is one square in any direction
        if (rowDiff > 1 || colDiff > 1) {
            return false;
        }

        // Check if the destination square is empty or has an opponent's piece
        Piece destinationPiece = board.getSquare(endRow, endCol).getPiece();
        if (destinationPiece != null && destinationPiece.getColor().equals(getColor())) {
            return false; // Cannot capture own piece
        }

        return true; // Valid King move
    }

    @Override
    public String getSymbol() {
        return symbol;
    }
}