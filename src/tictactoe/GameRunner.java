package tictactoe;

import static tictactoe.TictactoeConstants.O_MARKER;
import static tictactoe.TictactoeConstants.X_MARKER;

/**
 * Created by Taryn on 1/18/14.
 */
public class GameRunner {

    private CLIGameSettings setup;
    private Game game;

    public GameRunner() {
        this.setup = new CLIGameSettings();
        setup.configureGame();
        this.game = new Game(setup);
        setup.getUI().firstMoveMessage(game.currentPlayer());
    }

    public void run() {
      startGamePlay();
      displayGameOutcomeMessage();
      exitGame();
    }

    public void startGamePlay() {
        while (!game.gameOver()) {
            String playerMarker = game.currentPlayer();
            setup.getUI().nextMoveMessage(playerMarker);
            setup.getUI().printBoard();
            game.makeMove();
        }
    }

    public void displayGameOutcomeMessage() {
        if (game.getBoard().winningGame(X_MARKER)) {
            setup.getUI().winningGameMessage(X_MARKER);
        } else if (game.getBoard().winningGame(O_MARKER)) {
            setup.getUI().winningGameMessage(O_MARKER);
        } else {
            setup.getUI().tieGameMessage();
        }
    }

    public void exitGame() {
        setup.getUI().printBoard();
        setup.getUI().goodbyeMessage();
        System.exit(0);
    }

}
