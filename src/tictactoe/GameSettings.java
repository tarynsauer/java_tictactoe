package tictactoe;
/**
 * Created by Taryn on 1/14/14.
 */
public class GameSettings {

    private UI ui;
    private int boardSize;
    private Player playerOne;
    private Player playerTwo;
    private Player playerFirstMove;

    static final String HUMAN_PLAYER = "human";
    static final String COMPUTER_PLAYER = "computer";
    static final String HARD_COMPUTER = "hard";
    static final String EASY_COMPUTER = "easy";

    public GameSettings() {
    }

    public void getAllSettings() {
        this.ui = new UI();
        this.playerOne = returnPlayer("X");
        this.playerTwo = returnPlayer("O");
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

    public static Player generatePlayer(String type, String marker) {
        if (type.equals(HARD_COMPUTER)) {
            return new AIPlayer(marker);
        } else if (type.equals(EASY_COMPUTER)) {
            return new ComputerPlayer(marker);
        } else {
            return new HumanPlayer(marker);
        }
    }

    public Player returnPlayer(String marker) {
        ui.requestPlayerType(marker);
        String type = ui.returnPlayerType();
        validatePlayerType(type, marker);
        if (type.equals(HUMAN_PLAYER))
            return generatePlayer(type, marker);
        else {
            String level = getComputerDifficulty(marker);
            return generatePlayer(level, marker);
        }
    }

    public void validatePlayerType(String type, String marker) {
        if ((!type.equals(HUMAN_PLAYER) && (!type.equals(COMPUTER_PLAYER)))) {
            ui.badInputMessage(type);
            returnPlayer(marker);
        }
    }

    public void validateDifficultyLevel(String level, String marker) {
        if ((!level.equals(HARD_COMPUTER) && (!level.equals(EASY_COMPUTER)))) {
            ui.badInputMessage(level);
            returnPlayer(marker);
        }
    }

    public String getComputerDifficulty(String marker) {
        ui.requestDifficultyLevel(marker);
        String level = ui.returnDifficultyLevel();
        validateDifficultyLevel(level, marker);
        return level;
    }

    public void validateBoardSize(String size) {
        if ((Integer.parseInt(size) < 3) || (Integer.parseInt(size) > 6)) {
            ui.invalidBoardSizeMessage(size);
            returnBoardSize();
        }
    }

    public void returnBoardSize() {
        ui.requestBoardSize();
        String size = ui.returnBoardSize();
        if (tryParse(size)) {
            validateBoardSize(size);
            Integer intSize = Integer.parseInt(size);
            setBoardSize(intSize);
        } else {
            ui.invalidBoardSizeMessage(size);
            returnBoardSize();
        }
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

