package tictactoe;

import java.io.IOException;

import static tictactoe.TictactoeConstants.O_MARKER;
import static tictactoe.TictactoeConstants.X_MARKER;

/**
 * Created by Taryn on 1/18/14.
 */
public class GameRunner {

    public static void main(String[] args) throws IOException {
        CLIGameSettings setup = new CLIGameSettings();
        setup.configureGame();
        Game game = new Game(setup);

        setup.getUI().firstMoveMessage(game.currentPlayer());
        
        while (!game.gameOver()) {
            String playerMarker = game.currentPlayer();
            setup.getUI().nextMoveMessage(playerMarker);
            setup.getUI().printBoard();
            game.makeMove();
        }
        
        if (game.getBoard().winningGame(X_MARKER)) {
            setup.getUI().winningGameMessage(X_MARKER);
        } else if (game.getBoard().winningGame(O_MARKER)) {
            setup.getUI().winningGameMessage(O_MARKER);
        } else {
            setup.getUI().tieGameMessage();
        }

        setup.getUI().printBoard();
        setup.getUI().goodbyeMessage();
        System.exit(0);
    }

}
