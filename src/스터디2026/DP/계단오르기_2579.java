package 스터디2026.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 계단오르기_2579 {
  public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  public static int N;
  public static int[] scores;
  public static int[][] dp;

  public static void main(String[] args) throws IOException {
    N = Integer.parseInt(br.readLine());
    scores = new int[N + 1];
    dp = new int[N + 1][3];
    dp[0][0] = -1;
    dp[0][1] = -1;
    dp[0][2] = -1;

    for (int i = 1; i < N + 1; i++) {
      scores[i] = Integer.parseInt(br.readLine());
      dp[i][0] = -1;
      dp[i][1] = -1;
      dp[i][2] = -1;
    }
    System.out.println(getStairMaxScore(0, 0));
  }

  public static int getStairMaxScore(int startStair, int sequence) {
    if (dp[startStair][sequence] != -1) return dp[startStair][sequence];

    if (startStair == N) return scores[startStair];
    if (startStair == N - 1) return scores[startStair] + scores[startStair + 1];

    if (startStair == N - 2) {
      if (startStair == 0) return scores[startStair + 1] + scores[startStair + 2];
      return scores[startStair] + scores[startStair + 2];
    }

    int left = -1;
    if (sequence != 2) {
      left = getStairMaxScore(startStair + 1, sequence + 1);
    }
    int right = getStairMaxScore(startStair + 2, 1);
    dp[startStair][sequence] = Math.max(left, right) + scores[startStair];
    return dp[startStair][sequence];
  }

}
