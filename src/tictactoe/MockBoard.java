package tictactoe;

/**
 * Created by Taryn on 1/8/14.
 */
public class MockBoard extends Board {
  public String[] cells;

  public MockBoard() {
    cells = new String[9];
    for (int num = 1; num <= (cells.length); num++) {
      int i = num - 1;
      cells[i] = Integer.toString(num);
    }
  }

}
