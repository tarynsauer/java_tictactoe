package tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Taryn on 1/15/14.
 */
public class PlayerFactoryTest {
    private PlayerFactory factory;

    @Before
    public void setUp() throws Exception {
        factory = new PlayerFactory();
    }

    @Test
    public void testGeneratePlayerReturnsAIPlayer() throws Exception {
        assertThat(factory.generatePlayer("hard", "X"), is((AIPlayer.class)));
    }

    @Test
    public void testGeneratePlayerReturnsComputerPlayer() throws Exception {
        assertThat(factory.generatePlayer("easy", "X"), is((ComputerPlayer.class)));
    }

    @Test
    public void testGeneratePlayerReturnsHumanPlayer() throws Exception {
        assertThat(factory.generatePlayer("human", "X"), is((HumanPlayer.class)));
    }
}
