package 스터디2026.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class ATM_11399 {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N;

  public static void main(String[] args) throws IOException {
    N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    List<Integer> list = new ArrayList<>();
    while (st.hasMoreTokens()) {
      list.add(Integer.valueOf(st.nextToken()));
    }
    list.sort(Comparator.naturalOrder());

    int result = 0;
    for (int i = 0; i < N; i++) {
      result += list.get(i) * (N - i);
    }
    System.out.println(result);
  }

}
