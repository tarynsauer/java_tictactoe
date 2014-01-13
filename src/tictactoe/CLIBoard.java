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
        for (int cols = 1; cols <= getRows(); cols++) {
            divider += "------";
        }
        stream.print(divider + "\n");
    }

    public void printBoardRow(int firstCellIndex) {
        String rowString = "";
        int lastCellIndex = firstCellIndex + getRows();
        for (int i = firstCellIndex; i < lastCellIndex; i++) {
            rowString += "|  " + getCells()[i] + "  ";
        }
        stream.print(rowString + "|\n");
    }

    public void printBoard() {
        for (int i = 0; i < (getRows() * getRows()); i += getRows()) {
            printBoardRow(i);
            printDivider();
        }
    }

}
