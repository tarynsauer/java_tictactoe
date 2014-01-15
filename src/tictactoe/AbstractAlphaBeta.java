package tictactoe;

abstract class AbstractAlphaBeta implements Player {
    private String marker;
    private Player opponent;

    public AbstractAlphaBeta(Player player) {
        this.marker = player.getMarker();
        this.opponent = player.getOpponent();
    }

    public String getMarker() {
        return marker;
    }

    public Player getOpponent() { return opponent; }

    public void setOpponent(Player player) {
        this.opponent = player;
    }

    public void addMarker(Board board, String move) {
        int cellIndex = Integer.parseInt(move) - 1;
        board.getCells()[cellIndex] = this.marker;
    }

    public void addTestMarker(Board board, int cellIndex) {
        board.getCells()[cellIndex] = this.marker;
    }

    public double getAlpha(double alpha, double score) {
        return alpha;
    }

    public double getBeta(double beta, double score) {
        return beta;
    }

    public double returnBestScore(double alpha, double beta) {
        return alpha;
    }

    public String makeMove(Board board) {
        return null;
    }

}