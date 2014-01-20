package tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static tictactoe.TictactoeConstants.O_MARKER;
import static tictactoe.TictactoeConstants.X_MARKER;
/**
 * Created by Taryn on 1/7/14.
 */
public class Board {

    private int rows;
    private String[] cells;
    private int[][] winningLines;

    public Board(int size) {
        this.rows = size;
        cells = new String[rows * rows];
        for (int num = 1; num <= (cells.length); num++) {
            int i = num - 1;
            cells[i] = Integer.toString(num);
        }
        this.winningLines = new int[(rows + rows + 2)][rows];
        getWinningLines();
        setCells(cells);
    }

    public int getRows() {
        return rows;
    }

    public String[] getCells() {
        return this.cells;
    }

    public void setCells(String[] cells) {
        this.cells = cells;
    }

    public boolean hasAvailableCell() {
        for (String cellValue : cells) {
            if ((!(cellValue.equals(X_MARKER)) && !(cellValue.equals(O_MARKER))))
                return true;
        }
        return false;
    }

    public ArrayList<Integer> availableCellIndexes() {
        ArrayList<Integer> openCellIndexes = new ArrayList<Integer>();
        for (int i = 0; i < cells.length; i++) {
            if ((!(cellValue(i).equals(X_MARKER)) && !(cellValue(i).equals(O_MARKER))))
                openCellIndexes.add(i);
        }
        return openCellIndexes;
    }

    public boolean validMove(String move) {
        if (tryParse(move)) {
            int cellIndex = (new Integer(move) - 1);
            int totalCellsCount = rows * rows;
            return (cellIndex >= 0) && (cellIndex < totalCellsCount) && isOpen(cellIndex);
        } else {
            return false;
        }
    }

    public int[][] getWinningLines() {
        getAllRows();
        getColumns();
        getDiagonal(0, (rows * 2), (rows + 1));
        getDiagonal((rows - 1), ((rows * 2) + 1), (rows - 1));
        return winningLines;
    }

    public String getRandomCell() {
        Random randomGenerator = new Random();
        ArrayList<Integer> openCells = availableCellIndexes();
        int index = randomGenerator.nextInt(openCells.size());
        int randomCellIndex = openCells.get(index);
        return cells[randomCellIndex];
    }

    public boolean winningGame(String marker) {
        String lineMarkers[] = new String[rows];
        Arrays.fill(lineMarkers, marker);
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
        return (winningGame(X_MARKER) || winningGame(O_MARKER)) || !hasAvailableCell();
    }

    public void removeMarker(int cellIndex) {
        cells[cellIndex] = Integer.toString(cellIndex + 1);
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

    private boolean isOpen(int cellIndex) {
        return (!(cellValue(cellIndex).equals(X_MARKER)) && !(cellValue(cellIndex).equals(O_MARKER)));
    }

    private String cellValue(int cellIndex) {
        return cells[cellIndex];
    }

    private static boolean tryParse(String input) {
        if (input.length() > 0) {
            try {
                new Integer(input);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        } else {
            return false;
        }

    }
}
