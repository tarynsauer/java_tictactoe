package tictactoe;

/**
 * Created by Taryn on 1/14/14.
 */
public class MockGameSettings extends GameSettings {

    private UI ui;
    private int boardSize;
    private Board board;
    private Player playerOne;
    private Player playerTwo;
    private Player playerFirstMove;

    public MockGameSettings() {
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

    public void setUI(UI ui) {
        this.ui = ui;
    }

    public Player randomizePlayerFirstMove() {
        return this.playerOne;
    }

    public Player returnPlayer(String marker) {
        return new HumanPlayer(marker);
    }

    @Override
    public void returnBoardSize() {
        this.boardSize = 3;
    }

}

