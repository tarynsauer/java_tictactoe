package tictactoe;

import java.io.PrintStream;

/**
 * Created by Taryn on 1/7/14.
 */
public class CLIBoard extends Board {

    PrintStream stream = System.out;

    public CLIBoard(int size) {
        super(size);
    }

    public void setPrintStream(PrintStream stream) {
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
            int numLength = Integer.toString(i + 1).length();
            if ((numLength == 1) || filledCell(i)) {
                rowString += "|  " + getCells()[i] + "  ";
            } else {
                rowString += "|  " + getCells()[i] + " ";
            }
        }
        stream.print(rowString + "|\n");
    }

    public void printBoard() {
        for (int i = 0; i < (getRows() * getRows()); i += getRows()) {
            printBoardRow(i);
            printDivider();
        }
    }

    private boolean filledCell(int cellIndex) {
        return (getCells()[cellIndex].equals("X") || getCells()[cellIndex].equals("O"));
    }

}
