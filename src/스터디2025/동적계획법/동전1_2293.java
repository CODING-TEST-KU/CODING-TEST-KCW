package 스터디2025.동적계획법;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 동전1_2293 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int[] coins = new int[N + 1];
    for (int i = 1; i < N + 1; i++) {
      coins[i] = Integer.parseInt(br.readLine());
    }
//=---------------------------
    int[][] dp = new int[N + 1][K + 1];

    for (int j = 1; j < K + 1; j++) {
      if (j % coins[1] == 0) {
        dp[1][j] = 1;
      }
      else {
        dp[1][j] = 0;
      }
    }

    for (int i = 2; i < N + 1; i++) {
      for (int j = 1; j < K + 1; j++) {
        if (j < coins[i]) {
          dp[i][j] = dp[i-1][j];
        }
        else if (j == coins[i] ) {
          dp[i][j] = dp[i-1][j] + 1;
        }
        else {
          dp[i][j] = dp[i-1][j] + dp[i][j - coins[i]];
        }
      }
    }


    bw.write(String.valueOf(dp[N][K]));
    bw.flush();
    bw.close();
    br.close();
  }

}
