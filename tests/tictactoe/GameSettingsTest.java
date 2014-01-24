package tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by Taryn on 1/14/14.
 */
public class GameSettingsTest {
    private GameSettings gameSettings;
    private MockUI ui;
    private MockPrintStream printStream;

    @Before
    public void setUp() throws Exception {
        MockOutputStream outputStream = new MockOutputStream();
        printStream = new MockPrintStream(outputStream);
        printStream.setPrintCallHistory(new ArrayList<String>());
        ui = new MockUI();
        ui.setPrintStream(printStream);
        gameSettings = new GameSettings();
        gameSettings.setUI(ui);
    }

    @Test
    public void testGetAllSettingsSetsPlayerOne() {
        gameSettings.getAllSettings();
        assertEquals(gameSettings.getPlayerOne(), TictactoeConstants.EASY_COMPUTER);
    }

    @Test
    public void testGetAllSettingsSetsPlayerTwo() {
        gameSettings.getAllSettings();
        assertEquals(gameSettings.getPlayerTwo(), TictactoeConstants.EASY_COMPUTER);
    }

    @Test
    public void testGetAllSettingsSetsBoard() {
        gameSettings.getAllSettings();
        assertThat(gameSettings.getBoard(), is((Board.class)));
    }

    @Test
    public void testRandomizePlayerFirstMoveReturnsAPlayerTypeString() {
        gameSettings.randomizePlayerFirstMove();
        assertThat(gameSettings.getPlayerFirstMove(), is((String.class)));
    }

    @Test
    public void testSetUpPlayerOneReturnsEasyComputerPlayerTypeString() throws Exception {
        gameSettings.setUpPlayerOne(TictactoeConstants.X_MARKER);
        assertEquals(gameSettings.getPlayerOne(), TictactoeConstants.EASY_COMPUTER);
    }

    @Test
    public void testSetUpPlayerTwoReturnsEasyComputerPlayerTypeString() throws Exception {
        gameSettings.setUpPlayerTwo(TictactoeConstants.O_MARKER);
        assertEquals(gameSettings.getPlayerTwo(), TictactoeConstants.EASY_COMPUTER);
    }

    @Test
    public void testGetComputerDifficultyReturnsValidDifficultyValue() throws Exception {
        assertEquals(gameSettings.getComputerDifficulty(TictactoeConstants.X_MARKER), "easy");
    }

    @Test
    public void testSetUpBoardSizeReturnsValidBoardSize() throws Exception {
        gameSettings.setUpBoardSize();
        assertEquals(gameSettings.getBoardSize(), 3);
    }

}
