package tictactoe;

/**
 * Created by Taryn on 1/23/14.
 */
public class MockCLIHumanMove extends AbstractHumanMove {
    private Board board;
    private UI ui;

    public MockCLIHumanMove(Board board) {
        this.board = board;
    }

    public void setUI(UI ui) {
        this.ui = ui;
    }

    @Override
    public String getNextMove() {
        return "9";
    }
}
