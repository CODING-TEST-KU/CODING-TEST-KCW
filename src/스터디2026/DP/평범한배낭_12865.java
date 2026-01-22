package 스터디2026.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 평범한배낭_12865 {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N;
  static int K;
  static int[][] dp;
  static Item[] items;

  public static class Item {
    int k;
    int v;
    public Item(int k, int v) {
      this.k = k;
      this.v = v;
    }
  }

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    dp = new int[K + 1][N + 1];
    items = new Item[N + 1];

    for (int i = 1; i < N + 1; i++) {
      StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
      int k = Integer.parseInt(st1.nextToken());
      int v = Integer.parseInt(st1.nextToken());
      items[i] = new Item(k, v);
    }
    System.out.println(solution(1, K));
  }
  public static int solution(int n, int k) {
    if (n > N) return 0;
    Item current = items[n];
    if (current.k > k) return solution(n + 1, k);
    if (dp[k][n] != 0) return dp[k][n];

    return dp[k][n] = Math.max(solution(n + 1, k), solution(n + 1, k - current.k) + current.v);
  }

}
