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
    private MockBoard board;

    @Before
    public void setUp() throws Exception {
      player = new HumanPlayer("X");
      board = new MockBoard();
    }

    @Test
    public void testAddMarker() {
      player.addMarker(board, 1);
      String expectedResult = Arrays.deepToString(board.cells);
      assertEquals("[1, X, 3, 4, 5, 6, 7, 8, 9", expectedResult);
    }
}
