package 스터디2026.DFS_BFS;
import java.util.*;
import java.io.*;

public class 바이러스_2606 {

  public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  public static int V;
  public static int E;
  public static List<Integer>[] graph;
  public static boolean[] visited;
  public static int visitedNum = 0;

  public static void main(String[] args) throws IOException {
    V = Integer.parseInt(br.readLine());
    E = Integer.parseInt(br.readLine());

    //Init
    visited = new boolean[V + 1];
    graph = new LinkedList[V + 1];

    for (int i = 0; i < V + 1; i++) {
      graph[i] = new LinkedList<>();
    }

    for (int i = 0; i < E; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");

      int first = Integer.parseInt(st.nextToken());
      int second = Integer.parseInt(st.nextToken());

      graph[first].add(second);
      graph[second].add(first);
    }
    bfs();
    System.out.println(visitedNum);
  }

  public static void bfs() {
    Deque<Integer> queue = new ArrayDeque<>();
    int startV = 1;
    queue.add(startV);
    visited[startV] = true;

    while (!queue.isEmpty()) {
      int currentV = queue.poll();
      for (int nextV : graph[currentV]) {
        if (visited[nextV]) continue;
        queue.add(nextV);
        visitedNum++;
        visited[nextV] = true;
      }
    }
  }

}
