package main.board;

import main.Piece;

public class Square {
    private int row;
    private int col;
    private Piece piece;

    public Square(int row, int col, Piece piece) {
        this.row = row;
        this.col = col;
        this.piece = piece;
    }
    //returns the row, col, pieces.
    public int getRow() { return row; }
    public int getCol() { return col; }
    public Piece getPiece() { return piece; }
    public void setPiece(Piece piece) { this.piece = piece; }
}