package tictactoe;

/**
 * Created by Taryn on 1/13/14.
 */
public class MaximizingScore extends AlphaBeta {

    public MaximizingScore(String playerMarker) {
        super(playerMarker);
    }

    public double getBeta(double beta, double score) {
        if (score < beta) {
            return score;
        } else {
            return beta;
        }
    }

    public double returnBestScore(double alpha, double beta) { return beta; }

}