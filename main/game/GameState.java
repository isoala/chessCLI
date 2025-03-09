package main.game;

import main.board.Board;

public class GameState {
    private Board board;
    private String currentPlayerColor;

    public GameState(Board board, String currentPlayerColor) {
        this.board = board;
        this.currentPlayerColor = currentPlayerColor;
    }

    public Board getBoard() {
        return board;
    }

    public String getCurrentPlayerColor() {
        return currentPlayerColor;
    }

    public void setCurrentPlayerColor(String currentPlayerColor) {
        this.currentPlayerColor = currentPlayerColor;
    }
}