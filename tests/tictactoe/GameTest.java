package tictactoe;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

/**
* Created by Taryn on 1/6/14.
*/

public class GameTest {
    private Game game;

    @Before
    public void setUp() throws Exception {
      game = new Game();
      game.setBoard(new Board());
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
    public void testRandomizePlayerFirstMove() {
        Player player = game.randomizePlayerFirstMove();
        assertThat(player, instanceOf(Player.class));
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
