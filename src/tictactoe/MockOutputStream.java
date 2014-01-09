package tictactoe;

import java.io.IOException;
import java.io.OutputStream;

import java.util.ArrayList;
/**
 * Created by Taryn on 1/8/14.
 */
public class MockOutputStream extends OutputStream {
    ArrayList<String> printCallHistory = new ArrayList<String>();

    @Override
    public void write(int i) throws IOException {
    }
}
