package tictactoe;

import java.io.*;

import static tictactoe.TictactoeConstants.X_MARKER;
import static tictactoe.TictactoeConstants.O_MARKER;

/**
 * Created by Taryn on 1/8/14.
 */
public class UI {
    private Board board;

  public UI() {
  }
    PrintStream stream = System.out;
    InputStream input = System.in;
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));

    public void setBoard(Board board) { this.board = board; }

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

    public void invalidBoardSizeMessage(String size) {
        stream.println("ERROR: '" + size + "' is not a valid board size.");
    }

    public void requestDifficultyLevel(String marker) {
        stream.println("For computer player '" + marker + "', enter EASY or HARD:");
    }

    public void goodbyeMessage() {
        stream.println("Thanks for playing. Goodbye!");
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
        return level.toLowerCase();
    }

    public String getNextMove() {
        String move = "0";
        while (!board.validMove(move)) {
            try {
                move = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } finally {
                if (!board.validMove(move)) {
                    badInputMessage(move);
                }
            }
        }
        return move;
    }

    public void printDivider() {
        String divider = "";
        for (int cols = 1; cols <= board.getRows(); cols++) {
            divider += "------";
        }
        stream.print(divider + "\n");
    }

    public void printBoardRow(int firstCellIndex) {
        String rowString = "";
        int lastCellIndex = firstCellIndex + board.getRows();
        for (int i = firstCellIndex; i < lastCellIndex; i++) {
            int numLength = Integer.toString(i + 1).length();
            if ((numLength == 1) || filledCell(i)) {
                rowString += "|  " + board.getCells()[i] + "  ";
            } else {
                rowString += "|  " + board.getCells()[i] + " ";
            }
        }
        stream.print(rowString + "|\n");
    }

    public void printBoard() {
        for (int i = 0; i < (board.getRows() * board.getRows()); i += board.getRows()) {
            printBoardRow(i);
            printDivider();
        }
    }

    private boolean filledCell(int cellIndex) {
        return (board.getCells()[cellIndex].equals(X_MARKER) || board.getCells()[cellIndex].equals(O_MARKER));
    }

}