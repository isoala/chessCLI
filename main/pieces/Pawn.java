package main.pieces;

import main.board.Board;
import main.board.Move;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public Piece copy() {
        return new Pawn(this.getColor(), this.getRow(), this.getCol());
    }

    @Override
    public List<Move> getPossibleMoves(Board board, int row, int col) {
        List<Move> moves = new ArrayList<>();
        int direction = getColor().equals("white") ? -1 : 1; // 1 for black, -1 for white
        int startRow = row;
        int startCol = col;

        // Single forward move
        int forwardRow = startRow + direction;
        if (forwardRow >= 0 && forwardRow < 8 && board.getSquare(forwardRow, startCol).getPiece() == null) {
            moves.add(new Move(startRow, startCol, forwardRow, startCol));

            // Double forward move from starting position
            if ((getColor().equals("white") && startRow == 6) || (getColor().equals("black") && startRow == 1)) {
                int doubleForwardRow = startRow + 2 * direction;
                if (board.getSquare(doubleForwardRow, startCol).getPiece() == null) {
                    moves.add(new Move(startRow, startCol, doubleForwardRow, startCol));
                }
            }
        }

        // Diagonal captures
        int leftCaptureCol = startCol - 1;
        int rightCaptureCol = startCol + 1;
        if (leftCaptureCol >= 0 && forwardRow >= 0 && forwardRow < 8) {
            Piece leftCapturePiece = board.getSquare(forwardRow, leftCaptureCol).getPiece();
            if (leftCapturePiece != null && !leftCapturePiece.getColor().equals(getColor())) {
                moves.add(new Move(startRow, startCol, forwardRow, leftCaptureCol));
            }
        }
        if (rightCaptureCol < 8 && forwardRow >= 0 && forwardRow < 8) {
            Piece rightCapturePiece = board.getSquare(forwardRow, rightCaptureCol).getPiece();
            if (rightCapturePiece != null && !rightCapturePiece.getColor().equals(getColor())) {
                moves.add(new Move(startRow, startCol, forwardRow, rightCaptureCol));
            }
        }

        return moves;
    }
    @Override
    public String getType() {
        return "Pawn";
    }
}