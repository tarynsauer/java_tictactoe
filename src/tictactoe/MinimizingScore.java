package tictactoe;

/**
 * Created by Taryn on 1/13/14.
 */
class MinimizingScore extends AlphaBeta {

    public MinimizingScore(String playerMarker) {
        super(playerMarker);
    }

    public double getAlpha(double alpha, double score) {
        if (score > alpha) {
            return score;
        } else {
            return alpha;
        }
    }
}