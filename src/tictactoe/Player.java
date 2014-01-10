package tictactoe;

/**
 * Created by Taryn on 1/8/14.
 */
public interface Player {
    public String getMarker();
    void addMarker(Board board, int move);
}
