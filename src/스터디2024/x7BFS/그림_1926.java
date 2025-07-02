package 스터디2024.x7BFS;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class 그림_1926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

        Painting painting = new Painting(height, width);
        painting.initGraph(br);

        long count = 0L;
        long max = 0L;

        for(int i = 0; i < painting.existNodeList.size(); i++){

            int result = painting.BFS(painting.existNodeList.get(i).height, painting.existNodeList.get(i).width);

            if(result != -1){
                count++;

                if(max < result)
                    max = result;
            }


        }


        bw.write(String.valueOf(count));
        bw.newLine();
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
        br.close();

    }

    public static class Painting{
        int[][] graph;
        int height;
        int width;

        int[] dh = {0,0,-1,1};
        int[] dw = {-1,1,0,0};

        List<Node> existNodeList = new ArrayList<>();


        public Painting(int height, int width){
            this.graph = new int[height][width];
            this.height = height;
            this.width = width;
        }

        public void initGraph(BufferedReader br) throws IOException {

            for(int h = 0; h < height; h++){
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");

                for(int w = 0; w < width; w++){
                    graph[h][w] = Integer.parseInt(st.nextToken());

                    if(graph[h][w] == 1)
                        existNodeList.add(new Node(h, w));
                }
            }

        }

        public int BFS(int startH, int startW){

            Deque<Node> queue = new ArrayDeque<>();

            if(graph[startH][startW] == -1)
                return -1;

            int size = 0;
            queue.add(new Node(startH, startW));
            graph[startH][startW] = -1;


            while(!queue.isEmpty()){

                Node presentNode = queue.pollLast();

                IntStream.range(0, 4).forEach(i ->{

                    int nextH = presentNode.height + dh[i];
                    int nextW = presentNode.width + dw[i];

                    if(isExistence(nextH, nextW)){
                        queue.push(new Node(nextH, nextW));
                        graph[nextH][nextW] = -1;
                    }


                });

                size++;


            }
            return size;


        }

        public boolean isExistence(int h, int w){

            if(h >=0 && w >= 0 && h < height && w < width && graph[h][w] == 1)
                return true;

            return false;
        }



        class Node{
            int height;
            int width;
            Node(int height, int width){
                this.height = height;
                this.width= width;
            }
        }

    }

}
