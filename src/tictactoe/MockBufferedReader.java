package tictactoe;

import java.io.BufferedReader;
import java.io.Reader;
import java.util.ArrayList;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * Created by Taryn on 1/9/14.
 */
public class MockBufferedReader extends BufferedReader {
    public ArrayList<String> inputHistory;

    public void setInputHistory(ArrayList<String> inputHistory) {
        this.inputHistory = inputHistory;
    }

    public MockBufferedReader(Reader reader) {
        super(reader);
    }

    public MockBufferedReader(InputStreamReader inputStreamReader) {
        super(inputStreamReader);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public String readLine() throws IOException {
        return inputHistory.get(inputHistory.size()-1);
    }
}
