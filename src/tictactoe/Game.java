package tictactoe;

import com.sun.tools.doclets.internal.toolkit.util.SourceToHTMLConverter;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Created by Taryn on 1/6/14.
 */
public class Game {
    public Board board;
    public Player playerOne;
    public Player playerTwo;
    public Player playerFirstMove;
    public UI ui;

    public Game() {
        this.board = new Board();
        this.playerOne = new HumanPlayer("X");
        this.playerTwo = new HumanPlayer("O");
        this.playerFirstMove = getPlayerFirstMove();
        this.ui = new UI(new PrintStream(new OutputStream() {
            @Override
            public void write(int i) throws IOException {
            }
        }));
    }

    public Player currentPlayer() {
        int markerX = countMarker("X");
        int markerO = countMarker("O");
        if (markerX > markerO) {
            return playerTwo;
        } else if (markerO > markerX) {
            return playerOne;
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

    public String winningMarker() {
        if (board.winningGame("X")) {
            return "X";
        } else if (board.winningGame("O")) {
            return "O";
        }
        return "tie game!";
    }

    public boolean gameOver() {
        if (board.winningGame("X") || board.winningGame("O")) {
            String winner = winningMarker();
            ui.winningGameMessage(winner);
            return true;
        } else if (!board.hasAvailableCell()) {
            ui.tieGameMessage();
           return true;
        } else {
           return false;
        }
    }

    private Integer countMarker(String marker) {
        int markerCount = 0;
        for (int i = 0; i < board.getCells().length; i++) {
            if (board.getCells()[i] == marker) {
                markerCount += 1;
            }
        }
        return markerCount;
    }

}
