package tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
/**
 * Created by Taryn on 1/7/14.
 */
public class Board {

    private int rows = 3;
    private String[] cells;
    private int[][] winningLines = new int[8][3];

    public Board() {
      cells = new String[9];
      for (int num = 1; num <= (cells.length); num++) {
        int i = num - 1;
        cells[i] = Integer.toString(num);
      }
      getWinningLines();
    }

    public int getRows() {
        return rows;
    }

    public String[] getCells() {
        return cells;
    }

    public void setCells(String[] cells) {
        this.cells = cells;
    }

    public boolean hasAvailableCell() {
      for (int i = 0; i < cells.length; i++) {
        if ((!(cells[i] == "X") && !(cells[i] == "O")))
           return true;
        }
      return false;
    }

    public ArrayList<Integer> availableCellIndexes() {
        ArrayList<Integer> openCellIndexes = new ArrayList<Integer>();
        for (int i = 0; i < cells.length; i++) {
            if ((!(cells[i] == "X") && !(cells[i] == "O")))
                openCellIndexes.add(i);
        }
        return openCellIndexes;
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
      getAllRows();
      getColumns();
      getDiagonal(0, 6, 4);
      getDiagonal(2, 7, 2);
      return winningLines;
    }

    public String getRandomCell() {
        Random randomGenerator = new Random();
        ArrayList<Integer> openCells = availableCellIndexes();
        int index = randomGenerator.nextInt(openCells.size());
        int randomCellIndex = openCells.get(index);
        return cells[randomCellIndex];
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

    private void getAllRows() {
      int cellIndex = 0;
      for (int rowIndex = 0; rowIndex < rows; rowIndex++)
        for (int colIndex = 0; colIndex < rows; colIndex++) {
          winningLines[rowIndex][colIndex] = cellIndex;
            cellIndex++;
        }
    }

    public boolean winningGame(String marker) {
        String lineMarkers[] = {marker, marker, marker};
        for (int lineIndex = 0; lineIndex < ((rows * 2) + 2); lineIndex++) {
            String line[] = new String[rows];
            for (int i = 0; i < rows; i++) {
                String markerOnBoard = cells[winningLines[lineIndex][i]];
                line[i] = markerOnBoard;
            }
            if (Arrays.equals(line, lineMarkers)) {
              return true;
            }
        }
        return false;
    }
    public boolean gameOver() {
        if (winningGame("X") || winningGame("O")) {
            return true;
        } else if (!hasAvailableCell()) {
            return true;
        } else {
            return false;
        }
    }

    public void removeMarker(int cellIndex) {
        cells[cellIndex] = Integer.toString(cellIndex + 1);
    }

    private boolean isOpen(int cellIndex) {
       if ((!(cells[cellIndex] == "X") && !(cells[cellIndex] == "O"))) {
            return true;
        } else {
            return false;
        }
    }

}
