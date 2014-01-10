package tictactoe;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Created by Taryn on 1/6/14.
 */
public class Game {
    public CLIBoard board;
    public Player playerOne;
    public Player playerTwo;
    public Player playerFirstMove;
    public UI ui;

    public Game() {
        this.board = new CLIBoard();
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

    public void playGame() {
        while (!gameOver()) {
            Player player = currentPlayer();
            ui.nextMoveMessage(player.marker);
            int move = ui.getNextMove();
            player.addMarker(board, move);
            board.printBoard();
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
