package 스터디2025.알고리즘구현;

import 스터디2025.알고리즘구현.정렬.InsertionSort;
import 스터디2025.알고리즘구현.정렬.SortExecutor;

public class AlgorithmMain {

  public static void main(String[] args) {
    int[] input = new int[]{5, 3, 6, 4, 2};
    SortExecutor.executeAndPrintResult(new InsertionSort(), input);
  }
}
