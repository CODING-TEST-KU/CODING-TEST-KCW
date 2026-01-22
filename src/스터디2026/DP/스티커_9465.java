package 스터디2026.DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 스티커_9465 {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  static int T;
  static int N;
  static int[][] scores;
  static int[][] dp;

  public static void main(String[] args) throws IOException {
    T = Integer.parseInt(br.readLine());

    for (int t = 0; t < T; t++) {
      N = Integer.parseInt(br.readLine());
      scores = new int[2][N];
      dp = new int[2][N];

      StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
      for (int i = 0; i < N; i++) {
        scores[0][i] = Integer.parseInt(st1.nextToken());
        dp[0][i] = -1;
      }

      StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
      for (int i = 0; i < N; i++) {
        scores[1][i] = Integer.parseInt(st2.nextToken());
        dp[1][i] = -1;
      }

      for (int i = 0; i < N; i++) {
        solution(i);
      }
      int result = Math.max(dp[0][N - 1], dp[1][N - 1]);
      bw.write(String.valueOf(result));
      bw.newLine();
    }

    bw.flush();
  }


  public static void solution(int n) {
    if (n == 0) {
      dp[0][n] = scores[0][n];
      dp[1][n] = scores[1][n];
      return;
    }

    if (n == 1) {
      dp[0][n] = scores[0][n] + scores[1][n - 1];
      dp[1][n] = scores[1][n] + scores[0][n - 1];
      return;
    }

    dp[0][n] = Math.max(dp[1][n - 1], dp[1][n - 2]) + scores[0][n];
    dp[1][n] = Math.max(dp[0][n - 1], dp[0][n - 2]) + scores[1][n];

  }

}
