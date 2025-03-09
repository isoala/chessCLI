//use someone elses AI, im too lazy and dont know how to make my own robot.

package main.game;

import main.board.Board;
import main.board.Move;
import java.util.List;

public class AI {

    private int difficulty;

    public AI(int difficulty) {
        this.difficulty = difficulty;
    }

    public Move getMove(Board board, String aiColor) {
        // Implement AI logic here
        // Use the difficulty level to adjust the AI's strength
        // Return a Move object
        // Example (very basic):
        List<Move> possibleMoves = generatePossibleMoves(board, aiColor);
        if(!possibleMoves.isEmpty()){
            return possibleMoves.get(0);
        }
        return null; // No move found
    }

    private List<Move> generatePossibleMoves(Board board, String color){
        //logic to generate possible moves.
        return null;
    }
}