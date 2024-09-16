package x7BFS;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class 토마토_7576 {

    public static final int FAIL = -1;
    public static final int CONTINUE = -2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        Farm farm = new Farm(height, width);
        farm.initGraph(br);
        int result = 0;
        while((result = farm.transition()) == CONTINUE);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();

    }

    public static class Farm{
        int[][] graph;
        int height;
        int width;
        int[] dh = {0,0,-1,1};
        int[] dw = {-1,1,0,0};

        List<Node> nodeList = new ArrayList<>();
        int sumOfZero = 0;
        int day = 0;
        int sumOfOne = 0;

        Farm(int height, int width){
            this.height = height;
            this.width = width;
            graph = new int[height][width];
        }

        void initGraph(BufferedReader br) throws IOException {

            for(int h =0; h < height; h++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");

                for(int w = 0; w < width; w++){
                    int next = Integer.parseInt(st.nextToken());

                    if(next == 0)
                        sumOfZero++;
                    else if(next == 1)
                        nodeList.add(new Node(h, w));

                    graph[h][w] = next;


                }
            }


        }

        int transition(){

            if(sumOfZero == sumOfOne)
                return day;
            //노드리스트가 비었을 경우
            else if(nodeList.isEmpty()){
                return FAIL;
            }

            //어제 전이된 토마토 Node의 위치들
            List<Node> presentNodeList = List.copyOf(nodeList);
            nodeList.clear();

            //전이시키기
            for(int i = 0; i < presentNodeList.size(); i++){

                Node present = presentNodeList.get(i);

                for(int j = 0; j < 4; j++){

                    int nextH = present.h + dh[j];
                    int nextW = present.w + dw[j];

                    if(isValid(nextH, nextW)){
                        nodeList.add(new Node(nextH, nextW));
                        graph[nextH][nextW] = 1;
                        sumOfOne++;
                    }

                }

            }

            day++;
            return CONTINUE;

        }

        boolean isValid(int h, int w){

            if(h >=0 && w >=0 && h < height && w < width && graph[h][w] != 1 && graph[h][w] != -1)
                return true;

            return false;

        }

        class Node{
            int h;
            int w;

            Node(int height, int width){
                this.h = height;
                this.w = width;
            }
        }

    }
}
