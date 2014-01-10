package tictactoe;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Taryn on 1/7/14.
 */
public class CLIBoardTest {
    private CLIBoard cliBoard;
    private MockPrintStream printStream;

    @Before
    public void setUp() throws Exception {
        MockOutputStream outputStream = new MockOutputStream();
        printStream = new MockPrintStream(outputStream);
        printStream.setPrintCallHistory(new ArrayList<String>());
        cliBoard = new CLIBoard(printStream);
    }

    @Test
    public void testPrintDivider() {
        String expectedOutput = "------------------\n";
        cliBoard.printDivider();
        assertEquals(expectedOutput, printStream.lastPrintCall());
    }

    @Test
    public void testPrintBoardRow() {
        String expectedOutput = "|  1  |  2  |  3  |\n";
        cliBoard.printBoardRow(0);
        assertEquals(expectedOutput, printStream.lastPrintCall());
    }

    @Test
    public void testPrintBoard() {
        String expectedOutput = "|  1  |  2  |  3  |\n------------------\n|  4  |  5  |  6  |\n------------------\n|  7  |  8  |  9  |\n------------------\n";
        cliBoard.printBoard();
        String actualOutput = printStream.getPrintCallHistory();
        assertEquals(expectedOutput, actualOutput);
    }
}