package 스터디2026.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 안전영역_2468 {
  public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  public static int[] dx = {-1, 1, 0, 0};
  public static int[] dy = {0, 0, -1, 1};
  public static int[][] graph;
  public static boolean[][] visited;
  public static int N;
  public static int MAX_HEIGHT = 0;

  public static class Point {
    int x;
    int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static void main(String[] args) throws IOException {
    N = Integer.parseInt(br.readLine());
    graph = new int[N][N];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < N; j++) {
        int currentHeight = Integer.parseInt(st.nextToken());
        graph[i][j] = currentHeight;
        if (currentHeight > MAX_HEIGHT) {
          MAX_HEIGHT = currentHeight;
        }
      }
    }

    int maxSafeNum = 0;
    for (int waterHeight = 0; waterHeight < MAX_HEIGHT; waterHeight++) {
      int localSafeNum = 0;
      visited = new boolean[N][N];

      for (int x = 0; x < N; x++) {
        for (int y = 0; y < N; y++) {
          if (visited[x][y]) continue;
          if (graph[x][y] <= waterHeight) continue;
          bfs(new Point(x, y), waterHeight);
          localSafeNum++;
        }
      }

      if (maxSafeNum < localSafeNum) {
        maxSafeNum = localSafeNum;
      }
    }

    System.out.println(maxSafeNum);
  }

  public static void bfs(Point start, int waterHeight) {
    Deque<Point> queue = new ArrayDeque<>();
    queue.offer(start);
    visited[start.x][start.y] = true;

    while (!queue.isEmpty()) {
      Point current = queue.poll();
      for (int i = 0; i < 4; i++) {
        int nextX = current.x + dx[i];
        int nextY = current.y + dy[i];

        if (nextX >= N || nextY >= N || nextX < 0 || nextY < 0) continue;
        if (graph[nextX][nextY] <= waterHeight) continue;
        if (visited[nextX][nextY]) continue;

        queue.offer(new Point(nextX, nextY));
        visited[nextX][nextY] = true;
      }
    }
  }

}
