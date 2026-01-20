package 스터디2026.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 잃어버린괄호_1541 {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static Deque<Integer> number = new ArrayDeque<>();

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine(), "-");

    while (st.hasMoreTokens()) {
      StringTokenizer st1 = new StringTokenizer(st.nextToken(), "+");

      int localResult = 0;
      while (st1.hasMoreTokens()) {
        localResult += Integer.parseInt(st1.nextToken());
      }
      number.offer(localResult);
    }

    int result = number.poll();
    while (!number.isEmpty()) {
      result -= number.poll();
    }

    System.out.println(result);

  }
}
