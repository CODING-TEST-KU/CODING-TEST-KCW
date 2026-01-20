package 스터디2026.DFS_BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class 이분그래프_1707 {
  public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  public static List<Vertex>[] graph;
  public static Vertex[] vertexSet;
  public static boolean[] visited;
  public static int K;
  public static int V;
  public static int E;
  public static int RED = 1;
  public static int BLUE = 2;
  public static int EMPTY = 0;

  public static class Vertex {
    int num;
    int color = EMPTY;

    public Vertex(int num) {
      this.num = num;
    }
    public Vertex(int num, int color) {
      this.num = num;
      this.color = color;
    }

    public void paint(int nearColor) {
      if (nearColor == RED) {
        this.color = BLUE;
      }
      else if (nearColor == BLUE) {
        this.color = RED;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    K = Integer.parseInt(br.readLine());

    for (int i = 0; i < K; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      V = Integer.parseInt(st.nextToken());
      E = Integer.parseInt(st.nextToken());
      graph = new LinkedList[V + 1];
      visited = new boolean[V + 1];
      vertexSet = new Vertex[V + 1];

      for (int j = 0; j < V + 1; j++) {
        graph[j] = new LinkedList<>();
      }

      for (int j = 0; j < E; j++) {
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        int v1 = Integer.parseInt(st1.nextToken());
        int v2 = Integer.parseInt(st1.nextToken());

        if (vertexSet[v1] == null) vertexSet[v1] = new Vertex(v1);
        if (vertexSet[v2] == null) vertexSet[v2] = new Vertex(v2);

        graph[v1].add(vertexSet[v2]);
        graph[v2].add(vertexSet[v1]);
      }

      int n = 0;
      for (int k = 1; k < V + 1; k++) {
        if (vertexSet[k] == null) continue;
        if (!bfs(vertexSet[k])){
          bw.write("NO");
          n = 1;
          break;
        }
      }
      if (n == 0) bw.write("YES");
      bw.newLine();
    }
    bw.flush();
  }

  public static boolean bfs(Vertex start) {
    Deque<Vertex> queue = new ArrayDeque<>();
    if (start.color == EMPTY) start.color = RED;
    queue.offer(start);
    visited[start.num] = true;

    while (!queue.isEmpty()) {
      Vertex currentV = queue.poll();
      int currentColor = currentV.color;

      for (Vertex nearV : graph[currentV.num]) {
        if (visited[nearV.num]) {
          if (nearV.color == currentColor){
            return false;
          }
          else {
            continue;
          }
        }
        nearV.paint(currentColor);
        queue.offer(nearV);
        visited[nearV.num] = true;
      }
    }
    return true;
  }

}
