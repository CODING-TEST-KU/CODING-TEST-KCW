package 스터디2026.최단거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class 특정거리의도시찾기_18352 {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N;
  static int M;
  static int K;
  static int X;
  static List<Integer>[] graph;
  static boolean[] visited;
  static List<Integer> results = new ArrayList<>();

  public static class Node {
    int x;
    int dist;
    public Node (int x, int dist) {
      this.x = x;
      this.dist = dist;
    }
  }
  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    X = Integer.parseInt(st.nextToken());
    visited = new boolean[N + 1];
    graph = new List[N + 1];
    for (int i = 0; i < N + 1; i++) {
      graph[i] = new LinkedList<>();
    }

    for (int i = 0; i < M; i++) {
      StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
      int x = Integer.parseInt(st1.nextToken());
      int y = Integer.parseInt(st1.nextToken());

      graph[x].add(y);
    }

    bfs(new Node(X, 0));

    if (results.isEmpty()) {
      System.out.println(-1);
    }
    results.sort(Comparator.naturalOrder());

    for (Integer result : results) {
      System.out.println(result);
    }

  }

  public static void bfs(Node node) {
    Deque<Node> queue = new ArrayDeque<>();
    queue.offer(node);
    visited[node.x] = true;

    while (!queue.isEmpty()) {
      Node poll = queue.poll();
      if (poll.dist == K) {
        results.add(poll.x);
        continue;
      }
      for (int near : graph[poll.x]) {
        if (visited[near]) continue;
        queue.offer(new Node(near, poll.dist + 1));
        visited[near] = true;
      }
    }
  }

}
