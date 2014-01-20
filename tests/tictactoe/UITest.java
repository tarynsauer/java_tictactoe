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
        Board board = new Board(3);
        ui = new UI();
        ui.setBoard(board);
        ui.setPrintStream(printStream);
    }

    @Test
    public void testNextMoveMessage() {
      ui.nextMoveMessage(TictactoeConstants.X_MARKER);
      assertEquals("Player 'X': Make your move.", printStream.lastPrintCall());
    }

    @Test
    public void testFirstMoveMessage() {
      ui.firstMoveMessage(TictactoeConstants.X_MARKER);
      assertEquals("Player 'X' goes first!", printStream.lastPrintCall());
    }

    @Test
    public void testTieGameMessage() {
        ui.tieGameMessage();
        assertEquals("Game over! It's a tie!", printStream.lastPrintCall());
    }

    @Test
    public void testGoodbyeMessage() {
        ui.goodbyeMessage();
        assertEquals("Thanks for playing. Goodbye!", printStream.lastPrintCall());
    }

    @Test
    public void testWinningGameMessage() {
        ui.winningGameMessage(TictactoeConstants.X_MARKER);
        assertEquals("Game over! Player 'X' wins!", printStream.lastPrintCall());
    }

    @Test
    public void testRequestPlayerType() {
        ui.requestPlayerType(TictactoeConstants.X_MARKER);
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
        ui.invalidBoardSizeMessage("8");
        assertEquals("ERROR: '8' is not a valid board size.", printStream.lastPrintCall());
    }

    @Test
    public void testRequestDifficultyLevel() {
        ui.requestDifficultyLevel(TictactoeConstants.X_MARKER);
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

    @Test
    public void testPrintDivider() {
        String expectedOutput = "------------------\n";
        ui.printDivider();
        assertEquals(expectedOutput, printStream.lastPrintCall());
    }

    @Test
    public void testPrintBoardRow() {
        String expectedOutput = "|  1  |  2  |  3  |\n";
        ui.printBoardRow(0);
        assertEquals(expectedOutput, printStream.lastPrintCall());
    }

    @Test
    public void testPrintBoard() {
        String expectedOutput = "|  1  |  2  |  3  |\n------------------\n|  4  |  5  |  6  |\n------------------\n|  7  |  8  |  9  |\n------------------\n";
        ui.printBoard();
        String actualOutput = printStream.getPrintCallHistory();
        assertEquals(expectedOutput, actualOutput);
    }
}
