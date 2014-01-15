package tictactoe;

import java.io.IOException;

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
        board.printBoard();
        playGame();
    }

    public void playGame() {
        Player player = currentPlayer();
        ui.nextMoveMessage(player.getMarker());
        String move = player.makeMove(board);
        player.addMarker(board, move);
        board.printBoard();
        if (gameOver()) {
            exitGame();
        } else {
            playGame();
        }
    }

    public void exitGame() {
        displayGameOverMessage();
        ui.goodbyeMessage();
        System.exit(0);
    }

    public void displayGameOverMessage() {
        if (getBoard().winningGame("X")) {
            ui.winningGameMessage("X");
        } else if (getBoard().winningGame("O")) {
            ui.winningGameMessage("O");
        } else {
            ui.tieGameMessage();
        }
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

    public boolean gameOver() {
        if (board.winningGame("X") || board.winningGame("O")) {
            return true;
        } else if (!board.hasAvailableCell()) {
            return true;
        } else {
            return false;
        }
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
