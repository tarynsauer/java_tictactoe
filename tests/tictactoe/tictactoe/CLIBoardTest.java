package tictactoe.tictactoe;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import tictactoe.Board;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Taryn on 1/7/14.
 */
public class CLIBoardTest {
    private CLIBoard cliBoard;

    @Before
    public void setUp() throws Exception {
        cliBoard = new CLIBoard();
    }

    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Test
    public void testPrintRowNumbers() throws Exception {
      cliBoard.printRowNumbers();
      assertEquals("|  1  |  2  |  3  |", log.getLog());
    }
}
