package 스터디2026.DFS_BFS;

import java.util.*;
import java.io.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class DFS와BFS_1260 {

  public static LinkedList<Integer>[] graph;
  public static boolean[] visitedDFS;
  public static boolean[] visitedBFS;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int V = Integer.parseInt(st.nextToken());

    visitedDFS = new boolean[N + 1];
    visitedBFS = new boolean[N + 1];

    //Init Graph
    graph = new LinkedList[N + 1];
    for (int i = 0; i <= N; i++) {
      graph[i] = new LinkedList<>();
    }

    for (int i = 0; i < M; i++) {
      StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
      int vertex = Integer.parseInt(st1.nextToken());
      int neighbor = Integer.parseInt(st1.nextToken());

      graph[vertex].add(neighbor);
      graph[neighbor].add(vertex);
    }

    for (LinkedList<Integer> neighbors : graph) {
      neighbors.sort(Comparator.naturalOrder());
    }

    //DFS/BFS Execute
    dfs(V);
    System.out.println();
    bfs(V);
  }

  public static void dfs(int start) {
    visitedDFS[start] = true;
    System.out.print(start + " ");
    for (int neighbor : graph[start]) {
      if (!visitedDFS[neighbor]) {
        dfs(neighbor);
      }
    }
  }

  public static void bfs(int start) {
    Deque<Integer> queue = new ArrayDeque<>();
    // Queue 에 넣는 순간 방문 완료
    queue.add(start);
    visitedBFS[start] = true;

    while (!queue.isEmpty()) {
      int current = queue.poll();
      System.out.print(current + " ");
      for (int neighbor : graph[current]) {
        if (!visitedBFS[neighbor]) {
          queue.add(neighbor);
          visitedBFS[neighbor] = true;
        }
      }
    }
  }

}
