package 스터디2026.DFS_BFS;

import java.util.*;
import java.io.*;

public class 단지번호붙이기_2667 {

  public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  public static boolean[][] map;
  public static boolean[][] visited;
  public static int N;
  public static int[] dx = {-1, 1, 0, 0};
  public static int[] dy = {0, 0, -1, 1};

  public static class Dot {
    int x;
    int y;

    public Dot(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static void main(String[] args) throws IOException {
    // INIT
    N = Integer.parseInt(br.readLine());
    map = new boolean[N][N];
    visited = new boolean[N][N];

    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      for (int j = 0; j < N; j++) {
        if (line.charAt(j) == '1') {
          map[i][j] = true;
        }
      }
    }

    // BFS 조건
    List<Integer> results = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (!map[i][j]) continue;
        if (visited[i][j]) continue;

        int bfsResult = bfs(new Dot(i, j));
        results.add(bfsResult);
      }
    }

    // 결과 출력
    results.sort(Comparator.naturalOrder());
    System.out.println(results.size());
    results.forEach(System.out::println);
  }

  public static int bfs(Dot start) {
    int houseNum = 0;
    Deque<Dot> queue = new ArrayDeque<>();
    queue.offer(start);
    visited[start.x][start.y] = true;

    while (!queue.isEmpty()) {
      Dot currentDot = queue.poll();
      houseNum++;
      int currentX = currentDot.x;
      int currentY = currentDot.y;

      for (int i = 0; i < 4; i++) {
        int nextX = currentX + dx[i];
        int nextY = currentY + dy[i];

        if (nextX < 0 || nextY < 0) continue;
        if (nextX >= N || nextY >= N) continue;
        if (visited[nextX][nextY]) continue;
        if (!map[nextX][nextY]) continue;

        queue.offer(new Dot(nextX, nextY));
        visited[nextX][nextY] = true;
      }
    }

    return houseNum;
  }
}
