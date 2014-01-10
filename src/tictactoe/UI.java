package tictactoe;

import java.io.*;
/**
 * Created by Taryn on 1/8/14.
 */
public class UI {
  private PrintStream stream;

  public UI(PrintStream stream) {
    this.stream = stream;
  }
    InputStream input = System.in;
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));

    public void setBufferedReader(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public void nextMoveMessage(String playerMarker) {
        stream.print("Player '" + playerMarker + "': Make your move.");
    }

    public void firstMoveMessage(String playerMarker) {
        stream.print("Player '" + playerMarker + "' goes first!");
    }

    public void tieGameMessage() {
        stream.print("Game over! It's a tie!");
    }

    public void winningGameMessage(String playerMarker) {
        stream.print("Game over! Player '" + playerMarker +"' wins!");
    }

    public int getNextMove() {
        String move = "";
        try {
            move = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int index = Integer.parseInt(move);
        return index;
    }
}