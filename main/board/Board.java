package main.board;

import main.pieces.*;
import java.util.ArrayList;
import java.util.List;

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
        // White pieces
        squares[7][0].setPiece(new Rook("white", 7, 0));
        squares[7][1].setPiece(new Knight("white", 7, 1));
        squares[7][2].setPiece(new Bishop("white", 7, 2));
        squares[7][3].setPiece(new Queen("white", 7, 3));
        squares[7][4].setPiece(new King("white", 7, 4));
        squares[7][5].setPiece(new Bishop("white", 7, 5));
        squares[7][6].setPiece(new Knight("white", 7, 6));
        squares[7][7].setPiece(new Rook("white", 7, 7));
        for (int i = 0; i < 8; i++) {
            squares[6][i].setPiece(new Pawn("white", 6, i));
        }

        // Black pieces
        squares[0][0].setPiece(new Rook("black", 0, 0));
        squares[0][1].setPiece(new Knight("black", 0, 1));
        squares[0][2].setPiece(new Bishop("black", 0, 2));
        squares[0][3].setPiece(new Queen("black", 0, 3));
        squares[0][4].setPiece(new King("black", 0, 4));
        squares[0][5].setPiece(new Bishop("black", 0, 5));
        squares[0][6].setPiece(new Knight("black", 0, 6));
        squares[0][7].setPiece(new Rook("black", 0, 7));
        for (int i = 0; i < 8; i++) {
            squares[1][i].setPiece(new Pawn("black", 1, i));
        }
    }

    public Square getSquare(int row, int col) {
        if (row >= 0 && row < 8 && col >= 0 && col < 8) {
            return squares[row][col];
        } else {
            return null;
        }
    }

    public Square[][] getBoardArray() {
        return squares;
    }

    public void displayBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece piece = squares[i][j].getPiece();
                if (piece != null) {
                    System.out.print(piece.getSymbol() + " ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    public boolean isValidMove(Move move, String color) {
        Square startSquare = getSquare(move.getStartRow(), move.getStartCol());
        Square endSquare = getSquare(move.getEndRow(), move.getEndCol());
        Piece piece = startSquare.getPiece();

        if (piece == null) {
            return false;
        }

        if (!piece.getColor().equals(color)) {
            return false;
        }

        return piece.isValidMove(move, this);
    }

    public void executeMove(Move move) {
        Square startSquare = getSquare(move.getStartRow(), move.getStartCol());
        Square endSquare = getSquare(move.getEndRow(), move.getEndCol());
        Piece piece = startSquare.getPiece();

        endSquare.setPiece(piece);
        startSquare.setPiece(null);

        piece.setRow(move.getEndRow());
        piece.setCol(move.getEndCol());
    }

    public List<Move> generatePossibleMoves(String color) {
        List<Move> possibleMoves = new ArrayList<>();
        for (int startRow = 0; startRow < 8; startRow++) {
            for (int startCol = 0; startCol < 8; startCol++) {
                Piece piece = getSquare(startRow, startCol).getPiece();
                if (piece != null && piece.getColor().equals(color)) {
                    possibleMoves.addAll(piece.getPossibleMoves(this, startRow, startCol));
                }
            }
        }
        return possibleMoves;
    }

    public Board(Board other) {
        this.squares = new Square[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                this.squares[i][j] = new Square(other.squares[i][j]); // Copy each square
            }
        }
    }

    public Board copy() {
        return new Board(this);
    }

    public boolean isGameOver() {
        // Check for checkmate
        if (isCheckmate("white") || isCheckmate("black")) {
            return true;
        }

        // Check for stalemate
        if (isStalemate("white") || isStalemate("black")) {
            return true;
        }

        return false; // Game is not over
    }

    private boolean isCheckmate(String color) {
        if (!isKingInCheck(color)) {
            return false; // King is not in check, so it's not checkmate
        }

        // Check if there are any legal moves to escape check
        List<Move> possibleMoves = generatePossibleMoves(color);
        for (Move move : possibleMoves) {
            Board tempBoard = copy();
            tempBoard.executeMove(move);
            if (!tempBoard.isKingInCheck(color)) {
                return false; // Found a move to escape check
            }
        }
        return true; // No moves to escape check, it's checkmate
    }

    private boolean isStalemate(String color) {
        if (isKingInCheck(color)) {
            return false; // King is in check, so it's not stalemate
        }

        // Check if there are any legal moves
        List<Move> possibleMoves = generatePossibleMoves(color);
        return possibleMoves.isEmpty(); // Stalemate if no legal moves
    }

    private boolean isKingInCheck(String color) {
        // Find the King's position
        int kingRow = -1, kingCol = -1;
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = getSquare(row, col).getPiece();
                if (piece instanceof King && piece.getColor().equals(color)) {
                    kingRow = row;
                    kingCol = col;
                    break;
                }
            }
            if (kingRow != -1) {
                break;
            }
        }

        // Check if any opponent piece can attack the King
        String opponentColor = color.equals("white") ? "black" : "white";
        List<Move> opponentMoves = generatePossibleMoves(opponentColor);
        for (Move move : opponentMoves) {
            if (move.getEndRow() == kingRow && move.getEndCol() == kingCol) {
                return true; // King is in check
            }
        }
        return false; // King is not in check
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = getSquare(row, col).getPiece();
                if (piece == null) {
                    sb.append(" . ");
                } else {
                    sb.append(" ").append(piece.getSymbol()).append(" ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}