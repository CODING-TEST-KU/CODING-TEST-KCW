package 스터디2026.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class 연결요소의개수_11724 {

  public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  public static int N;
  public static int M;
  public static List<Integer>[] graph;
  public static boolean[] visited;

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    visited = new boolean[N + 1];
    graph = new LinkedList[N + 1];

    for (int i = 0; i < N + 1; i++) {
      graph[i] = new LinkedList<>();
    }

    for (int i = 0; i < M; i++) {
      StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
      int v1 = Integer.parseInt(st1.nextToken());
      int v2 = Integer.parseInt(st1.nextToken());

      graph[v1].add(v2);
      graph[v2].add(v1);
    }

    int result = 0;
    for (int i = 1; i < N + 1; i++) {
      if (visited[i]) {
        continue;
      }
      bfs(i);
      result++;
    }

    System.out.println(result);
  }

  public static void bfs(int start) {
    Deque<Integer> queue = new ArrayDeque<>();
    queue.offer(start);
    visited[start] = true;

    while (!queue.isEmpty()) {
      int currentVertex = queue.poll();

      for (int nearVertex : graph[currentVertex]) {
        if (visited[nearVertex]) {
          continue;
        }
        queue.offer(nearVertex);
        visited[nearVertex] = true;
      }
    }
  }

}
