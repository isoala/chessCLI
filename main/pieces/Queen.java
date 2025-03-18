package main.pieces;

import main.board.Board;
import main.board.Move;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public Piece copy() {
        return new Queen(this.getColor(), this.getRow(), this.getCol());
    }

    @Override
    public List<Move> getPossibleMoves(Board board, int row, int col) {
        List<Move> moves = new ArrayList<>();
        int[][] directions = {
                {0, 1}, {0, -1}, {1, 0}, {-1, 0}, // Rook-like moves
                {1, 1}, {1, -1}, {-1, 1}, {-1, -1} // Bishop-like moves
        };

        for (int[] direction : directions) {
            int currentRow = row + direction[0];
            int currentCol = col + direction[1];

            while (currentRow >= 0 && currentRow < 8 && currentCol >= 0 && currentCol < 8) {
                Piece destinationPiece = board.getSquare(currentRow, currentCol).getPiece();
                if (destinationPiece == null) {
                    moves.add(new Move(row, col, currentRow, currentCol));
                } else {
                    if (!destinationPiece.getColor().equals(getColor())) {
                        moves.add(new Move(row, col, currentRow, currentCol)); // Capture
                    }
                    break; // Path is blocked
                }
                currentRow += direction[0];
                currentCol += direction[1];
            }
        }
        return moves;
    }
    @Override
    public String getType() {
        return "Queen";
    }
}