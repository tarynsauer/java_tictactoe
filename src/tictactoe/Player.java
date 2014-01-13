package tictactoe;

/**
 * Created by Taryn on 1/8/14.
 */
public interface Player {
    public String getMarker();
    public Player getOpponent();

    public void makeMove(Board board);
    void setOpponent(Player player);
    void addTestMarker(Board board, int cellID);
}
