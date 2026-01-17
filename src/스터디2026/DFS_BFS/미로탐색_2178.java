package 스터디2026.DFS_BFS;

import java.util.*;
import java.io.*;

public class 미로탐색_2178 {

  public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N, M;
  public static boolean[][] map;
  public static boolean[][] visited;
  public static int[] dx = {-1, 1, 0, 0};
  public static int[] dy = {0, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    
    // map 초기화
    map = new boolean[N][M];
    visited = new boolean[N][M];

    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      for (int j = 0; j < line.length(); j++) {
        map[i][j] = line.charAt(j) == '1';
      }
    }

    bfs();
  }

  public static void bfs() throws IOException {
    Deque<Dot> queue = new ArrayDeque<>();
    int startX = 0;
    int startY = 0;

    queue.add(new Dot(startX, startY, 1));
    visited[startX][startY] = true;

    while (!queue.isEmpty()) {
      Dot dot = queue.poll();
      int currentX = dot.x;
      int currentY = dot.y;
      int currentSequence = dot.sequence;

      if (currentX == N - 1 && currentY == M - 1) {
        System.out.println(currentSequence);
        return;
      }

      for (int i = 0; i < 4; i++) {
        Dot nextDot = new Dot(currentX + dx[i], currentY + dy[i], currentSequence + 1);

        if (nextDot.x < 0 || nextDot.y < 0 || nextDot.x >= N || nextDot.y >= M) {
          continue;
        }

        if (!visited[nextDot.x][nextDot.y] && map[nextDot.x][nextDot.y]) {
          queue.add(nextDot);
          visited[nextDot.x][nextDot.y] = true;
        }
      }
    }


  }

  public static class Dot {
    int x;
    int y;
    int sequence;

    public Dot(int x, int y, int sequence) {
      this.x = x;
      this.y = y;
      this.sequence = sequence;
    }
  }
}
