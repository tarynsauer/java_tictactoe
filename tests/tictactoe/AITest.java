package tictactoe;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Taryn on 1/13/14.
 */
public class AITest {
    private AI ai;
    private Board board;

    @Before
    public void setUp() throws Exception {
        AIPlayer player = new AIPlayer("X");
        HumanPlayer playerO = new HumanPlayer("O");
        player.setOpponent(playerO);
        playerO.setOpponent(player);
        ai = new AI(player);
        board = new Board();
    }

    @Test
    public void testGetAIMoveReturnsCellIDForEmptyBoard() throws Exception {
      assertEquals(0, ai.getAIMove(board));
    }

    @Test
    public void testGetAIMoveReturnsCellIDForFullBoard() throws Exception {
        board.setCells(new String[]{"O", "X", "X",
                                    "X", "O", "O",
                                    "O", "8", "X"});
        assertEquals(7, ai.getAIMove(board));
    }

    @Test
    public void testGetBestMoveReturnsCorrectCellIndexForWinningHorizontalMove() throws Exception {
      board.setCells(new String[]{"1", "X", "X",
                                  "4", "O", "O",
                                  "7", "8", "9"});
      assertEquals(0, ai.getBestMove(board));
    }

    @Test
    public void testGetBestMoveReturnsCorrectCellIndexForWinningDiagonalMove() throws Exception {
        board.setCells(new String[]{"1", "O", "X",
                                    "4", "X", "O",
                                    "7", "8", "9"});
        assertEquals(6, ai.getBestMove(board));
    }

    @Test
    public void testGetBestMoveReturnsCorrectCellIndexForBlockingOpponentWin() throws Exception {
        board.setCells(new String[]{"1", "O", "O",
                                    "O", "X", "X",
                                    "X", "O", "9"});
        assertEquals(0, ai.getBestMove(board));
    }

    @Test
    public void testGetBestMoveReturnsCorrectCellIndexForChoosingWinOverBlock() throws Exception {
        board.setCells(new String[]{"1", "O", "O",
                                    "4", "X", "X",
                                    "X", "O", "O"});
        assertEquals(3, ai.getBestMove(board));
    }

    @Test
    public void testGetBestMoveReturnsCorrectCellIndexForChoosingWinOverBlockOrNonWin() throws Exception {
        board.setCells(new String[]{"1", "O", "O",
                                    "4", "X", "X",
                                    "X", "8", "O"});
        assertEquals(3, ai.getBestMove(board));
    }

    @Test
    public void testGetBestMoveReturnsCorrectCellIndexForChoosingBlockOverMultipleNonWins() throws Exception {
        board.setCells(new String[]{"1", "O", "O",
                                    "4", "5", "X",
                                    "X", "8", "9"});
        assertEquals(0, ai.getBestMove(board));
    }

    @Test
    public void testGetBestMoveReturnsCorrectCellIndexForChoosesLowerCornerMove() throws Exception {
        board.setCells(new String[]{"1", "2", "3",
                                    "4", "O", "6",
                                    "7", "8", "9"});
        assertEquals(0, ai.getBestMove(board));
    }

    @Test
    public void testGetBestMoveReturnsCorrectCellIndexForChoosesUpperCornerMove() throws Exception {
        board.setCells(new String[]{"1", "O", "3",
                                    "4", "5", "6",
                                    "7", "8", "9"});
        assertEquals(0, ai.getBestMove(board));
    }

    @Test
    public void testGetBestMoveReturnsCorrectCellIndexForBlockAndWin() throws Exception {
        board.setCells(new String[]{"1", "O", "O",
                                    "4", "X", "6",
                                    "7", "O", "X"});
        assertEquals(0, ai.getBestMove(board));
    }

    @Test
    public void testGetBestMoveReturnsCenterCellIndexForWin() throws Exception {
        board.setCells(new String[]{"X", "O", "O",
                                    "4", "5", "6",
                                    "7", "O", "X"});
        assertEquals(4, ai.getBestMove(board));
    }

    @Test
    public void testGetBestMoveChoosesABlockingMove() throws Exception {
        board.setCells(new String[]{"X", "2", "3",
                                    "4", "5", "6",
                                    "7", "8", "9"});
        assertEquals(2, ai.getBestMove(board));
    }

    @Test
    public void testGetBestMoveChoosesABlockingUpperCornerMove() throws Exception {
        board.setCells(new String[]{"X", "2", "3",
                                    "4", "5", "6",
                                    "7", "8", "9"});
        assertEquals(2, ai.getBestMove(board));
    }

    @Test
    public void testGetBestMoveChoosesABlockingLowerCornerMove() throws Exception {
        board.setCells(new String[]{"X", "2", "O",
                                    "O", "5", "6",
                                    "X", "8", "9"});
        assertEquals(8, ai.getBestMove(board));
    }

    @Test
    public void testGetBestMoveChoosesMiddleWinningMove() throws Exception {
        board.setCells(new String[]{"X", "2", "O",
                                    "O", "5", "6",
                                    "X", "O", "X"});
        assertEquals(4, ai.getBestMove(board));
    }

    @Test
    public void testGetBestMoveChoosesWinningMove() throws Exception {
        board.setCells(new String[]{"X", "2", "O",
                                    "O", "O", "6",
                                    "X", "8", "X"});
        assertEquals(7, ai.getBestMove(board));
    }
}

