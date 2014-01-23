package tictactoe;

/**
 * Created by Taryn on 1/21/14.
 */
public class MockUI extends UI {

    @Override
    public String returnPlayerType() {
        return "computer";
    }

    @Override
    public String returnDifficultyLevel() {
        return "easy";
    }

    @Override
    public String returnBoardSize() {
        return "3";
    }
}
