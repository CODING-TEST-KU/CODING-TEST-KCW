package 알고리즘구현;

import 알고리즘구현.정렬.BubbleSort;
import 알고리즘구현.정렬.InsertionSort;
import 알고리즘구현.정렬.SelectionSort;
import 알고리즘구현.정렬.SortExecutor;

public class AlgorithmMain {

  public static void main(String[] args) {
    int[] input = new int[]{5, 3, 6, 4, 2};
    SortExecutor.executeAndPrintResult(new InsertionSort(), input);
  }
}
