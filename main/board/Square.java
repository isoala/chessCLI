package main.board;

import main.pieces.Piece;

public class Square {
    private int row;
    private int col;
    private Piece piece;

    public Square(int row, int col, Piece piece) {
        this.row = row;
        this.col = col;
        this.piece = piece;
    }

    // Copy Constructor
    public Square(Square other) {
        this.row = other.row;
        this.col = other.col;
        if (other.piece != null) {
            this.piece = other.piece.copy(); 
        } else {
            this.piece = null;
        }
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}