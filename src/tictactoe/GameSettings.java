package tictactoe;

import static tictactoe.TictactoeConstants.*;
/**
 * Created by Taryn on 1/14/14.
 */
public class GameSettings {

    private UI ui;
    private Board board;
    private int boardSize;
    private String playerOne;
    private String playerTwo;
    private String playerFirstMove;

    public GameSettings() {
    }

    public void getAllSettings() {
        this.ui = new UI();
        setUpPlayerOne(X_MARKER);
        setUpPlayerTwo(O_MARKER);
        randomizePlayerFirstMove();
        setUpBoardSize();
        Board gameBoard = new Board(this.boardSize);
        this.board = gameBoard;
        this.ui.setBoard(gameBoard);
    }

    public int getBoardSize() {
        return this.boardSize;
    }

    public void setBoardSize(Integer boardSize) {
        this.boardSize = boardSize;
    }

    public Board getBoard() {
        return this.board;
    }

    public String getPlayerOne() {
        return this.playerOne;
    }

    public String getPlayerTwo() {
        return this.playerTwo;
    }

    public void setPlayerOne(String playerType) {
        this.playerOne = playerType;
    }

    public void setPlayerTwo(String playerType) {
        this.playerTwo = playerType;
    }

    public String getPlayerFirstMove() {
        return this.playerFirstMove;
    }

    public UI getUI() {
        return this.ui;
    }

    public void setUI(UI ui) {
        this.ui = ui;
    }

    public void randomizePlayerFirstMove() {
        int rand = (Math.random() < 0.5) ? 0 : 1;
        if (rand == 0) {
            this.playerFirstMove = X_MARKER;
        } else {
            this.playerFirstMove = O_MARKER;
        }
    }

    public void setUpPlayerOne(String marker) {
        String type = getPlayerTypeFromUser(marker);
        if (type.equals(HUMAN_PLAYER))
            setPlayerOne(type);
        else if (type.equals(COMPUTER_PLAYER)) {
            String level = getComputerDifficulty(marker);
            setPlayerOne(level);
        } else {
            validatePlayerType(type, marker);
        }
    }

    public void setUpPlayerTwo(String marker) {
        String type = getPlayerTypeFromUser(marker);
        if (type.equals(HUMAN_PLAYER))
            setPlayerTwo(type);
        else if (type.equals(COMPUTER_PLAYER)) {
            String level = getComputerDifficulty(marker);
            setPlayerTwo(level);
        } else {
            validatePlayerType(type, marker);
        }
    }

    public String getComputerDifficulty(String marker) {
        String level = getDifficultyLevelFromUser(marker);
        while ((!level.equals(HARD_COMPUTER) && (!level.equals(EASY_COMPUTER)))) {
            ui.badInputMessage(level);
            level = getDifficultyLevelFromUser(marker);
        }
        return level;
    }

    public void setUpBoardSize() {
        String size = getBoardSizeFromUser();
        if (tryParse(size)) {
            validateBoardSize(size);
            setBoardSize(Integer.parseInt(size));
        } else {
            ui.invalidBoardSizeMessage(size);
            setUpBoardSize();
        }
    }

    private void validatePlayerType(String type, String marker) {
        ui.badInputMessage(type);
        if (marker.equals(X_MARKER)) {
            setUpPlayerOne(marker);
        } else {
            setUpPlayerTwo(marker);
        }
    }

    private String getPlayerTypeFromUser(String marker) {
        ui.requestPlayerType(marker);
        return ui.returnPlayerType();
    }

    private String getDifficultyLevelFromUser(String marker) {
        ui.requestDifficultyLevel(marker);
        return ui.returnDifficultyLevel();
    }

    private void validateBoardSize(String size) {
        if ((Integer.parseInt(size) < MIN_BOARD_SIZE) || (Integer.parseInt(size) > MAX_BOARD_SIZE)) {
            ui.invalidBoardSizeMessage(size);
            setUpBoardSize();
        }
    }

    private String getBoardSizeFromUser() {
        ui.requestBoardSize();
        return ui.returnBoardSize();
    }

    private static boolean tryParse(String size) {
        try {
            new Integer(size);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}