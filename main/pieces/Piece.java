package main.pieces;

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

    public abstract boolean isValidMove(int startRow, int startCol, int endRow, int endCol, String[][] board);

    public String getSymbol() {
        return symbol;
    }

    public String getColor() {
        return color;
    }
     public int getRow(){
         return row;
     }
     public int getCol(){
         return col;
     }
     public void setRow(int row){
         this.row = row;
     }
     public void setCol(int col){
         this.col = col;
     }
}
