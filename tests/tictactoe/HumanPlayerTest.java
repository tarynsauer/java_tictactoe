package tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by Taryn on 1/8/14.
 */
public class HumanPlayerTest {
    private HumanPlayer player;
    private Board board;

    @Before
    public void setUp() throws Exception {
      player = new HumanPlayer("X");
      board = new Board();
    }

    @Test
    public void testAddMarker() {
      player.addMarker(board, "1");
      String actualResult = Arrays.deepToString(board.getCells());
      assertEquals("[X, 2, 3, 4, 5, 6, 7, 8, 9]", actualResult);
    }

    @Test
    public void testSetOpponent() {
        HumanPlayer playerO = new HumanPlayer("O");
        player.setOpponent(playerO);
        assertEquals(playerO, player.getOpponent());
    }

}
