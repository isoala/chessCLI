package main;

public class Main {

    public static void main(String[] args) {
        
        Piece[][] board = createBoard();

        
        initializeBoard(board);
        
        //System.out.println("Hello, World!");
        printBoard(board);
    }

    private static Piece[][] createBoard() {
        Piece[][] board = new Piece[8][8];
        return board; 
    }



    private static void initializeBoard(Piece[][] board) {
        
        //unicode has been moved to extended piece classes


        // Black pieces 
        board[0][4] = new King("black", 0, 4);
        board[0][3] = new Queen("black", 0, 3);
        board[0][0] = new Rook("black", 0, 0);
        board[0][7] = new Rook("black", 0, 7);
        board[0][2] = new Bishop("black", 0, 2);
        board[0][5] = new Bishop("black", 0, 5);
        board[0][1] = new Knight("black", 0, 1);
        board[0][6] = new Knight("black", 0, 6);
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn("black", 1, i);
        }

        // White pieces
        board[7][4] = new King("white", 7, 4);
        board[7][3] = new Queen("white", 7, 3);
        board[7][0] = new Rook("white", 7, 0);
        board[7][7] = new Rook("white", 7, 7);
        board[7][2] = new Bishop("white", 7, 2);
        board[7][5] = new Bishop("white", 7, 5);
        board[7][1] = new Knight("white", 7, 1);
        board[7][6] = new Knight("white", 7, 6);
        for (int i = 0; i < 8; i++) {
            board[6][i] = new Pawn("white", 6, i);
        }
    }


    private static void printBoard(Piece[][] board) {
        System.out.println("  +---+---+---+---+---+---+---+---+");
        for (int i = 0; i < 8; i++) {
            System.out.print(8 - i + " |"); // Print row number
            for (int j = 0; j < 8; j++) {
                Piece piece = board[i][j]; // Get the Piece object (or null)
                String symbol = (piece != null) ? piece.getSymbol() : " "; //get the symbol or a space.
                System.out.print(" " + symbol + " |"); // Use the symbol
            }
            System.out.println();
            System.out.println("  +---+---+---+---+---+---+---+---+");
        }
        System.out.println("    a   b   c   d   e   f   g   h  "); // Print column letters
    }
    }
