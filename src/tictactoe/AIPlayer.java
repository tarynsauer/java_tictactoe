package tictactoe;

/**
 * Created by Taryn on 1/10/14.
 */
public class AIPlayer extends AbstractPlayer {

    public AIPlayer(String marker) {
        super(marker);
    }

    @Override
    public void makeMove(Board board) {
        AI ai = new AI(this);
        int move = ai.getAIMove(board);
        addMarker(board, move);
    }

}