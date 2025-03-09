package main.board;

public class Move {

    private int startRow;
    private int startCol;
    private int endRow;
    private int endCol;

    public Move(int startRow, int startCol, int endRow, int endCol) {
        this.startRow = startRow;
        this.startCol = startCol;
        this.endRow = endRow;
        this.endCol = endCol;
    }

    public int getStartRow() {
        return startRow;
    }

    public int getStartCol() {
        return startCol;
    }

    public int getEndRow() {
        return endRow;
    }

    public int getEndCol() {
        return endCol;
    }

    // Optional: Add toString() for debugging
    @Override
    public String toString() {
        return "Move{" +
                "startRow=" + startRow +
                ", startCol=" + startCol +
                ", endRow=" + endRow +
                ", endCol=" + endCol +
                '}';
    }
}