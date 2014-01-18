package tictactoe;

/**
 * Created by Taryn on 1/10/14.
 */
public class AIPlayer extends AbstractPlayer {

    public AIPlayer(String marker) {
        super(marker);
    }

    public String makeMove(Board board) {
        AI ai = new AI(this);
        int cellID = ai.getAIMove(board);
        return board.getCells()[cellID];
    }

    @Override
    public void setUI(UI ui) {

    }

}