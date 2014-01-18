package tictactoe;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStreamReader;
import java.util.ArrayList;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

/**
* Created by Taryn on 1/10/14.
*/
public class GameTest {
    private Game game;
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
        game = new Game(settings);
        CLIBoard board = new CLIBoard(3);
        game.setBoard(board);
        game.setUI(ui);
    }

    @Test
    public void testCurrentPlayerWhenPlayerTwoTurn() {
        game.getBoard().getCells()[0] = TictactoeConstants.X_MARKER;
        Assert.assertEquals(TictactoeConstants.O_MARKER, game.currentPlayer().getMarker());
    }

    @Test
    public void testCurrentPlayerWhenPlayerOneTurn() {
        game.getBoard().getCells()[0] = TictactoeConstants.O_MARKER;
        Assert.assertEquals(TictactoeConstants.X_MARKER, game.currentPlayer().getMarker());
    }

    @Test
    public void testCurrentPlayerWhenFirstPlayerTurn() {
        game.setPlayerFirstMove(game.getPlayerOne());
        game.getBoard().getCells()[1] = TictactoeConstants.X_MARKER;
        game.getBoard().getCells()[0] = TictactoeConstants.O_MARKER;
        Assert.assertEquals(game.getPlayerFirstMove().getMarker(), game.currentPlayer().getMarker());
    }

    @Test
    public void testCurrentPlayerWithThreeMarkersOnBoard() {
        game.setPlayerFirstMove(game.getPlayerOne());
        game.getBoard().getCells()[1] = TictactoeConstants.X_MARKER;
        game.getBoard().getCells()[0] = TictactoeConstants.O_MARKER;
        game.getBoard().getCells()[2] = TictactoeConstants.O_MARKER;
        Assert.assertEquals("X", game.currentPlayer().getMarker());
    }

    @Test
    public void testAdvanceGamePlacesCurrentPlayerMarkerOnBoard() {
        game.getBoard().getCells()[0] = TictactoeConstants.O_MARKER;
        MockBufferedReader bufferedReader = new MockBufferedReader(new InputStreamReader(ui.input));
        ui.setBufferedReader(bufferedReader);
        ArrayList<String> inputArray = new ArrayList<String>();
        inputArray.add("2");
        bufferedReader.setInputHistory(inputArray);
        game.getPlayerOne().setUI(ui);
        game.advanceGame();
        assertArrayEquals(new String[]{"O", "X", "3",
                "4", "5", "6",
                "7", "8", "9"}, game.getBoard().getCells());
    }
//
//    @Test
//    public void testExitGameCallGameOverMessage() {
//        game.getBoard().setCells(new String[]{"X", "O", "X",
//                                              "X", "O", "O",
//                                              "X", "8", "9"});
//        game.exitGame();
//        assertThat(printStream.getPrintCallHistory(), containsString("Game over! Player 'X' wins!"));
//    }

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