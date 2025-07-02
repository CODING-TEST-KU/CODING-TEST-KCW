package 스터디2024.x7BFS;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 토마토_7576 {

    public static final int FAIL = -1;
    public static final int CONTINUE = -2;

    public static void main(String[] args) throws IOException {
        //리더, 라이터 선언 및 주어진 변수 파싱
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        //---
        
        Farm farm = new Farm(height, width);
        //그래프 초기화
        farm.initGraph(br);
        
        //전이시킨 횟수 계산
        int result = 0;
        while((result = farm.transition()) == CONTINUE);

        
        //결과 출력
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
        //초기 그래프에서 0의 갯수
        int sumOfZero = 0;
        //1로 바뀐 0의 갯수
        int sumOfOne = 0;
        //전이된 횟수
        int day = 0;
        Farm(int height, int width){
            this.height = height;
            this.width = width;
            graph = new int[height][width];
        }

        //문제에서 주어진대로 그래프 초기화
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

            //모든 0을 1로 바꿨을 경우
            if(sumOfZero == sumOfOne)
                return day;
            //노드리스트가 비어서 더 진행할 수 없지만 모든 0을 1로 바꾸지 못했을 경우
            else if(nodeList.isEmpty()){
                return FAIL;
            }

            //어제 전이된 토마토의 위치들
            List<Node> presentNodeList = List.copyOf(nodeList);
            nodeList.clear();

            //전이시키기
            for(int i = 0; i < presentNodeList.size(); i++){
                //어제 전이된 토마토의 위치를 하나씩 가져온다.
                Node present = presentNodeList.get(i);
                
                for(int j = 0; j < 4; j++){

                    int nextH = present.h + dh[j];
                    int nextW = present.w + dw[j];
                    
                    //전이가 가능하다면 전이시키기
                    if(isValid(nextH, nextW)){
                        //전이된 토마토의 위치 기록
                        nodeList.add(new Node(nextH, nextW));
                        graph[nextH][nextW] = 1;
                        //1로 바꾼 0의 갯수 증가 시키기
                        sumOfOne++;
                    }

                }

            }
            
            //날짜 증가
            day++;

            //계속해서 전이
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
