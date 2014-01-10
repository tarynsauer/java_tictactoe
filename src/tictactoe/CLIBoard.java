package tictactoe;

import java.io.PrintStream;

/**
 * Created by Taryn on 1/7/14.
 */
public class CLIBoard extends Board {

    private PrintStream stream;

    public CLIBoard(PrintStream stream) {
        this.stream = stream;
    }

    public void printDivider() {
        String divider = "";
        for (int cols = 1; cols <= rows; cols++) {
            divider += "------";
        }
        stream.print(divider + "\n");
    }

    public void printBoardRow(int firstCellIndex) {
        String rowString = "";
        int lastCellIndex = firstCellIndex + rows;
        for (int i = firstCellIndex; i < lastCellIndex; i++) {
            rowString += "|  " + cells[i] + "  ";
        }
        stream.print(rowString + "|\n");
    }

    public void printBoard() {
        for (int i = 0; i < (rows * rows); i += rows) {
            printBoardRow(i);
            printDivider();
        }
    }

}
