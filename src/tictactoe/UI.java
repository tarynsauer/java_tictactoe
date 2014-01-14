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

    public void requestPlayerType(String marker) {
        stream.println("Enter HUMAN or COMPUTER for player '" + marker +"' type:");
    }

    public void requestBoardSize() {
        stream.println("Enter the number of board rows (3-6):");
    }

    public void badInputMessage(String input) {
        stream.println("ERROR: '" + input + "' is not a valid input value.");
    }

    public void invalidBoardSizeMessage(int sizeNum) {
        stream.println("ERROR: '" + Integer.toString(sizeNum) + "' is not a valid board size.");
    }

    public void requestDifficultyLevel(String marker) {
        stream.println("For computer player '" + marker + "', enter EASY or HARD:");
    }

    public String returnPlayerType() {
        String type = "";
        try {
            type = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return type.toLowerCase();
    }

    public String returnBoardSize() {
        String size = "";
        try {
            size = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return size;
    }

    public String returnDifficultyLevel() {
        String level = "";
        try {
            level = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return level;
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