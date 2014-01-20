package tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Taryn on 1/20/14.
 */
public class AlphaBetaTest {
    private MaximizingScore scoreX;

    @Before
    public void setUp() throws Exception {
        scoreX = new MaximizingScore(TictactoeConstants.X_MARKER);
    }

    @Test
    public void testGetOpponentMarker() throws Exception {
        assertEquals(TictactoeConstants.O_MARKER, scoreX.getOpponentMarker());
    }

    @Test
    public void testAddOpponentMarker() throws Exception {
        Board board = new Board(3);
        scoreX.addOpponentMarker(board, 0);
        assertArrayEquals(new String[]{"O", "2", "3",
                                       "4", "5", "6",
                                       "7", "8", "9"}, board.getCells());
    }
}
