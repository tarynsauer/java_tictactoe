package tictactoe;

import static tictactoe.TictactoeConstants.*;
/**
 * Created by Taryn on 1/14/14.
 */
public class GameSettings {

    private UI ui;
    private int boardSize;
    private Player playerOne;
    private Player playerTwo;
    private Player playerFirstMove;

    public GameSettings() {
    }

    public void getAllSettings() {
        this.ui = new UI();
        this.playerOne = returnPlayer(X_MARKER);
        this.playerTwo = returnPlayer(O_MARKER);
        this.playerFirstMove = randomizePlayerFirstMove();
        returnBoardSize();
    }

    public int getBoardSize() {
        return this.boardSize;
    }

    public void setBoardSize(Integer boardSize) {
        this.boardSize = boardSize;
    }

    public Player getPlayerOne() {
        return this.playerOne;
    }

    public Player getPlayerTwo() {
        return this.playerTwo;
    }

    public void setPlayerOne(Player player) {
        this.playerOne = player;
    }

    public void setPlayerTwo(Player player) {
        this.playerTwo = player;
    }

    public Player getPlayerFirstMove() {
        return this.playerFirstMove;
    }

    public UI getUI() {
        return this.ui;
    }

    public void setUI(UI ui) {
        this.ui = ui;
    }

    public Player randomizePlayerFirstMove() {
        int rand = (Math.random() < 0.5) ? 0 : 1;
        if (rand == 0) {
            return this.playerOne;
        } else {
            return this.playerTwo;
        }
    }

    public Player generatePlayer(String type, String marker) {
        if (type.equals(HARD_COMPUTER)) {
            return new AIPlayer(marker);
        } else if (type.equals(EASY_COMPUTER)) {
            return new ComputerPlayer(marker);
        } else {
            return new HumanPlayer(marker);
        }
    }

    public Player returnPlayer(String marker) {
        String type = getPlayerTypeFromUser(marker);
        validatePlayerType(type, marker);
        if (type.equals(HUMAN_PLAYER))
            return generatePlayer(type, marker);
        else {
            String level = getComputerDifficulty(marker);
            return generatePlayer(level, marker);
        }
    }

    public String getComputerDifficulty(String marker) {
        String level = getDifficultyLevelFromUser(marker);
        validateDifficultyLevel(level, marker);
        return level;
    }

    public void returnBoardSize() {
        String size = getBoardSizeFromUser();
        if (tryParse(size)) {
            validateBoardSize(size);
            setBoardSize(Integer.parseInt(size));
        } else {
            ui.invalidBoardSizeMessage(size);
            returnBoardSize();
        }
    }

    private void validatePlayerType(String type, String marker) {
        if ((!type.equals(HUMAN_PLAYER) && (!type.equals(COMPUTER_PLAYER)))) {
            ui.badInputMessage(type);
            returnPlayer(marker);
        }
    }

    private void validateDifficultyLevel(String level, String marker) {
        if ((!level.equals(HARD_COMPUTER) && (!level.equals(EASY_COMPUTER)))) {
            ui.badInputMessage(level);
            returnPlayer(marker);
        }
    }

    private void validateBoardSize(String size) {
        if ((Integer.parseInt(size) < MIN_BOARD_SIZE) || (Integer.parseInt(size) > MAX_BOARD_SIZE)) {
            ui.invalidBoardSizeMessage(size);
            returnBoardSize();
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

