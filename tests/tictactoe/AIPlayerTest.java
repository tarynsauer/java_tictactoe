package tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Taryn on 1/13/14.
 */
public class AIPlayerTest {
    private AIPlayer player;
    private Board board;

    @Before
    public void setUp() throws Exception {
        player = new AIPlayer("X");
        HumanPlayer playerO = new HumanPlayer("O");
        player.setOpponent(playerO);
        playerO.setOpponent(player);
        board = new Board(3);
    }

    @Test
    public void testMakeMovePlacesMarkerOnBoard() throws Exception {
        board.setCells(new String[]{"1", "2", "3",
                                    "X", "O", "O",
                                    "O", "8", "X"});
        assertEquals("3", player.makeMove(board));
    }
}
