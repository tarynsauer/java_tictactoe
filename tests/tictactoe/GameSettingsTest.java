package tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.InputStreamReader;
import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by Taryn on 1/14/14.
 */
public class GameSettingsTest {
    private GameSettings gameSettings;
    private ArrayList<String> inputArray;
    private MockBufferedReader bufferedReader;
    private MockUI ui;
    private MockPrintStream printStream;

    @Before
    public void setUp() throws Exception {
        MockOutputStream outputStream = new MockOutputStream();
        printStream = new MockPrintStream(outputStream);
        printStream.setPrintCallHistory(new ArrayList<String>());
        ui = new MockUI();
        ui.setPrintStream(printStream);

        bufferedReader = new MockBufferedReader(new InputStreamReader(ui.input));
        ui.setBufferedReader(bufferedReader);

        inputArray = new ArrayList<String>();
        gameSettings = new GameSettings();
        gameSettings.setUI(ui);
    }

    @Test
    public void testGetAllSettings() {
        MockUI mockUI = new MockUI();
        gameSettings.setUI(mockUI);
        gameSettings.getAllSettings();
        assertEquals(gameSettings.getPlayerOne(), TictactoeConstants.EASY_COMPUTER);
    }

    @Test
    public void testRandomizePlayerFirstMoveReturnsAPlayerObject() {
        gameSettings.setPlayerOne("human");
        gameSettings.setPlayerTwo("human");
        gameSettings.randomizePlayerFirstMove();
        assertThat(gameSettings.getPlayerFirstMove(), is((String.class)));
    }

    @Test
    public void testSetUpPlayerOneReturnsHumanPlayerObject() throws Exception {
        inputArray.add("human");
        bufferedReader.setInputHistory(inputArray);
        gameSettings.setUpPlayerOne(TictactoeConstants.X_MARKER);
        assertEquals(gameSettings.getPlayerOne(), TictactoeConstants.EASY_COMPUTER);
    }

    @Test
    public void testSetUpPlayerTwoReturnsHumanPlayerObject() throws Exception {
        inputArray.add("human");
        bufferedReader.setInputHistory(inputArray);
        gameSettings.setUpPlayerTwo(TictactoeConstants.O_MARKER);
        assertEquals(gameSettings.getPlayerTwo(), TictactoeConstants.EASY_COMPUTER);
    }

    @Test
    public void testGetComputerDifficultyReturnsValidDifficultyValue() throws Exception {
        inputArray.add("easy");
        bufferedReader.setInputHistory(inputArray);
        assertEquals(gameSettings.getComputerDifficulty(TictactoeConstants.X_MARKER), "easy");
    }

    @Test
    public void testSetUpBoardSizeReturnsValidBoardSize() throws Exception {
        inputArray.add("3");
        bufferedReader.setInputHistory(inputArray);
        gameSettings.setUpBoardSize();
        assertEquals(gameSettings.getBoardSize(), 3);
    }

}
