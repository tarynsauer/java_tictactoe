package tictactoe;

import com.sun.tools.doclets.internal.toolkit.util.SourceToHTMLConverter;

import java.util.HashMap;

/**
 * Created by Taryn on 1/7/14.
 */
public class Board {

    public int rows = 3;
    public String[] cells;
    public int[][] winningLines = new int[8][3];

    public Board() {
      cells = new String[9];
      for (int num = 1; num <= (cells.length); num++) {
        int i = num - 1;
        cells[i] = Integer.toString(num);
      }
    }

    public boolean hasAvailableCell() {
      for (int i = 0; i < cells.length; i++) {
        if (cells[i] == null)
           return true;
        }
      return false;
    }

    public boolean isValidCell(int cellIndex) {
      int totalCellsCount = rows * rows;
      if ((cellIndex > 0) && (cellIndex < totalCellsCount) && isOpen(cellIndex)) {
        return true;
      } else {
        return false;
      }
    }

    public int[][] getWinningLines() {
      getRows();
      getColumns();
      getDiagonal(0, 6, 4);
      getDiagonal(2, 7, 2);
      return winningLines;
    }

    private void getDiagonal(int cellIndex, int rowIndex, int incrementByNumber) {
        for (int colIndex = 0; colIndex < rows; colIndex++) {
          winningLines[rowIndex][colIndex] = cellIndex;
          cellIndex = cellIndex + incrementByNumber;
        }
    }

    private void getColumns() {
      int cellIndex = 0;
      for (int colIndex = 0; colIndex < rows; colIndex++) {
        incrementColumnIndex(cellIndex, colIndex);
        cellIndex += rows;
      }
    }

    private void incrementColumnIndex(int cellIndex, int colIndex) {
        for (int rowIndex = rows; rowIndex < (rows * 2); rowIndex++) {
            winningLines[rowIndex][colIndex] = cellIndex;
            cellIndex++;
        }
    }

    private void getRows() {
      int cellIndex = 0;
      for (int rowIndex = 0; rowIndex < rows; rowIndex++)
        for (int colIndex = 0; colIndex < rows; colIndex++) {
          winningLines[rowIndex][colIndex] = cellIndex;
            cellIndex++;
        }
    }

    private boolean isOpen(int cellIndex) {
       if (cells[cellIndex] == null) {
            return true;
        } else {
            return false;
        }
    }
}
