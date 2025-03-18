package main.pieces;

import main.board.Board;
import main.board.Move;
import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {

    public Knight(String color, int row, int col) {
        super(color, row, col, color.equals("white") ? "\u2658" : "\u265E");
    }

    @Override
    public boolean isValidMove(Move move, Board board) {
        int startRow = move.getStartRow();
        int startCol = move.getStartCol();
        int endRow = move.getEndRow();
        int endCol = move.getEndCol();

        int rowDiff = Math.abs(endRow - startRow);
        int colDiff = Math.abs(endCol - startCol);

        // Knight moves in an L-shape: 2 squares in one direction, 1 square in the other
        if ((rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2)) {
            Piece destinationPiece = board.getSquare(endRow, endCol).getPiece();
            // Check if the destination square is empty or has an opponent's piece
            if (destinationPiece == null || !destinationPiece.getColor().equals(getColor())) {
                return true; // Valid Knight move
            }
        }
        return false; // Invalid Knight move
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public Piece copy() {
        return new Knight(this.getColor(), this.getRow(), this.getCol());
    }

    @Override
    public List<Move> getPossibleMoves(Board board, int row, int col) {
        List<Move> moves = new ArrayList<>();
        int[][] possibleMoves = {
                {-2, -1}, {-2, 1}, {-1, -2}, {-1, 2},
                {1, -2}, {1, 2}, {2, -1}, {2, 1}
        };

        for (int[] move : possibleMoves) {
            int newRow = row + move[0];
            int newCol = col + move[1];

            if (newRow >= 0 && newRow < 8 && newCol >= 0 && newCol < 8) {
                Piece destinationPiece = board.getSquare(newRow, newCol).getPiece();
                if (destinationPiece == null || !destinationPiece.getColor().equals(getColor())) {
                    moves.add(new Move(row, col, newRow, newCol));
                }
            }
        }
        return moves;
    }
    @Override
    public String getType() {
        return "Knight";
    }
}