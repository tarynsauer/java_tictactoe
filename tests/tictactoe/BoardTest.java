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
    private Board fourBoard;

    @Before
    public void setUp() {
      board = new Board(3);
      fourBoard = new Board(4);
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
        board.getCells()[0] = "X";
        String move = board.getRandomCell();
        assertThat(move, not("1"));
    }

    @Test
    public void testGetRandomCellReturnsTheOnlyOpenCell() {
        board.setCells(new String[]{"X", "O", "X",
                                    "X", "O", "X",
                                    "O", "X", "9"});
        String move = board.getRandomCell();
        assertEquals("9", move);
    }

    @Test
    public void testAvailableCellIndexes() {
        board.setCells(new String[]{"X", "O", "X",
                                    "X", "O", "X",
                                    "7", "8", "9"});
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
    public void testRemoveMarkerRemovesMarkerAndReplacesWithCellNumber() {
        board.getCells()[0] = "X";
        board.removeMarker(0);
        assertEquals("1", board.getCells()[0]);
    }

    @Test
    public void testWinningGameReturnsTrueForDiagonalWinningGame() {
        board.setCells(new String[]{"X", "2", "3",
                "4", "X", "6",
                "7", "8", "X"});
        assertTrue(board.winningGame("X"));
    }

    @Test
    public void testWinningGameReturnsFalseForNonWinningGame() {
        board.setCells(new String[]{"X", "O", "X",
                "4", "5", "6",
                "7", "8", "9"});
        assertFalse(board.winningGame("X"));
    }

    @Test
    public void testGameOverReturnsTrueForWinningGame() {
        board.setCells(new String[]{"X", "X", "X",
                "4", "5", "6",
                "7", "8", "9"});
        assertTrue(board.gameOver());
    }

    @Test
    public void testGameOverReturnsFalseForOngoingGame() {
        board.setCells(new String[]{"X", "O", "X",
                "4", "5", "6",
                "7", "8", "9"});
        assertFalse(board.gameOver());
    }

    @Test
    public void testGameOverReturnsTrueForTieGame() {
        board.setCells(new String[]{"X", "O", "X",
                "O", "X", "X",
                "O", "X", "O"});
        assertTrue(board.gameOver());
    }

    @Test
    public void testWinningGameReturnsTrueForWinningGame() {
        board.setCells(new String[]{"X", "X", "X",
                "4", "5", "6",
                "7", "8", "9"});
        assertTrue(board.winningGame("X"));
    }

    @Test
    public void testWinningLinesForFourByFourBoard() {
        String actualResult = Arrays.deepToString(fourBoard.getWinningLines());
        assertEquals("[[0, 1, 2, 3], [4, 5, 6, 7], [8, 9, 10, 11], [12, 13, 14, 15], [0, 4, 8, 12], [1, 5, 9, 13], [2, 6, 10, 14], [3, 7, 11, 15], [0, 5, 10, 15], [3, 6, 9, 12]]", actualResult);
    }

    @Test
    public void testWinningGameReturnsTrueForWinningGame4x4() {
        fourBoard.setCells(new String[]{"X", "X", "X", "X",
                                        "5", "6", "7", "8",
                                        "9", "10", "11", "12",
                                         "13", "14", "15", "16"});
        assertTrue(fourBoard.winningGame("X"));
    }

    @Test
    public void testWinningGameReturnsTrueForDiagonalWinningGame4x4() {
        fourBoard.setCells(new String[]{"X", "2", "3", "4",
                                        "5", "X", "7", "8",
                                        "9", "10", "X", "12",
                                        "13", "14", "15", "X"});
        assertTrue(fourBoard.winningGame("X"));
    }

    @Test
    public void testWinningGameReturnsFalseForNonWinningGame4x4() {
        fourBoard.setCells(new String[]{"X", "2", "3", "4",
                                        "5", "6", "7", "8",
                                        "9", "10", "O", "12",
                                        "13", "14", "15", "16"});
        assertFalse(fourBoard.winningGame("X"));
    }

    @Test
    public void testGameOverReturnsTrueForWinningGame4x4() {
        fourBoard.setCells(new String[]{"X", "X", "X", "X",
                "5", "6", "7", "8",
                "9", "10", "11", "12",
                "13", "14", "15", "16"});
        assertTrue(fourBoard.gameOver());
    }

    @Test
    public void testGameOverReturnsFalseForOngoingGame4x4() {
        fourBoard.setCells(new String[]{"X", "2", "3", "4",
                "5", "6", "7", "8",
                "9", "10", "O", "12",
                "13", "14", "15", "16"});
        assertFalse(fourBoard.gameOver());
    }

    @Test
    public void testGameOverReturnsTrueForTieGame4x4() {
        fourBoard.setCells(new String[]{"X", "X", "X", "O",
                                        "O", "X", "O", "O",
                                        "X", "O", "O", "X",
                                        "X", "O", "X", "O"});
        assertTrue(fourBoard.gameOver());
    }
}
