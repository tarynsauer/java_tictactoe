package tictactoe;

/**
 * Created by Taryn on 1/8/14.
 */
public class ComputerPlayer extends AbstractPlayer {

    public ComputerPlayer(String marker) {
        super(marker);
    }

    public void makeMove(Board board) {
      String move = board.getRandomCell();
      int moveIndex = Integer.parseInt(move);
      addMarker(board, moveIndex);
    }

}