package tictactoe;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
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
      game.board = new MockBoard();
    }

    @Test
    public void testCurrentPlayerWhenPlayerTwoTurn() {
      game.board.cells[0] = "X";
      Assert.assertEquals(game.playerTwo, game.currentPlayer());
    }

    @Test
    public void testCurrentPlayerWhenPlayerOneTurn() {
      game.board.cells[0] = "O";
      Assert.assertEquals(game.playerOne, game.currentPlayer());
    }

    @Test
    public void testCurrentPlayerWhenFirstPlayerTurn() {
      game.playerFirstMove = game.playerOne;
      game.board.cells[1] = "X";
      game.board.cells[0] = "O";
      Assert.assertEquals(game.playerOne, game.currentPlayer());
    }

    @Test
    public void testPlayerFirstMove() {
        Player player = game.getPlayerFirstMove();
        assertThat(player, instanceOf(Player.class));
    }
}
