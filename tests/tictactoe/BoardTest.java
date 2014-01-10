package tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.Assert.assertTrue;
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
      assertEquals("2", board.cells[1]);
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
        String actualResult = Arrays.deepToString(board.getWinningLines());
        assertEquals("[[0, 1, 2], [3, 4, 5], [6, 7, 8], [0, 3, 6], [1, 4, 7], [2, 5, 8], [0, 4, 8], [2, 4, 6]]", actualResult);
    }

    @Test
    public void testWinningGameReturnsTrueForWinningGame() {
        board.cells[0] = "X";
        board.cells[1] = "X";
        board.cells[2] = "X";
        assertTrue(board.winningGame("X"));
    }

    @Test
    public void testWinningGameReturnsTrueForDiagonalWinningGame() {
        board.cells[0] = "X";
        board.cells[4] = "X";
        board.cells[8] = "X";
        assertTrue(board.winningGame("X"));
    }

    @Test
    public void testWinningGameReturnsFalseForNonWinningGame() {
        board.cells[0] = "X";
        board.cells[1] = "O";
        board.cells[2] = "X";
        assertFalse(board.winningGame("X"));
    }
}
