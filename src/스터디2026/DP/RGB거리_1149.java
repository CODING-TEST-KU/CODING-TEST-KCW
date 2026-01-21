package 스터디2026.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGB거리_1149 {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N;
  static int[][] costs;
  static int[][] dp;
  static int[] colorDelta = {1, 2, 0, 1};
  static int RED = 0;
  static int BLUE = 1;
  static int GREEN = 2;

  public static void main(String[] args) throws IOException {
    N = Integer.parseInt(br.readLine());
    costs = new int[N][3];
    dp = new int[N][3];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      costs[i][BLUE] = Integer.parseInt(st.nextToken());
      costs[i][RED] = Integer.parseInt(st.nextToken());
      costs[i][GREEN] = Integer.parseInt(st.nextToken());
      dp[i][BLUE] = Integer.MAX_VALUE;
      dp[i][RED] = Integer.MAX_VALUE;
      dp[i][GREEN] = Integer.MAX_VALUE;
    }

    System.out.println(Math.min(Math.min(recursion(0, RED), recursion(0, BLUE)), recursion(0, GREEN)));
  }

  public static int recursion(int n, int color) {
    if (dp[n][color] != Integer.MAX_VALUE) return dp[n][color];
    if (n == N - 1) return costs[n][color];

    return dp[n][color] = Math.min(recursion(n + 1, colorDelta[color]), recursion(n + 1, colorDelta[color + 1])) + costs[n][color];
  }
}
