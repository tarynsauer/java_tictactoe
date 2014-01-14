package tictactoe;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Created by Taryn on 1/10/14.
 */
public class CLIGame extends Game {
    private CLIBoard board;
    private Player playerOne;
    private Player playerTwo;
    private Player playerFirstMove;
    private UI ui;

    public CLIGame() {
        this.board = new CLIBoard();
        this.playerOne = new HumanPlayer("X");
        this.playerTwo = new HumanPlayer("O");
        this.playerFirstMove = getPlayerFirstMove();
        this.ui = new UI();
    }

    public void setUI(UI ui) {
        this.ui = ui;
    }

    public static void main(String[] args) throws IOException {
        CLIGame newGame = new CLIGame();
        newGame.startGame();
        newGame.playGame();
    }

    public void startGame() {
        ui.firstMoveMessage(playerFirstMove.getMarker());
        board.printBoard();
        playGame();
    }

    public void playGame() {
        while (!gameOver()) {
            Player player = currentPlayer();
            ui.nextMoveMessage(player.getMarker());
            String move = player.makeMove(board);
            player.addMarker(board, move);
            board.printBoard();
        }
        gameOutcome();
    }

    public void gameOutcome() {
        if (getBoard().winningGame("X")) {
            ui.winningGameMessage("X");
        } else if (getBoard().winningGame("O"))  {
            ui.winningGameMessage("O");
        } else {
            ui.tieGameMessage();
        }
    }
}
