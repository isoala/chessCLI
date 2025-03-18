package main.game;

import main.board.Board;
import main.board.Move;
import main.pieces.Piece;
import java.util.ArrayList;
import java.util.List;

public class AI {

    private int difficulty;

    public AI(int difficulty) {
        this.difficulty = difficulty;
    }

    public Move getMove(Board board, String aiColor) {
        int depth = getSearchDepth(difficulty);
        return minimax(board.copy(), depth, true, aiColor).move;
    }

    private MinimaxResult minimax(Board board, int depth, boolean maximizingPlayer, String aiColor) {
        if (depth == 0 || board.isGameOver()) {
            return new MinimaxResult(evaluateBoard(board, aiColor), null);
        }

        String currentColor = maximizingPlayer ? aiColor : (aiColor.equals("white") ? "black" : "white");
        List<Move> moves = generatePossibleMoves(board, currentColor);

        if (maximizingPlayer) {
            int maxEval = Integer.MIN_VALUE;
            Move bestMove = null;
            for (Move move : moves) {
                Board newBoard = board.copy();
                newBoard.executeMove(move);
                int eval = minimax(newBoard, depth - 1, false, aiColor).score;
                if (eval > maxEval) {
                    maxEval = eval;
                    bestMove = move;
                }
            }
            return new MinimaxResult(maxEval, bestMove);
        } else {
            int minEval = Integer.MAX_VALUE;
            Move bestMove = null;
            for (Move move : moves) {
                Board newBoard = board.copy();
                newBoard.executeMove(move);
                int eval = minimax(newBoard, depth - 1, true, aiColor).score;
                if (eval < minEval) {
                    minEval = eval;
                    bestMove = move;
                }
            }
            return new MinimaxResult(minEval, bestMove);
        }
    }

    private List<Move> generatePossibleMoves(Board board, String color) {
        List<Move> moves = new ArrayList<>();
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = board.getSquare(row, col).getPiece();
                if (piece != null && piece.getColor().equals(color)) {
                    List<Move> pieceMoves = piece.getPossibleMoves(board, row, col);
                    moves.addAll(pieceMoves);
                }
            }
        }
        return moves;
    }

    private int evaluateBoard(Board board, String aiColor) {
        int score = 0;
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = board.getSquare(row, col).getPiece();
                if (piece != null) {
                    int pieceValue = getPieceValue(piece);
                    if (piece.getColor().equals(aiColor)) {
                        score += pieceValue;
                    } else {
                        score -= pieceValue;
                    }
                }
            }
        }
        return score;
    }

    private int getPieceValue(Piece piece) {
        if (piece == null) {
            return 0;
        }
        switch (piece.getType()) {
            case "Pawn":
                return 1;
            case "Knight":
            case "Bishop":
                return 3;
            case "Rook":
                return 5;
            case "Queen":
                return 9;
            case "King":
                return 100;
            default:
                return 0;
        }
    }

    private int getSearchDepth(int difficulty) {
        switch (difficulty) {
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 6;
            default:
                return 2;
        }
    }

    private static class MinimaxResult {
        int score;
        Move move;

        MinimaxResult(int score, Move move) {
            this.score = score;
            this.move = move;
        }
    }
}