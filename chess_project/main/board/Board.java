package main.board;

//import main.Piece; //ig i dont need this anymore
import main.pieces.*;

public class Board {
    private Square[][] squares;

    public Board() { 
        squares = new Square[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                squares[i][j] = new Square(i, j, null);
            }
        }
        initializeBoard();
    }

    private void initializeBoard() {
        // Black pieces
        squares[0][4].setPiece(new King("black", 0, 4));
        squares[0][3].setPiece(new Queen("black", 0, 3));
        squares[0][0].setPiece(new Rook("black", 0, 0));
        squares[0][7].setPiece(new Rook("black", 0, 7));
        squares[0][2].setPiece(new Bishop("black", 0, 2));
        squares[0][5].setPiece(new Bishop("black", 0, 5));
        squares[0][1].setPiece(new Knight("black", 0, 1));
        squares[0][6].setPiece(new Knight("black", 0, 6));
        for (int i = 0; i < 8; i++) {
            squares[1][i].setPiece(new Pawn("black", 1, i));
        }

        // White pieces
        squares[7][4].setPiece(new King("white", 7, 4));
        squares[7][3].setPiece(new Queen("white", 7, 3));
        squares[7][0].setPiece(new Rook("white", 7, 0));
        squares[7][7].setPiece(new Rook("white", 7, 7));
        squares[7][2].setPiece(new Bishop("white", 7, 2));
        squares[7][5].setPiece(new Bishop("white", 7, 5));
        squares[7][1].setPiece(new Knight("white", 7, 1));
        squares[7][6].setPiece(new Knight("white", 7, 6));
        for (int i = 0; i < 8; i++) {
            squares[6][i].setPiece(new Pawn("white", 6, i));
        }
    }
    public Square getSquare(int row, int col){
        return squares[row][col];
    }
    public Square[][] getBoardArray(){
        return squares;
    }
}