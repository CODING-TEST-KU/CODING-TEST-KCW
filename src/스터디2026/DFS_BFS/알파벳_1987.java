package 스터디2026.DFS_BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 알파벳_1987 {
  public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  public static char[][] map;
  public static Set<Character> visited = new HashSet<>();
  public static int R;
  public static int C;
  public static int MAX_STEP = 0;
  public static int[] dx = {-1,1,0,0};
  public static int[] dy = {0,0,-1,1};

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    map = new char[R][C];

    for (int i = 0; i < R; i++) {
      String line = br.readLine();
      for (int j = 0; j < C; j++) {
        map[i][j] = line.charAt(j);
      }
    }

    dfs(0, 0, 1);

    bw.write(String.valueOf(MAX_STEP));
    bw.flush();
  }

  public static void dfs(int currentX, int currentY, int stepNum) {
    visited.add(map[currentX][currentY]);

    if (MAX_STEP < stepNum) {
      MAX_STEP = stepNum;
    }

    for (int i = 0; i < 4; i++) {
      int nextX = currentX + dx[i];
      int nextY = currentY + dy[i];

      if (nextX >= R || nextY >= C || nextX < 0 || nextY < 0) continue;
      if (visited.contains(map[nextX][nextY])) continue;

      dfs(nextX, nextY, stepNum + 1);
      visited.remove(map[nextX][nextY]);
    }


  }
}
