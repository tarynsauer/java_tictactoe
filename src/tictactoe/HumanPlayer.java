package tictactoe;

/**
 * Created by Taryn on 1/8/14.
 */
public class HumanPlayer extends AbstractPlayer {
    private UI ui;
    public HumanPlayer(String marker) {
        super(marker);
        this.ui = new UI();
    }

    public void setUI(UI ui) {
        this.ui = ui;
    }

    public String makeMove(Board board) {
        return ui.getNextMove();
    }

}
