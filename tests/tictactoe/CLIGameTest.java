package tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
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
        MockOutputStream outputStream = new MockOutputStream();
        printStream = new MockPrintStream(outputStream);
        printStream.setPrintCallHistory(new ArrayList<String>());
        UI ui = new UI();
        ui.setPrintStream(printStream);
        game = new CLIGame();
        game.setUI(ui);
    }

    @Test
    public void gameOutcomePrintsPlayerOWinsMessage() throws Exception {
        game.getBoard().setCells(new String[]{"X", "O", "X",
                                              "X", "O", "X",
                                              "O", "O", "9"});
        game.gameOutcome();
        assertThat(printStream.getPrintCallHistory(), containsString("Game over! Player 'O' wins!"));
    }

    @Test
    public void gameOutcomePrintsPlayerXWinsMessage() throws Exception {
        game.getBoard().setCells(new String[]{"1", "O", "O",
                                              "X", "X", "X",
                                              "O", "8", "9"});
        game.gameOutcome();
        assertThat(printStream.getPrintCallHistory(), containsString("Game over! Player 'X' wins!"));
    }

    @Test
    public void gameOutcomePrintsTieGameMessage() throws Exception {
        game.getBoard().setCells(new String[]{"X", "O", "O",
                                              "O", "X", "X",
                                              "O", "X", "O"});
        game.gameOutcome();
        assertThat(printStream.getPrintCallHistory(), containsString("Game over! It's a tie!"));
    }
}
