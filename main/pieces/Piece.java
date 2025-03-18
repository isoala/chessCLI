package main.pieces;

import main.board.Board;
import main.board.Move;

public abstract class Piece {
    protected String color;
    protected int row;
    protected int col;
    protected String symbol;

    public Piece(String color, int row, int col, String symbol) {
        this.color = color;
        this.row = row;
        this.col = col;
        this.symbol = symbol;
    }

    public abstract boolean isValidMove(Move move, Board board);

    public String getColor() {
        return color;
    }

    public abstract String getSymbol();

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }
    public abstract Piece copy();

    public abstract String getType();

    public abstract java.util.List<Move> getPossibleMoves(Board board, int row, int col);

}