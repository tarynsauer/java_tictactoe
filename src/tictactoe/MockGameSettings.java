package tictactoe;
/**
 * Created by Taryn on 1/14/14.
 */
public class MockGameSettings extends GameSettings {

    private UI ui;
    private int boardSize;
    private String playerOne;
    private String playerTwo;
    private String playerFirstMove;

    public MockGameSettings() {
    }

    public void getAllSettings() {
        this.ui = new UI();
        setUpPlayerOne(TictactoeConstants.X_MARKER);
        setUpPlayerTwo(TictactoeConstants.O_MARKER);
        randomizePlayerFirstMove();
        returnBoardSize();
    }

    public int getBoardSize() {
        return this.boardSize;
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

    public void setUI(UI ui) {
        this.ui = ui;
    }

    public void randomizePlayerFirstMove() {
        this.playerFirstMove = "X";
    }

    public void setUpPlayerOne(String marker) {
        this.playerOne = "human";
    }

    public void setUpPlayerTwo(String marker) {
        this.playerTwo = "human";
    }

    public void returnBoardSize() {
        this.boardSize = 3;
    }

}

