package tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Taryn on 1/6/14.
 */
public class GameTest {
    private Game game;

    @Before
    public void setUp() throws Exception {
      game = new Game();
    }

    @Test
    public void testSayHello() throws Exception {
      assertEquals("Hello", game.sayHello());
    }
}
