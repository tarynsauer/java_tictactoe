package tictactoe;

/**
 * Created by Taryn on 1/8/14.
 */
public class ComputerPlayer extends AbstractPlayer {

    public ComputerPlayer(String marker) {
        super(marker);
    }

    @Override
    public String makeMove(Board board) {
      return board.getRandomCell();
    }

}