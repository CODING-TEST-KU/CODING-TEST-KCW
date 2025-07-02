package 스터디2025.알고리즘구현.정렬;

public class BubbleSort implements Sort {

  @Override
  public int[] sort(int[] list) {
    for (int i = 0; i < list.length; i++) {
      for (int j = 0; j < list.length - 1 - i; j++) {
        if (list[j] > list[j + 1]) {
          int temp = list[j];
          list[j] = list[j+1];
          list[j+1] = temp;
        }
      }
    }
    return list;
  }
}
