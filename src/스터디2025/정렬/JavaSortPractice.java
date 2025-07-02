package 스터디2025.정렬;

import com.sun.source.tree.Tree;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class JavaSortPractice {

  public static void main(String[] args) {

    // Array Sort
    int[] arr = {5, 3, 7, 1, 2};
    Arrays.sort(arr);
    System.out.println(Arrays.toString(arr));

    // Java Stream 정렬
    arr = Arrays.stream(arr)
        .sorted()
        .toArray();

    // Java Collection Sort
    List<Integer> list = Arrays.asList(5, 3, 8, 1, 2);
    Collections.sort(list);
    System.out.println(list);
    list.sort(Comparator.naturalOrder()); // -> Comparator 를 구현하여 커스텀 가능
    list.sort(Comparator.reverseOrder());
    System.out.println(list);
    list.sort(new C());
    list = list.stream()
        .sorted()
        .toList();
    // 내부적으로 정렬되는 자료구조
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    pq.add(3);
    pq.add(1);
    pq.add(2);

    while (!pq.isEmpty()) {
      System.out.println(pq.poll()); // 1, 2, 3
    }

    SortedSet<Integer> set = new TreeSet<>(List.of(5,1,4));
    System.out.println(set);

    SortedMap<Integer, String> map = new TreeMap<>();
    map.put(2, "a");
    map.put(1, "b");
    map.put(3, "c");
    System.out.println(map);


  }

  // 커스텀 Comparator
  public static class C implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
      return 0;
    }
  }

}
