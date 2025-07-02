package 알고리즘구현.정렬;

public class SelectionSort implements Sort {

  @Override
  public int[] sort(int[] list) {

    for (int i = 0; i < list.length - 1; i++) {
      int minIndex = i;
      for (int j = i; j < list.length; j++) {
        if (list[minIndex] > list[j]) {
          minIndex = j;
        }
      }
      int temp = list[i];
      list[i] = list[minIndex];
      list[minIndex] = temp;
    }

    return list;
  }
}
