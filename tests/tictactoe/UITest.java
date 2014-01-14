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
        ui = new UI();
        ui.setPrintStream(printStream);
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
    public void testRequestPlayerType() {
        ui.requestPlayerType("X");
        assertEquals("Enter HUMAN or COMPUTER for player 'X' type:", printStream.lastPrintCall());
    }

    @Test
    public void testRequestBoardSize() {
        ui.requestBoardSize();
        assertEquals("Enter the number of board rows (3-6):", printStream.lastPrintCall());
    }

    @Test
    public void testBadInputMessage() {
        ui.badInputMessage("test");
        assertEquals("ERROR: 'test' is not a valid input value.", printStream.lastPrintCall());
    }

    @Test
    public void testInvalidBoardSizeMessage() {
        ui.invalidBoardSizeMessage(8);
        assertEquals("ERROR: '8' is not a valid board size.", printStream.lastPrintCall());
    }

    @Test
    public void testRequestDifficultyLevel() {
        ui.requestDifficultyLevel("X");
        assertEquals("For computer player 'X', enter EASY or HARD:", printStream.lastPrintCall());
    }

    @Test
    public void testReturnPlayerType() {
        MockBufferedReader bufferedReader = new MockBufferedReader(new InputStreamReader(ui.input));
        ui.setBufferedReader(bufferedReader);
        ArrayList<String> inputArray = new ArrayList<String>();
        inputArray.add("human");
        bufferedReader.setInputHistory(inputArray);
        assertEquals("human", ui.returnPlayerType());
    }

    @Test
    public void testReturnBoardSize() {
        MockBufferedReader bufferedReader = new MockBufferedReader(new InputStreamReader(ui.input));
        ui.setBufferedReader(bufferedReader);
        ArrayList<String> inputArray = new ArrayList<String>();
        inputArray.add("3");
        bufferedReader.setInputHistory(inputArray);
        assertEquals("3", ui.returnBoardSize());
    }

    @Test
    public void testReturnDifficultyLevel() {
        MockBufferedReader bufferedReader = new MockBufferedReader(new InputStreamReader(ui.input));
        ui.setBufferedReader(bufferedReader);
        ArrayList<String> inputArray = new ArrayList<String>();
        inputArray.add("hard");
        bufferedReader.setInputHistory(inputArray);
        assertEquals("hard", ui.returnDifficultyLevel());
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
