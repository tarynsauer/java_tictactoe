package tictactoe;
/**
 * Created by Taryn on 1/14/14.
 */
public class MockGameSettings extends CLIGameSettings {

    private UI ui;
    private Board board;
    private int boardSize;
    private String playerOne;
    private String playerTwo;
    private String playerFirstMove;
    private AbstractHumanMove humanMoveType;

    public MockGameSettings() {
    }

    public void getAllSettings() {
        this.ui = new MockUI();
        setUpPlayerOne(TictactoeConstants.X_MARKER);
        setUpPlayerTwo(TictactoeConstants.O_MARKER);
        randomizePlayerFirstMove();
        returnBoardSize();
        Board gameBoard = new Board(this.boardSize);
        this.board = gameBoard;
        this.ui.setBoard(gameBoard);
        this.humanMoveType = new CLIHumanMove(this.board);
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
        this.playerTwo = "easy";
    }

    public void returnBoardSize() {
        this.boardSize = 3;
    }

}

