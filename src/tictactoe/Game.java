package tictactoe;

import static tictactoe.TictactoeConstants.*;

/**
 * Created by Taryn on 1/10/14.
 */
public class Game {
    private Board board;
    private String playerOne;
    private String playerTwo;
    private String playerFirstMove;
    private AbstractHumanMove humanMoveType;

    public Game(CLIGameSettings params) {
        this.playerOne = params.getPlayerOne();
        this.playerTwo = params.getPlayerTwo();
        this.playerFirstMove = params.getPlayerFirstMove();
        this.board = params.getBoard();
        this.humanMoveType = params.getHumanMoveType();
    }

    public Board getBoard() {
        return this.board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public AbstractHumanMove getAbstractHumanMove() {
        return this.humanMoveType;
    }

    public void setAbstractHumanMove(AbstractHumanMove humanMoveType) {
        this.humanMoveType = humanMoveType;
    }

    public String getPlayerOne() {
        return this.playerOne;
    }

    public String getPlayerTwo() {
        return this.playerTwo;
    }

    public String getPlayerFirstMove() {
        return this.playerFirstMove;
    }

    public void setPlayerFirstMove(String playerType) {
        this.playerFirstMove = playerType;
    }

    public void addMarker(String move) {
        int cellIndex = Integer.parseInt(move) - 1;
        board.getCells()[cellIndex] = currentPlayer();
    }

    public void makeMove() {
        if (currentPlayer().equals(X_MARKER)) {
            String move = getMoveByType(this.playerOne);
            addMarker(move);
        } else {
            String move = getMoveByType(this.playerTwo);
            addMarker(move);
        }
    }

    public String getMoveByType(String playerType) {
        if (playerType.equals(HUMAN_PLAYER)) {
            return humanMoveType.getNextMove();
        } else if (playerType.equals(EASY_COMPUTER)) {
            return board.getRandomCell();
        } else {
            AI ai = new AI(currentPlayer());
            int cellID = ai.getAIMove(board);
            return board.getCells()[cellID];
        }
    }

    public String currentPlayer() {
        int markerX = countMarker(X_MARKER);
        int markerO = countMarker(O_MARKER);
        if (markerX > markerO) {
            return O_MARKER;
        } else if (markerO > markerX) {
            return X_MARKER;
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