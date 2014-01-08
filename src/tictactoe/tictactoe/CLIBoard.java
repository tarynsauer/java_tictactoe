package tictactoe.tictactoe;

import tictactoe.Board;

/**
 * Created by Taryn on 1/7/14.
 */
public class CLIBoard extends Board {

  public CLIBoard() {
  }

  public void printRowNumbers() {
    System.out.print("|  1  |  2  |  3  |");
  }
}
