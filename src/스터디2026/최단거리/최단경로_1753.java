package 스터디2026.최단거리;

import java.awt.GradientPaint;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최단경로_1753 {
  public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  public static int V;
  public static int E;
  public static int START;
  public static List<Edge>[] graph;
  public static long[] dist;
  static final long INF = Long.MAX_VALUE / 4;

  public static class Node implements Comparable<Node>{
    int n;
    long dist;

    public Node(int n, long dist) {
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

    public Edge(int v, int w) {
      this.to = v;
      this.weight = w;
    }
  }

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    V = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());
    START = Integer.parseInt(br.readLine());
    dist = new long[V + 1];
    Arrays.fill(dist, INF);

    graph = new List[V + 1];
    for (int i = 1; i < V + 1; i++){
      graph[i] = new LinkedList<>();
    }

    for (int i = 0; i < E; i++){
      StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
      int u = Integer.parseInt(st1.nextToken());
      int v = Integer.parseInt(st1.nextToken());
      int w = Integer.parseInt(st1.nextToken());

      graph[u].add(new Edge(v, w));
    }
    dijkstra(START);
    for (int i = 1; i < V + 1; i++) {
      if (dist[i] == INF){
        System.out.println("INF");
      }
      else {
        System.out.println(dist[i]);
      }
    }
  }

  public static void dijkstra(int start) {
    dist[start] = 0;
    PriorityQueue<Node> queue = new PriorityQueue<>();
    queue.offer(new Node(start, 0));

    while (!queue.isEmpty()) {
      Node currentNode = queue.poll();

      // out of data : 같은 노드가 이미 갱신이 되어서 계산되었음. (방문되었음)
      if (currentNode.dist != dist[currentNode.n]) continue;

      for (Edge e : graph[currentNode.n]) {
        if (currentNode.dist + e.weight < dist[e.to]) {
          //변경이 된다는건 아직 방문하지 않은 노드이므로 다음 방문할 큐에 삽입
          dist[e.to] = currentNode.dist + e.weight;
          queue.offer(new Node(e.to, dist[e.to]));
        }
      }
    }


  }
}
