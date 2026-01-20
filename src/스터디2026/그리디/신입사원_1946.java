package 스터디2026.그리디;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 신입사원_1946 {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int T;
  static int N;
  static int[][] grade;

  public static void main(String[] args) throws IOException {
    T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; i++) {
      N = Integer.parseInt(br.readLine());
      grade = new int[N][2];

      for (int j = 0; j < N; j++) {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        grade[x - 1][0] = x;
        grade[x - 1][1] = y;
      }

      int minY = N;
      int result = 0;
      for (int j = 0; j < N; j++) {
        int currentY = grade[j][1];
        if (currentY > minY) continue;
        minY = currentY;
        result++;
      }

      bw.write(String.valueOf(result));
      bw.newLine();
    }
    bw.flush();
  }
}
