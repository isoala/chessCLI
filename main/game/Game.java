package main.game;

import main.board.Board;
import main.board.Move;
import main.ui.InputParser;
import main.ui.ConsoleUI;
import java.util.Scanner;

public class Game {

    private GameState gameState;
    private InputParser parser;
    private Player player;
    private AI ai;
    private int difficulty;
    private Scanner scanner;
    private ConsoleUI ui;

    public Game(Player player, int difficulty) {
        Board board = new Board();
        this.gameState = new GameState(board, "white");
        this.parser = new InputParser();
        this.player = player;
        this.difficulty = difficulty;
        this.scanner = new Scanner(System.in);
        this.ai = new AI(difficulty);
        this.ui = new ConsoleUI();
    }

    public void start() {
        ui.printBoard(gameState.getBoard());
        while (true) {
            if (gameState.getCurrentPlayerColor().equals(player.getColor())) {
                playerTurn();
            } else {
                aiTurn();
            }
            if (/* check for checkmate or stalemate */ false) {
                break;
            }
            togglePlayer();
        }
    }

    private void playerTurn() {
        System.out.print(player.getColor() + "'s turn. Enter move (e.g., a2a4, or 'print' to reprint board): ");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("print")) {
            ui.printBoard(gameState.getBoard());
            playerTurn(); // Prompt again
            return;
        }

        Move move = parser.parseMove(input);

        if (move != null && gameState.getBoard().isValidMove(move, player)) {
            gameState.getBoard().executeMove(move);
            ui.printBoard(gameState.getBoard());
        } else {
            System.out.println("Invalid move. Try again.");
            playerTurn();
        }
    }

    private void aiTurn() {
        System.out.println("AI's turn...");
        Move move = ai.getMove(gameState.getBoard(), (player.getColor().equals("white") ? "black" : "white"));
        if (move != null) {
            gameState.getBoard().executeMove(move);
            ui.printBoard(gameState.getBoard());
        } else {
            System.out.println("AI could not find a valid move.");
        }
    }

    private void togglePlayer() {
        gameState.setCurrentPlayerColor(gameState.getCurrentPlayerColor().equals("white") ? "black" : "white");
    }

    public int getDifficulty() {
        return difficulty;
    }
}