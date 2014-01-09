package tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

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
      String[] expectedResult = new String[9];
      expectedResult[1] = null;
      assertArrayEquals(expectedResult, board.cells);
    }

    @Test
    public void testIsAvailableReturnsTrueWhenAvailable() {
        for(int i = 0; i <= 7; i++) {
            board.cells[i] = "X";
        }
        assertTrue(board.hasAvailableCell());
    }

    @Test
    public void testIsAvailableReturnsFalseWhenBoardFull() {
        for(int i = 0; i <= 8; i++) {
            board.cells[i] = "X";
        }
        assertFalse(board.hasAvailableCell());
    }

    @Test
    public void testIsAvailableReturnsFalseWhenBoardFull2() {
        board.cells[0] = "X";
        assertTrue(board.hasAvailableCell());
    }

    @Test
    public void testIsValidCellReturnsTrueWhenCellValueIsNull() {
        assertTrue(board.isValidCell(1));
    }

    @Test
    public void testIsValidCellReturnsFalseWhenCellValueIsNotNull() {
        board.cells[1] = "X";
        assertFalse(board.isValidCell(1));
    }

    @Test
    public void testIsValidCellReturnsFalseWhenInvalidCellIndex() {
        assertFalse(board.isValidCell(9));
    }

    @Test
    public void testWinningLinesReturnsAllWinningLines() {
        String expectedResult = Arrays.deepToString(board.getWinningLines());
        assertEquals("[[0, 1, 2], [3, 4, 5], [6, 7, 8], [0, 3, 6], [1, 4, 7], [2, 5, 8], [0, 4, 8], [2, 4, 6]]", expectedResult);
    }
}
