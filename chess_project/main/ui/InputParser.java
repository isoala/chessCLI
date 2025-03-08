package main.ui;

import main.board.Board;
import main.board.Move;
import main.board.Square;
import main.pieces.Piece;

public class InputParser {

    public Move parseMove(String input, Board board) {
        if (input == null || input.length() < 4) {
            return null; // Invalid input
        }

        try {
            int startCol = input.charAt(0) - 'a';
            int startRow = 7 - (input.charAt(1) - '1');
            int endCol = input.charAt(2) - 'a';
            int endRow = 7 - (input.charAt(3) - '1');

            if (startCol < 0 || startCol > 7 || startRow < 0 || startRow > 7 ||
                endCol < 0 || endCol > 7 || endRow < 0 || endRow > 7) {
                return null; // Out of bounds
            }

            Square startSquare = board.getSquare(startRow, startCol);
            Square endSquare = board.getSquare(endRow, endCol);
            Piece movedPiece = startSquare.getPiece();
            Piece capturedPiece = endSquare.getPiece();

            if (movedPiece == null) {
                return null; // No piece at start
            }

            return new Move(startSquare, endSquare, movedPiece, capturedPiece);

        } catch (Exception e) {
            return null; // Parsing error
        }
    }
}