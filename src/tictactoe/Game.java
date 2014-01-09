package tictactoe;

import java.util.HashMap;

/**
 * Created by Taryn on 1/6/14.
 */
public class Game {
    public Board board;
    public Player playerOne;
    public Player playerTwo;
    public Player playerFirstMove;

    public Game() {
        this.board = new Board();
        this.playerOne = new HumanPlayer("X");
        this.playerTwo = new HumanPlayer("O");
        this.playerFirstMove = getPlayerFirstMove();
    }

    public Player currentPlayer() {
        int markerX = countMarker("X");
        int markerO = countMarker("O");
        if (markerX > markerO) {
            return playerOne;
        } else if (markerO > markerX) {
            return playerTwo;
        } else {
            return playerFirstMove;
        }
    }

    public Player getPlayerFirstMove() {
        int rand = (Math.random() < 0.5) ? 0 : 1;
        if (rand == 0) {
          return playerOne;
        } else {
          return playerTwo;
        }
    }

    private Integer countMarker(String marker) {
        int markerCount = 0;
        for (int i = 0; i < board.cells.length; i++) {
            if (board.cells[i] == marker) {
                markerCount += 1;
            }
        }
        return markerCount;
    }
}
