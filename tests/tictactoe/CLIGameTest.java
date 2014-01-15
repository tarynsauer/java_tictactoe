package tictactoe;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

/**
* Created by Taryn on 1/10/14.
*/
public class CLIGameTest {
    private CLIGame game;
    private UI ui;
    private MockPrintStream printStream;

    @Before
    public void setUp() throws Exception {
        MockOutputStream outputStream = new MockOutputStream();
        printStream = new MockPrintStream(outputStream);
        printStream.setPrintCallHistory(new ArrayList<String>());
        ui = new UI();
        ui.setPrintStream(printStream);

        MockGameSettings settings = new MockGameSettings();
        settings.getAllSettings();
        game = new CLIGame(settings);
        CLIBoard board = new CLIBoard(3);
        game.setBoard(board);
        game.setUI(ui);
    }

    @Test
    public void testCurrentPlayerWhenPlayerTwoTurn() {
        game.getBoard().getCells()[0] = "X";
        Assert.assertEquals("O", game.currentPlayer().getMarker());
    }

    @Test
    public void testCurrentPlayerWhenPlayerOneTurn() {
        game.getBoard().getCells()[0] = "O";
        Assert.assertEquals("X", game.currentPlayer().getMarker());
    }

    @Test
    public void testCurrentPlayerWhenFirstPlayerTurn() {
        game.setPlayerFirstMove(game.getPlayerOne());
        game.getBoard().getCells()[1] = "X";
        game.getBoard().getCells()[0] = "O";
        Assert.assertEquals(game.getPlayerFirstMove().getMarker(), game.currentPlayer().getMarker());
    }

    @Test
    public void testCurrentPlayerWithThreeMarkersOnBoard() {
        game.setPlayerFirstMove(game.getPlayerOne());
        game.getBoard().getCells()[1] = "X";
        game.getBoard().getCells()[0] = "O";
        game.getBoard().getCells()[2] = "O";
        Assert.assertEquals("X", game.currentPlayer().getMarker());
    }

    @Test
    public void testGameOverReturnsFalseForNonWinningNonTieGame() {
        game.getBoard().setCells(new String[]{"X", "O", "X",
                                              "4", "5", "6",
                                              "7", "8", "9"});
        assertFalse(game.gameOver());
    }

    @Test
    public void testGameOverReturnsTrueForWinningGame() {
        game.getBoard().setCells(new String[]{"X", "X", "X",
                                              "4", "5", "6",
                                              "7", "8", "9"});
        assertTrue(game.gameOver());
    }

    @Test
    public void testGameOverReturnsTrueForTieGame() {
        game.getBoard().setCells(new String[]{"X", "O", "X",
                                              "O", "O", "X",
                                              "O", "X", "O"});
        assertTrue(game.gameOver());
    }

    @Test
    public void gameOutcomePrintsPlayerOWinsMessage() throws Exception {
        game.getBoard().setCells(new String[]{"X", "O", "X",
                "X", "O", "X",
                "O", "O", "9"});
        game.displayGameOverMessage();
        assertThat(printStream.getPrintCallHistory(), containsString("Game over! Player 'O' wins!"));
    }

    @Test
    public void gameOutcomePrintsPlayerXWinsMessage() throws Exception {
        game.getBoard().setCells(new String[]{"1", "O", "O",
                                              "X", "X", "X",
                                              "O", "8", "9"});
        game.displayGameOverMessage();
        assertThat(printStream.getPrintCallHistory(), containsString("Game over! Player 'X' wins!"));
    }

    @Test
    public void gameOutcomePrintsTieGameMessage() throws Exception {
        game.getBoard().setCells(new String[]{"X", "O", "O",
                                              "O", "X", "X",
                                              "O", "X", "O"});
        game.displayGameOverMessage();
        assertThat(printStream.getPrintCallHistory(), containsString("Game over! It's a tie!"));
    }

    @Test
    public void gameSetPlayerOpponentsPlayerOne() throws Exception {
        assertEquals(game.getPlayerOne().getOpponent(), game.getPlayerTwo());
    }

    @Test
    public void gameSetPlayerOpponentsPlayerTwo() throws Exception {
        assertEquals(game.getPlayerTwo().getOpponent(), game.getPlayerOne());
    }
}
