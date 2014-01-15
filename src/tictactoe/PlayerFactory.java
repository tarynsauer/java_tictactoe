package tictactoe;

/**
 * Created by Taryn on 1/14/14.
 */
public class PlayerFactory {
    static final String HARD_COMPUTER = "hard";
    static final String EASY_COMPUTER = "easy";

    public static Player generatePlayer(String type, String marker) {
        if (type.equals(HARD_COMPUTER)) {
            return new AIPlayer(marker);
        } else if (type.equals(EASY_COMPUTER)) {
            return new ComputerPlayer(marker);
        } else {
            return new HumanPlayer(marker);
        }
    }
}
