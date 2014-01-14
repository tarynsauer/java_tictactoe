package tictactoe;

import java.io.*;
/**
 * Created by Taryn on 1/8/14.
 */
public class UI {

  public UI() {
  }
    PrintStream stream = System.out;
    InputStream input = System.in;
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));

    public void setPrintStream(PrintStream stream) {
        this.stream = stream;
    }

    public void setBufferedReader(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public void nextMoveMessage(String playerMarker) {
        stream.println("Player '" + playerMarker + "': Make your move.");
    }

    public void firstMoveMessage(String playerMarker) {
        stream.println("Player '" + playerMarker + "' goes first!");
    }

    public void tieGameMessage() {
        stream.println("Game over! It's a tie!");
    }

    public void winningGameMessage(String playerMarker) {
        stream.println("Game over! Player '" + playerMarker +"' wins!");
    }

    public String getNextMove() {
        String move = "";
        try {
            move = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return move;
    }
}