package tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.io.InputStreamReader;
import static junit.framework.Assert.assertEquals;

/**
 * Created by Taryn on 1/9/14.
 */
public class UITest {
    private UI ui;
    private MockPrintStream printStream;

    @Before
    public void setUp() {
        MockOutputStream outputStream = new MockOutputStream();
        printStream = new MockPrintStream(outputStream);
        printStream.setPrintCallHistory(new ArrayList<String>());
        ui = new UI(printStream);
    }

    @Test
    public void testNextMoveMessage() {
      ui.nextMoveMessage("X");
      assertEquals("Player 'X': Make your move.", printStream.lastPrintCall());
    }

    @Test
    public void testFirstMoveMessage() {
      ui.firstMoveMessage("X");
      assertEquals("Player 'X' goes first!", printStream.lastPrintCall());
    }

    @Test
    public void testTieGameMessage() {
        ui.tieGameMessage();
        assertEquals("Game over! It's a tie!", printStream.lastPrintCall());
    }

    @Test
    public void testWinningGameMessage() {
        ui.winningGameMessage("X");
        assertEquals("Game over! Player 'X' wins!", printStream.lastPrintCall());
    }

    @Test
    public void testGetNextMove() {
      MockBufferedReader bufferedReader = new MockBufferedReader(new InputStreamReader(ui.input));
      ui.setBufferedReader(bufferedReader);
      ArrayList<String> inputArray = new ArrayList<String>();
      inputArray.add("1");
      bufferedReader.setInputHistory(inputArray);
      assertEquals("1", ui.getNextMove());
    }
}
