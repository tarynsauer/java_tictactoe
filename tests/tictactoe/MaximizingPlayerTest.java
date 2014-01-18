package tictactoe;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Taryn on 1/14/14.
 */
public class MaximizingPlayerTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testGetOpponentMaximizingReturnsPlayerO() throws Exception {
        AIPlayer player = new AIPlayer(TictactoeConstants.X_MARKER);
        HumanPlayer playerO = new HumanPlayer(TictactoeConstants.O_MARKER);
        player.setOpponent(playerO);
        playerO.setOpponent(player);
        MaximizingPlayer maxPlayer = new MaximizingPlayer(player);

        assertEquals(playerO, maxPlayer.getOpponent());
    }

    public void testGetOpponentMinimizingReturnsPlayerO() throws Exception {
        AIPlayer player = new AIPlayer(TictactoeConstants.X_MARKER);
        HumanPlayer playerO = new HumanPlayer(TictactoeConstants.O_MARKER);
        player.setOpponent(playerO);
        playerO.setOpponent(player);
        MinimizingPlayer minPlayer = new MinimizingPlayer(player);

        assertEquals(playerO, minPlayer.getOpponent());
    }

}
