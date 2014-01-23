package tictactoe;

/**
 * Created by Taryn on 1/20/14.
 */
public class CLIHumanMove extends AbstractHumanMove {
    private Board board;
    private UI ui;

    public CLIHumanMove(Board board) {
        this.board = board;
    }

    public void setUI(UI ui) {
        this.ui = ui;
    }

    @Override
    public String getNextMove() {
        ui = new UI();
        ui.setBoard(board);
        return ui.getNextMove();
    }
}