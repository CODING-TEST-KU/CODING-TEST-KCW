package 스터디2025.DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 연속합_1912 {
  static int[] arr;
  static Integer[] dp;
  static int max;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    arr = new int[N];
    dp = new Integer[N];

    for(int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    dp[0] = arr[0];
    max = arr[0];

    recur(N - 1);

    bw.write(String.valueOf(max));
    bw.flush();
    bw.close();
    br.close();
  }

  static int recur(int N) {

    if(dp[N] == null) {
      dp[N] = Math.max(recur(N - 1) + arr[N], arr[N]);

      max = Math.max(dp[N], max);
    }

    return dp[N];
  }
}
