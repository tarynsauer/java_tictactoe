package tictactoe;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertEquals;

/**
* Created by Taryn on 1/6/14.
*/

public class GameTest {
    private Game game;

    @Before
    public void setUp() throws Exception {
      game = new Game();
      game.board = new Board();
    }

    @Test
    public void testCurrentPlayerWhenPlayerTwoTurn() {
      game.board.cells[0] = "X";
      Assert.assertEquals(game.playerTwo.getMarker(), game.currentPlayer().getMarker());
    }

    @Test
    public void testCurrentPlayerWhenPlayerOneTurn() {
      game.board.cells[0] = "O";
      Assert.assertEquals(game.playerOne.getMarker(), game.currentPlayer().getMarker());
    }

    @Test
    public void testCurrentPlayerWhenFirstPlayerTurn() {
      game.playerFirstMove = game.playerOne;
      game.board.cells[1] = "X";
      game.board.cells[0] = "O";
      Assert.assertEquals(game.playerOne.getMarker(), game.currentPlayer().getMarker());
    }

    @Test
    public void testPlayerFirstMove() {
        Player player = game.getPlayerFirstMove();
        assertThat(player, instanceOf(Player.class));
    }

    @Test
    public void testGameOverReturnsFalseForNonWinningNonTieGame() {
        game.board.cells[0] = "X";
        game.board.cells[1] = "O";
        game.board.cells[2] = "X";
        assertFalse(game.gameOver());
    }

    @Test
    public void testGameOverReturnsTrueForWinningGame() {
        game.board.cells[0] = "X";
        game.board.cells[1] = "X";
        game.board.cells[2] = "X";
        assertTrue(game.gameOver());
    }

    @Test
    public void testGameOverReturnsTrueForTieGame() {
        game.board.cells[0] = "X";
        game.board.cells[1] = "O";
        game.board.cells[2] = "X";
        game.board.cells[3] = "O";
        game.board.cells[4] = "O";
        game.board.cells[5] = "X";
        game.board.cells[6] = "O";
        game.board.cells[7] = "X";
        game.board.cells[8] = "O";
        assertTrue(game.gameOver());
    }
}
