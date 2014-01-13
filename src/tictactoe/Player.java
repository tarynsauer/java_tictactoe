package tictactoe;

/**
 * Created by Taryn on 1/8/14.
 */
public interface Player {
    public String getMarker();
    public Player getOpponent();

    void setOpponent(Player player);
    void addMarker(Board board, int move);
    void makeMove(Board board);
}
