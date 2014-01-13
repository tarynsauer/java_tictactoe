package tictactoe;

abstract class AbstractPlayer implements Player {
    private String marker;
    private Player opponent;

    public String getMarker() {
        return marker;
    }

    public Player getOpponent() {
        return opponent;
    }

    public void setOpponent(Player player) {
        this.opponent = player;
    }

    public AbstractPlayer(String marker) {
        this.marker = marker;
    }

    public void addMarker(Board board, int move) {
        int cellIndex = move - 1;
        board.getCells()[cellIndex] = this.marker;
    }

    public void addTestMarker(Board board, int cellIndex) {
        board.getCells()[cellIndex] = this.marker;
    }
}
