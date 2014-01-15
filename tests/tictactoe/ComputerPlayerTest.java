package tictactoe;

import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;

/**
 * Created by Taryn on 1/11/14.
 */
public class ComputerPlayerTest {
    private ComputerPlayer player;
    private Board board;

    @Before
    public void setUp() throws Exception {
        player = new ComputerPlayer("X");
        board = new Board(3);
    }

    @Test
    public void testGetMarkerReturnsCorrectMarker() {
        String marker = player.getMarker();
        assertEquals("X", marker);
    }

    @Test
    public void testAddMarkerPlacesPlayerMarkerOnBoard() {
        player.addMarker(board, "2");
        String actualResult = Arrays.deepToString(board.getCells());
        assertEquals("[1, X, 3, 4, 5, 6, 7, 8, 9]", actualResult);
    }

    @Test
    public void testMakeMoveAddsAPlayerMarkerToBoard() {
        board.setCells(new String[]{"X", "O", "X",
                                    "X", "O", "O",
                                    "O", "8", "X"});
        assertEquals("8", player.makeMove(board));
    }

}
