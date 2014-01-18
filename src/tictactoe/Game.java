package tictactoe;

import java.io.IOException;
import static tictactoe.TictactoeConstants.*;
/**
 * Created by Taryn on 1/10/14.
 */
public class Game {
    private CLIBoard board;
    private Player playerOne;
    private Player playerTwo;
    private Player playerFirstMove;
    private UI ui;

    public Game(GameSettings params) {
        int boardSize = params.getBoardSize();
        this.playerOne = params.getPlayerOne();
        this.playerTwo = params.getPlayerTwo();
        this.playerFirstMove = params.getPlayerFirstMove();
        this.ui = params.getUI();
        this.board = new CLIBoard(boardSize);
        setPlayerOpponents();
    }

    public CLIBoard getBoard() {
        return this.board;
    }

    public void setBoard(CLIBoard board) {
        this.board = board;
    }

    public Player getPlayerOne() {
        return this.playerOne;
    }

    public Player getPlayerTwo() {
        return this.playerTwo;
    }

    public Player getPlayerFirstMove() {
        return this.playerFirstMove;
    }

    public void setPlayerFirstMove(Player player) {
        this.playerFirstMove = player;
    }

    public void setUI(UI ui) {
        this.ui = ui;
    }

    public void setPlayerOpponents() {
        getPlayerOne().setOpponent(getPlayerTwo());
        getPlayerTwo().setOpponent(getPlayerOne());
    }

    public static void main(String[] args) throws IOException {
        GameSettings settings = new GameSettings();
        settings.getAllSettings();
        Game newGame = new Game(settings);
        newGame.startGame();
        newGame.playGame();
    }

    public void startGame() {
        ui.firstMoveMessage(playerFirstMove.getMarker());
        playGame();
    }

    public void playGame() {
        advanceGame();
        if (gameOver()) {
            exitGame();
        } else {
            playGame();
        }
    }

    public void advanceGame() {
        Player player = currentPlayer();
        ui.nextMoveMessage(player.getMarker());
        board.printBoard();
        String move = player.makeMove(board);
        player.addMarker(board, move);
    }

    public void exitGame() {
        board.printBoard();
        displayGameOverMessage();
        ui.goodbyeMessage();
        System.exit(0);
    }

    public void displayGameOverMessage() {
        if (getBoard().winningGame(X_MARKER)) {
            ui.winningGameMessage(X_MARKER);
        } else if (getBoard().winningGame(O_MARKER)) {
            ui.winningGameMessage(O_MARKER);
        } else {
            ui.tieGameMessage();
        }
    }

    public Player currentPlayer() {
        int markerX = countMarker(X_MARKER);
        int markerO = countMarker(O_MARKER);
        if (markerX > markerO) {
            return playerTwo;
        } else if (markerO > markerX) {
            return playerOne;
        } else {
            return playerFirstMove;
        }
    }

    public boolean gameOver() {
        return ((board.winningGame(X_MARKER) || board.winningGame(O_MARKER)) || !board.hasAvailableCell());
    }

    private Integer countMarker(String marker) {
        int markerCount = 0;
        for (int i = 0; i < (board.getCells().length); i++) {
            if (cellValue(i).equals(marker)) {
                markerCount++;
            }
        }
        return markerCount;
    }

    private String cellValue(int cellIndex) {
        return getBoard().getCells()[cellIndex];
    }
}
