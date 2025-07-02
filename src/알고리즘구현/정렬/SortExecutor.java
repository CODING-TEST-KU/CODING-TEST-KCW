package 알고리즘구현.정렬;

import java.util.Arrays;

public class SortExecutor {
  public static void executeAndPrintResult(Sort sortAlgorithm, int[] list) {
    String result = Arrays.toString(sortAlgorithm.sort(list));
    System.out.println(result);
  }
}
