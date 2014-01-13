package tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.ArrayList;

import static junit.framework.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

/**
 * Created by Taryn on 1/7/14.
 */
public class BoardTest {
    private Board board;

    @Before
    public void setUp() {
      board = new Board();
    }

    @Test
    public void testInitializesCells() {
      assertEquals("2", board.getCells()[1]);
    }

    @Test
    public void testIsAvailableReturnsTrueWhenAvailable() {
        for(int i = 0; i <= 7; i++) {
            board.getCells()[i] = "X";
        }
        assertTrue(board.hasAvailableCell());
    }

    @Test
    public void testGetRandomCellDoesNotReturnUnavailableCell() {
        String cellID = board.getRandomCell();
        board.getCells()[0] = "X";
        assertThat(cellID, not("1"));
    }

    @Test
    public void testGetRandomCellReturnsTheOnlyOpenCell() {
        board.getCells()[0] = "X";
        board.getCells()[1] = "O";
        board.getCells()[2] = "X";
        board.getCells()[3] = "X";
        board.getCells()[4] = "O";
        board.getCells()[5] = "X";
        board.getCells()[6] = "O";
        board.getCells()[7] = "O";
        String cellID = board.getRandomCell();
        assertEquals("9", cellID);
    }
    @Test
    public void testAvailableCellIndexes() {
        board.getCells()[0] = "X";
        board.getCells()[1] = "O";
        board.getCells()[2] = "X";
        board.getCells()[3] = "X";
        board.getCells()[4] = "O";
        board.getCells()[5] = "X";
        ArrayList<Integer> expectedOutput = new ArrayList<Integer>();
        expectedOutput.add(6);
        expectedOutput.add(7);
        expectedOutput.add(8);
        assertEquals(expectedOutput, board.availableCellIndexes());
    }

    @Test
    public void testIsAvailableReturnsFalseWhenBoardFull() {
        for(int i = 0; i <= 8; i++) {
            board.getCells()[i] = "X";
        }
        assertFalse(board.hasAvailableCell());
    }

    @Test
    public void testIsAvailableReturnsFalseWhenBoardFull2() {
        board.getCells()[0] = "X";
        assertTrue(board.hasAvailableCell());
    }

    @Test
    public void testIsValidCellReturnsTrueWhenCellValueIsNull() {
        assertTrue(board.isValidCell(1));
    }

    @Test
    public void testIsValidCellReturnsFalseWhenCellValueIsNotNull() {
        board.getCells()[1] = "X";
        assertFalse(board.isValidCell(1));
    }

    @Test
    public void testIsValidCellReturnsFalseWhenInvalidCellIndex() {
        assertFalse(board.isValidCell(9));
    }

    @Test
    public void testWinningLinesReturnsAllWinningLines() {
        String actualResult = Arrays.deepToString(board.getWinningLines());
        assertEquals("[[0, 1, 2], [3, 4, 5], [6, 7, 8], [0, 3, 6], [1, 4, 7], [2, 5, 8], [0, 4, 8], [2, 4, 6]]", actualResult);
    }

    @Test
    public void testWinningGameReturnsTrueForWinningGame() {
        board.getCells()[0] = "X";
        board.getCells()[1] = "X";
        board.getCells()[2] = "X";
        assertTrue(board.winningGame("X"));
    }

    @Test
    public void testWinningGameReturnsTrueForDiagonalWinningGame() {
        board.getCells()[0] = "X";
        board.getCells()[4] = "X";
        board.getCells()[8] = "X";
        assertTrue(board.winningGame("X"));
    }

    @Test
    public void testWinningGameReturnsFalseForNonWinningGame() {
        board.getCells()[0] = "X";
        board.getCells()[1] = "O";
        board.getCells()[2] = "X";
        assertFalse(board.winningGame("X"));
    }

    @Test
    public void testGameOverReturnsTrueForWinningGame() {
        board.getCells()[0] = "X";
        board.getCells()[1] = "X";
        board.getCells()[2] = "X";
        assertTrue(board.gameOver());
    }

    @Test
    public void testGameOverReturnsFalseForOngoingGame() {
        board.getCells()[0] = "X";
        board.getCells()[1] = "O";
        board.getCells()[2] = "X";
        assertFalse(board.gameOver());
    }

    @Test
    public void testGameOverReturnsTrueForTieGame() {
        board.getCells()[0] = "X";
        board.getCells()[1] = "O";
        board.getCells()[2] = "O";
        board.getCells()[3] = "O";
        board.getCells()[4] = "X";
        board.getCells()[5] = "X";
        board.getCells()[6] = "O";
        board.getCells()[7] = "X";
        board.getCells()[8] = "O";
        assertTrue(board.gameOver());
    }

    @Test
    public void testRemoveMarkerRemovesMarkerAndReplacesWithCellNumber() {
        board.getCells()[0] = "X";
        board.removeMarker(0);
        assertEquals("1", board.getCells()[0]);
    }
}
