package 스터디2024.x7BFS;

import java.io.*;
import java.util.*;

public class 유기농배추_1012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numOfTestCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < numOfTestCase; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int width = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            int numOfNode = Integer.parseInt(st.nextToken());

            Graph graph = new Graph(width, height, numOfNode);
            graph.initGraph(br);

            long result = graph.existList.stream()
                    .filter(intPair -> graph.BFS(intPair.x, intPair.y))
                    .count();

            bw.write(String.valueOf(result));
            bw.newLine();


        }

        bw.flush();
        bw.close();
        br.close();

    }

    public static class Graph{
        int[][] graph;
        List<intPair> existList = new ArrayList<>();
        int numOfNodes;
        int dx[] = {0, 0, -1, 1};
        int dy[] = {-1, 1, 0, 0};

        public Graph(int width, int height, int numOfNode){
            graph = new int[height][width];
            this.numOfNodes = numOfNode;
        }

        public void initGraph(BufferedReader br) throws IOException {
            for(int i = 0; i < numOfNodes; i++){
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                existList.add(new intPair(x, y));
                graph[y][x] = 1;
            }
        }


        public boolean BFS(int startX, int startY){

            //queue(BFS) 혹은 stack(DFS) 선언
            Deque<intPair> queue = new ArrayDeque<>();

            //시작 지점이 -1일 경우 이미 어떠한 배추흰지렁이에 의해서 보호됨.
            if(graph[startY][startX] == -1)
                return false;

            //첫번째 노드를 queue 에 넣음.
            queue.push(new intPair(startX, startY));
            //첫번째 노드를 방문했다는 표시를 함.
            graph[startY][startX] = -1;

            while(!queue.isEmpty()){

                //queue 에서 노드 하나를 꺼냄
                intPair present = queue.pollLast();

                //노드와 인접한 노드를 모두 확인하여 1일 경우에만 queue 에 넣음.
                for(int i = 0; i < 4; i++){
                    int nextX = present.x + dx[i];
                    int nextY = present.y + dy[i];

                    //존재하는 인데스이며, 0과 -1이 아닐 경우
                    if(isExistence(nextX, nextY)){
                        queue.push(new intPair(nextX, nextY));
                        graph[nextY][nextX] = -1;
                    }

                }

            }

            return true;

        }

        public boolean isExistence(int x, int y){

            if(x < 0 || y < 0 || x >= graph[0].length || y >= graph.length)
                return false;
            else if(graph[y][x] == 0 || graph[y][x] == -1)
                return false;

            return true;

        }





        public class intPair{
            int x;
            int y;

            public intPair(int x, int y){
                this.x = x;
                this.y = y;
            }
        }

    }
}
