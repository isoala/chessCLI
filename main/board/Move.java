package main.board;

import main.pieces.Piece;

public class Move {
    private Square startSquare;
    private Square endSquare;
    private Piece movedPiece;
    private Piece capturedPiece;

    public Move(Square startSquare, Square endSquare, Piece movedPiece, Piece capturedPiece) {
        this.startSquare = startSquare;
        this.endSquare = endSquare;
        this.movedPiece = movedPiece;
        this.capturedPiece = capturedPiece;
    }

    public Square getStartSquare() {
        return startSquare;
    }

    public Square getEndSquare() {
        return endSquare;
    }

    public Piece getMovedPiece() {
        return movedPiece;
    }

    public Piece getCapturedPiece() {
        return capturedPiece;
    }

    // You can add more methods here ex. toString() for debugging
    @Override
    public String toString() {
        return movedPiece.getSymbol() + ": " + startSquare.getRow() + "," + startSquare.getCol() + " to " + endSquare.getRow() + "," + endSquare.getCol();
    }
}