package tictactoe;

/**
 * Created by Taryn on 1/13/14.
 */
public class MinimizingPlayer extends AbstractAlphaBeta {

    public MinimizingPlayer(Player player) {
        super(player);
    }

    public double getAlpha(double alpha, double score) {
        if (score > alpha) {
            return score;
        } else {
            return alpha;
        }
    }

    @Override
    public void setUI(UI ui) {

    }
}
