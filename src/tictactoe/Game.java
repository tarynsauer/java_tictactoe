package tictactoe;

/**
 * Created by Taryn on 1/10/14.
 */
public class Game {
    private Board board;
    private Player playerOne;
    private int boardSize;
    private Player playerTwo;
    private Player playerFirstMove;
    private UI ui;

    public Game(GameSettings params) {
        this.boardSize = params.getBoardSize();
        this.playerOne = params.getPlayerOne();
        this.playerTwo = params.getPlayerTwo();
        this.playerFirstMove = params.getPlayerFirstMove();
        this.ui = params.getUI();
    }

    public Board getBoard() {
        return this.board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Player getPlayerOne() {
        return this.playerOne;
    }

    public int getBoardSize() {
        return this.boardSize;
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
            if (getBoard().getCells()[i].equals(marker)) {
                markerCount++;
            }
        }
        return markerCount;
    }
}
