package 스터디2025.정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class 수열정렬_1015 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(br.readLine());

    List<Integer> sortedList = new ArrayList<>();
    List<Integer> originalList = new ArrayList<>();
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    while (st.hasMoreElements()) {
      Integer next = Integer.valueOf(st.nextToken());
      sortedList.add(next);
      originalList.add(next);
    }

    sortedList.sort(null);

    // Map(originalList[i], P[i])
    Map<Integer, Integer> indexMap = new HashMap<>();

    int previousValue = -1;
    for (int i = 0; i < N; i++) {
      if (previousValue != sortedList.get(i)){
        indexMap.put(sortedList.get(i), i);
      }
      previousValue = sortedList.get(i);
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      Integer pi = indexMap.get(originalList.get(i));
      sb.append(pi).append(" ");
      indexMap.put(originalList.get(i), pi + 1);
    }

    bw.write(sb.toString());
    bw.close();
    br.close();

  }

}
