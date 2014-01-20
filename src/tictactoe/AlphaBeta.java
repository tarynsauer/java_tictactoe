package tictactoe;

import static tictactoe.TictactoeConstants.O_MARKER;
import static tictactoe.TictactoeConstants.X_MARKER;

public class AlphaBeta {
    private String playerMarker;
    private String opponentMarker;

    public AlphaBeta(String playerMarker) {
        this.playerMarker = playerMarker;
        this.opponentMarker = opponent(playerMarker);
    }

    public String getPlayerMarker() { return playerMarker; }

    public String getOpponentMarker() { return opponentMarker; }

    public double getAlpha(double alpha, double score) { return alpha; }

    public double getBeta(double beta, double score) { return beta; }

    public double returnBestScore(double alpha, double beta) { return alpha; }

    public void addOpponentMarker(Board board, int cellIndex) {
        board.getCells()[cellIndex] = opponent(getPlayerMarker());
    }

    private String opponent(String marker) {
        if (marker.equals(X_MARKER)) {
            return O_MARKER;
        } else {
            return X_MARKER;
        }
    }
}