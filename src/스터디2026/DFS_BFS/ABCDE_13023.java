package 스터디2026.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class ABCDE_13023 {
  public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  public static List<Integer>[] relation;
  public static boolean[] visited;
  public static int N;
  public static int M;
  public static int STEP = 0;
  public static boolean heartingFlag = false;

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    relation = new LinkedList[N];

    for (int i = 0; i < N; i++) {
      relation[i] = new LinkedList<>();
    }

    for (int i = 0; i < M; i++) {
      StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
      int f1 = Integer.parseInt(st1.nextToken());
      int f2 = Integer.parseInt(st1.nextToken());

      relation[f1].add(f2);
      relation[f2].add(f1);
    }

    for (int i = 0; i < N; i++) {
      visited = new boolean[N];
      STEP = 0;
      dfs(i);

      if (heartingFlag) break;
    }

    if (heartingFlag) System.out.println(1);
    else System.out.println(0);
  }

  public static void dfs(int startP) {
    visited[startP] = true;
    STEP++;

    if (STEP == 5) {
      heartingFlag = true;
    }

    for (int nextP : relation[startP]) {
      if (visited[nextP]) continue;
      if (heartingFlag) return;
      dfs(nextP);
    }
    STEP--;
    visited[startP] = false;
  }

}
