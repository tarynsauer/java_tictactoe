package tictactoe;

/**
 * Created by Taryn on 1/8/14.
 */
public class HumanPlayer implements Player {
    public String marker;

    public HumanPlayer(String marker) {
        this.marker = marker;
    }

    @Override
    public String getMarker() {
        return marker;
    }

    @Override
    public void addMarker(Board board, int move) {
      int cellIndex = move - 1;
      board.cells[cellIndex] = this.marker;
    }
}
