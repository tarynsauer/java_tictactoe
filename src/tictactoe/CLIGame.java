package tictactoe;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Created by Taryn on 1/10/14.
 */
public class CLIGame extends Game {
    public CLIBoard board;
    public Player playerOne;
    public Player playerTwo;
    public Player playerFirstMove;
    public UI ui;

    public CLIGame() {
        this.board = new CLIBoard(new PrintStream(new OutputStream() {
            @Override
            public void write(int i) throws IOException {
            }
        }));
        this.playerOne = new HumanPlayer("X");
        this.playerTwo = new HumanPlayer("O");
        this.playerFirstMove = getPlayerFirstMove();
        this.ui = new UI(new PrintStream(new OutputStream() {
            @Override
            public void write(int i) throws IOException {
            }
        }));
    }

//    public static void main(String[] args) throws IOException {
//        CLIGame newGame = new CLIGame();
//        newGame.startGame();
//        newGame.playGame();
//    }
//
//    public void startGame() {
//        ui.firstMoveMessage(playerFirstMove.getMarker());
//        board.printBoard();
//        playGame();
//    }

//    public void playGame() {
//        while (!gameOver()) {
//            Player player = currentPlayer();
//            ui.nextMoveMessage(player.getMarker());
//            int move = ui.getNextMove();
//            player.addMarker(board, move);
//            board.printBoard();
//        }
//    }
}
