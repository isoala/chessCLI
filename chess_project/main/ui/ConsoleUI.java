package main.ui;

import main.board.Board;
import main.Piece;
import main.board.Square;

public class ConsoleUI {

    public void printBoard(Board board) {
        Square[][] squares = board.getBoardArray();
        System.out.println("  +---+---+---+---+---+---+---+---+");
        for (int i = 0; i < 8; i++) {
            System.out.print(8 - i + " |");
            for (int j = 0; j < 8; j++) {
                Piece piece = squares[i][j].getPiece();
                String symbol = (piece != null) ? piece.getSymbol() : " ";
                System.out.print(" " + symbol + " |");
            }
            System.out.println();
            System.out.println("  +---+---+---+---+---+---+---+---+");
        }
        System.out.println("    a   b   c   d   e   f   g   h  ");
    }
}