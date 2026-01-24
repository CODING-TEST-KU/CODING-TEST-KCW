package 스터디2026.DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 다리놓기_1010 {
  public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  public static int N;
  public static int M;
  public static int T;
  public static int[][] dp;

  public static void main(String[] args) throws IOException {
    T = Integer.parseInt(br.readLine());
    for (int i = 0; i < T; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      dp = new int[N + 1][M + 1];
      bw.write(String.valueOf(solution(N, M)));
      bw.newLine();
    }
    bw.flush();
  }

  public static int solution(int n, int m) {
    if (dp[n][m] != 0) {
      return dp[n][m];
    }
    if (n == 1) {
      dp[n][m] = m;
      return m;
    }
    if (n == m) {
      dp[n][m] = 1;
      return 1;
    }

    int result = 0;
    while (n <= m) {
      m--;
      int partitionResult = solution(n - 1, m);
      dp[n - 1][m] = partitionResult;
      result += partitionResult;
    }
    return result;
  }
}
