package 스터디2026.DFS_BFS;
import java.util.*;
import java.io.*;

public class 숨바꼭질_1697 {
  public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  public static boolean[] visited = new boolean[100002];
  public static int N;
  public static int K;

  public static class Stamp {
    int x;
    int time;

    public Stamp(int x, int time) {
      this.x = x;
      this.time = time;
    }
  }

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    System.out.println(bfs());
  }

  public static int bfs() {
    Deque<Stamp> queue = new ArrayDeque<>();
    queue.offer(new Stamp(N, 0));
    visited[N] = true;

    while (true) {
      Stamp currentStamp = queue.poll();
      if (currentStamp.x == K) {
        return currentStamp.time;
      }

      if (!(currentStamp.x - 1 < 0) && !visited[currentStamp.x - 1]) {
        queue.offer(new Stamp(currentStamp.x - 1, currentStamp.time + 1));
        visited[currentStamp.x - 1] = true;
      }

      if (currentStamp.x + 1 > 100000) continue;
      if (!visited[currentStamp.x + 1]) {
        queue.offer(new Stamp(currentStamp.x + 1, currentStamp.time + 1));
        visited[currentStamp.x + 1] = true;
      }

      if (currentStamp.x * 2 > 100000) continue;
      if (!visited[currentStamp.x * 2]) {
        queue.offer(new Stamp(currentStamp.x * 2, currentStamp.time + 1));
        visited[currentStamp.x * 2] = true;
      }
    }
  }

}
