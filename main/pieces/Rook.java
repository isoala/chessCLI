package main.pieces;

import main.board.Board;
import main.board.Move;

public class Rook extends Piece {

    public Rook(String color, int row, int col) {
        super(color, row, col, color.equals("white") ? "\u2656" : "\u265C");
    }

    @Override
    public boolean isValidMove(Move move, Board board) {
        int startRow = move.getStartRow();
        int startCol = move.getStartCol();
        int endRow = move.getEndRow();
        int endCol = move.getEndCol();

        if (startRow != endRow && startCol != endCol) {
            return false; // Rook moves horizontally or vertically
        }

        if (startRow == endRow) { // Horizontal move
            int colDirection = (endCol > startCol) ? 1 : -1;
            for (int col = startCol + colDirection; col != endCol; col += colDirection) {
                if (board.getSquare(startRow, col).getPiece() != null) {
                    return false; // Path is blocked
                }
            }
        } else { // Vertical move
            int rowDirection = (endRow > startRow) ? 1 : -1;
            for (int row = startRow + rowDirection; row != endRow; row += rowDirection) {
                if (board.getSquare(row, startCol).getPiece() != null) {
                    return false; // Path is blocked
                }
            }
        }

        // Check if the destination square is empty or has an opponent's piece
        Piece destinationPiece = board.getSquare(endRow, endCol).getPiece();
        if (destinationPiece != null && destinationPiece.getColor().equals(getColor())) {
            return false; // Cannot capture own piece
        }

        return true; // Valid Rook move
    }

    @Override
    public String getSymbol() {
        return symbol;
    }
}