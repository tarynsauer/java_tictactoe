package tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.InputStreamReader;
import java.util.ArrayList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by Taryn on 1/14/14.
 */
public class GameSettingsTest {
    private GameSettings gameSettings;
    private ArrayList<String> inputArray;
    private MockBufferedReader bufferedReader;
    private UI ui;
    private MockPrintStream printStream;

    @Before
    public void setUp() throws Exception {
        MockOutputStream outputStream = new MockOutputStream();
        printStream = new MockPrintStream(outputStream);
        printStream.setPrintCallHistory(new ArrayList<String>());
        ui = new UI();
        ui.setPrintStream(printStream);

        bufferedReader = new MockBufferedReader(new InputStreamReader(ui.input));
        ui.setBufferedReader(bufferedReader);

        inputArray = new ArrayList<String>();
        gameSettings = new GameSettings();
        gameSettings.setUI(ui);
    }

    @Test
    public void testRandomizePlayerFirstMoveReturnsAPlayerObject() {
        HumanPlayer playerX = new HumanPlayer("X");
        HumanPlayer playerO = new HumanPlayer("O");
        gameSettings.setPlayerOne(playerX);
        gameSettings.setPlayerTwo(playerO);
        assertThat(gameSettings.randomizePlayerFirstMove(), is((HumanPlayer.class)));
    }

    @Test
    public void testReturnPlayerReturnsHumanPlayerObject() throws Exception {
        inputArray.add("human");
        bufferedReader.setInputHistory(inputArray);
        assertThat(gameSettings.returnPlayer("X"), is((HumanPlayer.class)));
    }

    @Test
    public void testGetComputerDifficultyReturnsValidDifficultyValue() throws Exception {
        inputArray.add("easy");
        bufferedReader.setInputHistory(inputArray);
        assertEquals(gameSettings.getComputerDifficulty("X"), "easy");
    }

    @Test
    public void testReturnBoardSizeReturnsValidBoardSize() throws Exception {
        inputArray.add("3");
        bufferedReader.setInputHistory(inputArray);
        gameSettings.returnBoardSize();
        assertEquals(gameSettings.getBoardSize(), 3);
    }

}
