package 스터디2025.이분탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class 나무자르기_2805 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    List<Long> treeH = new ArrayList<>();
    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < N; i++) {
      treeH.add(Long.parseLong(st.nextToken()));
    }
    treeH.add(0L);
    treeH.sort(Comparator.reverseOrder());

    List<Long> treeHeightDifference = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      treeHeightDifference.add((treeH.get(i) - treeH.get(i + 1)) * (i + 1));
    }

    Long sum = 0L;
    for (int i = 0; i < N; i++) {
      sum += treeHeightDifference.get(i);
      if (sum < M) {
        continue;
      }

      Long collectValue = (sum - M) / (i + 1);
      Long result = treeH.get(i + 1) + collectValue;

      bw.write(String.valueOf(result));
      bw.close();
      br.close();
      return;
    }
  }

}
