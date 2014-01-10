package tictactoe;

/**
 * Created by Taryn on 1/8/14.
 */
public class HumanPlayer extends Player {

    public HumanPlayer(String marker) {
        super(marker);
    }

    public void addMarker(Board board, int move) {
      super.addMarker(board, move);
      int cellIndex = move + 1;
      board.cells[cellIndex] = this.marker;
    }
}
