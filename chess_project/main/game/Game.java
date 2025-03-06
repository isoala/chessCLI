package main.game;
import main.board.Board;
import main.ui.ConsoleUI;

public class Game {
    private Board board;
    private ConsoleUI ui;

    public Game() {
        this.board = new Board();
        this.ui = new ConsoleUI();
    }

    public void start() {
        ui.printBoard(board);
        // Add game loop here (player input, move validation, etc.)
    }
}