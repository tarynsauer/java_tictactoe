package tictactoe;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

/**
 * Created by Taryn on 1/10/14.
 */
public class CLIGameTest {
    private CLIGame game;
    private MockPrintStream printStream;

    @Before
    public void setUp() throws Exception {
        game = new CLIGame();
        MockOutputStream outputStream = new MockOutputStream();
        printStream = new MockPrintStream(outputStream);
        game.board = new CLIBoard(printStream);
    }
//    @Test
//    public void testStartGame() throws Exception {
//        game.board.cells[0] = "X";
//        game.board.cells[1] = "X";
//        game.board.cells[2] = "X";
//        game.startGame();
//        assertThat(printStream.getPrintCallHistory(), containsString("goes first."));
//    }
}
