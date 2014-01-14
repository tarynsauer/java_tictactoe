package tictactoe;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
/**
 * Created by Taryn on 1/8/14.
 */
public class MockPrintStream extends PrintStream {
    public ArrayList<String> printCallHistory;

    public void setPrintCallHistory(ArrayList<String> printCallHistory) {
        this.printCallHistory = printCallHistory;
    }

    public MockPrintStream(OutputStream outputStream) {
      super(outputStream);
    }

    public void println(String printOutput) {
      printCallHistory.add(printOutput);
    }

    public void print(String printOutput) {
      printCallHistory.add(printOutput);
    }

    public String getPrintCallHistory() {
      int arrayLength = printCallHistory.size();
      StringBuilder result;
      result = new StringBuilder();
      for (int i = 0; i < arrayLength; i++) {
        result.append(printCallHistory.get(i));
      }
      return result.toString();
    }

    public String lastPrintCall() {
      return printCallHistory.get(printCallHistory.size() - 1);
    }

}
