package main.pieces;

import main.board.Board;
import main.board.Move;

public class Queen extends Piece {

    public Queen(String color, int row, int col) {
        super(color, row, col, color.equals("white") ? "\u2655" : "\u265B");
    }

    @Override
    public boolean isValidMove(Move move, Board board) {
        int startRow = move.getStartRow();
        int startCol = move.getStartCol();
        int endRow = move.getEndRow();
        int endCol = move.getEndCol();

        int rowDiff = Math.abs(endRow - startRow);
        int colDiff = Math.abs(endCol - startCol);

        // Queen moves like a Rook or Bishop
        if (rowDiff == 0 || colDiff == 0 || rowDiff == colDiff) {
            // Check for obstructions
            if (rowDiff == 0) { // Horizontal move
                int colDirection = (endCol > startCol) ? 1 : -1;
                for (int col = startCol + colDirection; col != endCol; col += colDirection) {
                    if (board.getSquare(startRow, col).getPiece() != null) {
                        return false; // Path is blocked
                    }
                }
            } else if (colDiff == 0) { // Vertical move
                int rowDirection = (endRow > startRow) ? 1 : -1;
                for (int row = startRow + rowDirection; row != endRow; row += rowDirection) {
                    if (board.getSquare(row, startCol).getPiece() != null) {
                        return false; // Path is blocked
                    }
                }
            } else { // Diagonal move
                int rowDirection = (endRow > startRow) ? 1 : -1;
                int colDirection = (endCol > startCol) ? 1 : -1;
                int currentRow = startRow + rowDirection;
                int currentCol = startCol + colDirection;

                while (currentRow != endRow) {
                    if (board.getSquare(currentRow, currentCol).getPiece() != null) {
                        return false; // Path is blocked
                    }
                    currentRow += rowDirection;
                    currentCol += colDirection;
                }
            }

            // Check if the destination square is empty or has an opponent's piece
            Piece destinationPiece = board.getSquare(endRow, endCol).getPiece();
            if (destinationPiece != null && destinationPiece.getColor().equals(getColor())) {
                return false; // Cannot capture own piece
            }

            return true; // Valid Queen move
        }

        return false; // Invalid Queen move
    }

    @Override
    public String getSymbol() {
        return symbol;
    }
}