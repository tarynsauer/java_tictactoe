package tictactoe;

/**
 * Created by Taryn on 1/8/14.
 */
public class HumanPlayer extends AbstractPlayer {

    public HumanPlayer(String marker) {
        super(marker);
    }

    public String makeMove(Board board) {
        UI ui = new UI();
        return ui.getNextMove();
    }

}
