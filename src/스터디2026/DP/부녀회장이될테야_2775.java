package 스터디2026.DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 부녀회장이될테야_2775 {
  public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  public static int K;
  public static int N;
  public static int T;
  public static int[][] dp;

  public static void main(String[] args) throws IOException {
    T = Integer.parseInt(br.readLine());
    for (int i = 0; i < T; i++) {
      K = Integer.parseInt(br.readLine());
      N = Integer.parseInt(br.readLine());
      dp = new int[K + 1][N + 1];

      for (int k = 0; k < K + 1; k++) {
        for (int n = 1; n < N + 1; n++) {
          solution(k, n);
        }
      }
      bw.write(String.valueOf(dp[K][N]));
      bw.newLine();
    }
    bw.flush();
  }

  public static void solution(int k, int n) {
    if (k == 0) {
      dp[k][n] = n;
      return;
    }
    dp[k][n] = dp[k][n - 1] + dp[k - 1][n];
    return;
  }
}
