package 알고리즘구현.정렬;

public class InsertionSort implements Sort{

  @Override
  public int[] sort(int[] list) {
    int[] sortedList = new int[list.length];
    for(int i = 0; i < list.length; i++) {
      insert(sortedList, i, list[i]);
    }
    return sortedList;
  }

  private void insert(int[] list, int currentLength, int value) {
    if (list.length <= currentLength) {
      return;
    }
    int i;
    for (i = 0; i < currentLength; i++) {
      if (list[i] >= value) {
        break;
      }
    }
    for (int j = currentLength; j > i; j--) {
      list[j] = list[j-1];
    }
    list[i] = value;
  }
}
