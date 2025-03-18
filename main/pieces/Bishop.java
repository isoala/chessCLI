package main.pieces;

import main.board.Board;
import main.board.Move;
import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece {

    public Bishop(String color, int row, int col) {
        super(color, row, col, color.equals("white") ? "\u2657" : "\u265D");
    }

    @Override
    public boolean isValidMove(Move move, Board board) {
        int startRow = move.getStartRow();
        int startCol = move.getStartCol();
        int endRow = move.getEndRow();
        int endCol = move.getEndCol();

        // Check if the move is diagonal
        if (Math.abs(endRow - startRow) != Math.abs(endCol - startCol)) {
            return false;
        }

        // Check for obstructions along the diagonal
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

        // Check if the destination square is empty or has an opponent's piece
        Piece destinationPiece = board.getSquare(endRow, endCol).getPiece();
        if (destinationPiece != null && destinationPiece.getColor().equals(getColor())) {
            return false; // Cannot capture own piece
        }

        return true; // Valid Bishop move
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public Piece copy() {
        return new Bishop(this.getColor(), this.getRow(), this.getCol());
    }

    @Override
    public List<Move> getPossibleMoves(Board board, int row, int col) {
        List<Move> moves = new ArrayList<>();
        int[] rowDirections = {1, 1, -1, -1};
        int[] colDirections = {1, -1, 1, -1};

        for (int i = 0; i < 4; i++) {
            int rowDirection = rowDirections[i];
            int colDirection = colDirections[i];
            int currentRow = row + rowDirection;
            int currentCol = col + colDirection;

            while (currentRow >= 0 && currentRow < 8 && currentCol >= 0 && currentCol < 8) {
                Piece currentPiece = board.getSquare(currentRow, currentCol).getPiece();
                if (currentPiece == null) {
                    moves.add(new Move(row, col, currentRow, currentCol));
                } else {
                    if (!currentPiece.getColor().equals(getColor())) {
                        moves.add(new Move(row, col, currentRow, currentCol)); // Capture
                    }
                    break; // Path is blocked
                }
                currentRow += rowDirection;
                currentCol += colDirection;
            }
        }
        return moves;
    }
    @Override
    public String getType() {
        return "Bishop";
    }
}