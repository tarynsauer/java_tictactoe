package tictactoe;

/**
 * Created by Taryn on 1/8/14.
 */
public interface Player {
    public String getMarker();
    public Player getOpponent();

    void setOpponent(Player player);
    void addTestMarker(Board board, int cellID);
    void addMarker(Board board, String move);
    String makeMove(Board board);

    void setUI(UI ui);
}
