package main.game;
import main.board.*;
import main.ui.*;

public class Game {
    private Board board;
    private ConsoleUI ui;

    public Game(Player player) {
        this.board = new Board();
        this.ui = new ConsoleUI();
    }

    public void start() {
        ui.printBoard(board);
        // Add game loop here (player input, move validation, etc.)
    }
}