package 스터디2025.동적계획법;

import java.io.*;
import java.util.*;

public class 퇴사1_14501 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    int[] T = new int[N + 1];
    int[] P = new int[N + 1];

    StringTokenizer st;
    for (int i = 1; i < N + 1; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      T[i] = Integer.parseInt(st.nextToken());
      P[i] = Integer.parseInt(st.nextToken());
    }

    int[] dp = new int[N + 1];
    int localMax = 0;
    for (int i = N; i > 0; i--) {
      if(T[i] + i > N + 1) {
        dp[i] = localMax;
      }
      else if (T[i] + i == N + 1) {
        if (localMax < P[i]) {
          dp[i] = P[i];
          localMax = P[i];
        }
        else {
          dp[i] = localMax;
        }
      }
      else {
        if (localMax < dp[i]) {
          dp[i] = P[i] + dp[i + T[i]];
          localMax = dp[i];
        }
        else {
          dp[i] = localMax;
        }
      }

    }
    bw.write(String.valueOf(dp[1]));
    bw.flush();
    br.close();
    bw.close();
  }
}
