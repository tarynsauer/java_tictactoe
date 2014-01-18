package tictactoe;

/**
 * Created by Taryn on 1/13/14.
 */
public class MaximizingPlayer extends AbstractAlphaBeta {

    public MaximizingPlayer(Player player) {
        super(player);
    }

    public double getBeta(double beta, double score) {
        if (score < beta) {
            return score;
        } else {
            return beta;
        }
    }

    public double returnBestScore(double alpha, double beta) {
        return beta;
    }

    @Override
    public void setUI(UI ui) {

    }
}