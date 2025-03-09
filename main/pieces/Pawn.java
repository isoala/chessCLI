package main.pieces;

import main.board.Board;
import main.board.Move;

public class Pawn extends Piece {

    public Pawn(String color, int row, int col) {
        super(color, row, col, color.equals("white") ? "\u2659" : "\u265F");
    }

    @Override
    public boolean isValidMove(Move move, Board board) {
        int startRow = move.getStartRow();
        int startCol = move.getStartCol();
        int endRow = move.getEndRow();
        int endCol = move.getEndCol();
        int rowDiff = endRow - startRow;
        int colDiff = endCol - startCol;
        Piece destinationPiece = board.getSquare(endRow, endCol).getPiece();

        if (getColor().equals("white")) {
            if (colDiff == 0 && rowDiff == -1 && destinationPiece == null) {
                return true; // Single forward move
            } else if (colDiff == 0 && rowDiff == -2 && startRow == 6 && destinationPiece == null && board.getSquare(startRow - 1, startCol).getPiece() == null) {
                return true; // Double forward move from starting position
            } else if (Math.abs(colDiff) == 1 && rowDiff == -1 && destinationPiece != null && destinationPiece.getColor().equals("black")) {
                return true; // Diagonal capture
            }
        } else { // Black pawn
            if (colDiff == 0 && rowDiff == 1 && destinationPiece == null) {
                return true; // Single forward move
            } else if (colDiff == 0 && rowDiff == 2 && startRow == 1 && destinationPiece == null && board.getSquare(startRow + 1, startCol).getPiece() == null) {
                return true; // Double forward move from starting position
            } else if (Math.abs(colDiff) == 1 && rowDiff == 1 && destinationPiece != null && destinationPiece.getColor().equals("white")) {
                return true; // Diagonal capture
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }
}