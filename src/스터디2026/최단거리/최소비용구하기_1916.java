package 스터디2026.최단거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소비용구하기_1916 {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N;
  static int M;
  static int START;
  static int END;
  static List<Edge>[] graph;
  static long[] dist;

  public static class Node implements Comparable<Node> {
    int n;
    long dist;

    public Node (int n, long dist) {
      this.n = n;
      this.dist = dist;
    }

    @Override
    public int compareTo(Node o) {
      return Long.compare(dist, o.dist);
    }
  }

  public static class Edge {
    int to;
    int weight;

    public Edge(int to, int weight) {
      this.to = to;
      this.weight = weight;
    }
  }

  public static void main(String[] args) throws IOException {
    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());
    dist = new long[N + 1];
    Arrays.fill(dist, Long.MAX_VALUE/4);

    graph = new List[N + 1];

    for (int i = 0; i < N + 1; i++) {
      graph[i] = new LinkedList<>();
    }

    for (int i = 0; i < M; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      int x = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());

      graph[x].add(new Edge(to, weight));
    }

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    START = Integer.parseInt(st.nextToken());
    END = Integer.parseInt(st.nextToken());

    System.out.println(dijkstra(new Node(START, 0)));
  }

  public static long dijkstra(Node start) {
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.offer(start);
    dist[start.n] = 0;

    while (!pq.isEmpty()) {
      Node currentNode = pq.poll();
      if (currentNode.dist != dist[currentNode.n]) continue;
      if (currentNode.n == END) return currentNode.dist;

      for (Edge edge: graph[currentNode.n]) {
        if (currentNode.dist + edge.weight < dist[edge.to]) {
          pq.offer(new Node(edge.to, currentNode.dist + edge.weight));
          dist[edge.to] = currentNode.dist + edge.weight;
        }
      }
    }

    return -1;
  }

}
