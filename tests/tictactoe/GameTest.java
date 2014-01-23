package tictactoe;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
* Created by Taryn on 1/10/14.
*/
public class GameTest {
    private Game game;

    @Before
    public void setUp() throws Exception {
        MockGameSettings settings = new MockGameSettings();
        settings.getAllSettings();
        game = new Game(settings);
        Board board = new Board(3);
        game.setBoard(board);
    }

    @Test
    public void testAddMarkerAddsMarkerToCorrectBoardCell() {
        game.addMarker("1");
        String[] expectedOutcome = new String[]{"X", "2", "3", "4", "5", "6", "7", "8", "9"};
        assertArrayEquals(expectedOutcome, game.getBoard().getCells());
    }

    @Test
    public void testMakeMoveCallsAddMarkerForTheCurrentPlayer() {
        game.getBoard().setCells(new String[]{"X", "O", "X",
                                              "O", "O", "X",
                                              "X", "X", "9"});
        String[] expectedOutcome = new String[]{"X", "O", "X", "O", "O", "X", "X", "X", "O"};
        game.makeMove();
        assertArrayEquals(expectedOutcome, game.getBoard().getCells());
    }

    @Test
    public void testGetMoveByTypeReturnsRandomCellForEasyComputerPlayerType() {
        game.getBoard().setCells(new String[]{"X", "O", "X",
                                              "O", "O", "X",
                                              "X", "X", "9"});
        String move = game.getMoveByType(TictactoeConstants.EASY_COMPUTER);
        assertEquals("9", move);
    }

    @Test
    public void testGetMoveByTypeReturnsRandomCellForHardAIPlayerType() {
        game.getBoard().setCells(new String[]{"X", "O", "X",
                                              "O", "O", "X",
                                              "X", "X", "9"});
        String move = game.getMoveByType(TictactoeConstants.HARD_COMPUTER);
        assertEquals("9", move);
    }

    @Test
    public void testCurrentPlayerWhenPlayerTwn() {
        game.getBoard().getCells()[0] = TictactoeConstants.X_MARKER;
        Assert.assertEquals(TictactoeConstants.O_MARKER, game.currentPlayer());
    }

    @Test
    public void testCurrentPlayerWhenPlayerOneTurn() {
        game.getBoard().getCells()[0] = TictactoeConstants.O_MARKER;
        Assert.assertEquals(TictactoeConstants.X_MARKER, game.currentPlayer());
    }

    @Test
    public void testCurrentPlayerWhenFirstPlayerTurn() {
        game.setPlayerFirstMove(game.getPlayerOne());
        game.getBoard().getCells()[1] = TictactoeConstants.X_MARKER;
        game.getBoard().getCells()[0] = TictactoeConstants.O_MARKER;
        Assert.assertEquals(game.getPlayerFirstMove(), game.currentPlayer());
    }

    @Test
    public void testCurrentPlayerWithThreeMarkersOnBoard() {
        game.setPlayerFirstMove(game.getPlayerOne());
        game.getBoard().getCells()[1] = TictactoeConstants.X_MARKER;
        game.getBoard().getCells()[0] = TictactoeConstants.O_MARKER;
        game.getBoard().getCells()[2] = TictactoeConstants.O_MARKER;
        Assert.assertEquals("X", game.currentPlayer());
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

}