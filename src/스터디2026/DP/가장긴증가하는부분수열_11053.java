package 스터디2026.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열_11053 {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N;
  static int[] sequence;
  static int[][] dp;

  public static void main(String[] args) throws IOException {
    N = Integer.parseInt(br.readLine());
    sequence = new int[N];
    dp = new int[N][N + 1];
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < N; i++) {
      sequence[i] = Integer.parseInt(st.nextToken());
    }

    System.out.println(solution(0, N, 0));
  }

  public static int solution(int max, int maxIndex, int n) {
    if (dp[n][maxIndex] != 0) return dp[n][maxIndex];

    if (sequence[n] <= max) {
      if (n == N - 1) {
        return 0;
      }
      return solution(max, maxIndex, n + 1);
    }

    if (n == N - 1) {
      return 1;
    }

    int selectResult = solution(sequence[n], n, n + 1) + 1;
    int nonSelectResult = solution(max, maxIndex, n + 1);
    if (selectResult > nonSelectResult) {
      dp[n][maxIndex] = selectResult;
      return selectResult;
    }
    else {
      dp[n][maxIndex] = nonSelectResult;
      return nonSelectResult;
    }
  }

}
