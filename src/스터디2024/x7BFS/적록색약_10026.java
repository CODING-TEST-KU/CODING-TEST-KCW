package 스터디2024.x7BFS;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class 적록색약_10026 {

    static final int RED = 0;
    static final int GREEN = 1;
    static final int BLUE = 2;
    static final int VISITED = -1;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Painting painting = new Painting(N);
        painting.initGraph(br);
        int generalResult = 0;
        int blindResult = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                generalResult += painting.BFS(i,j,false);
                blindResult += painting.BFS(i,j,true);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(generalResult);
        sb.append(" ");
        sb.append(blindResult);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static class Painting{

        int[][] generalGraph;
        int[][] blindGraph;
        int[] dh = {0,0,-1,1};
        int[] dw = {-1,1,0,0};

        int height;
        int width;

        Painting(int N){
            this.height = N;
            this.width = N;

            generalGraph = new int[N][N];
            blindGraph = new int[N][N];
        }

        void initGraph(BufferedReader br) throws IOException {

            for(int i = 0; i < height; i++){
                String line = br.readLine();

                for(int j = 0; j < width; j++){
                    char c = line.charAt(j);

                    switch (c){
                        case 'R':
                            generalGraph[i][j] = RED;
                            blindGraph[i][j] = RED;
                            break;
                        case 'G':
                            generalGraph[i][j] = GREEN;
                            blindGraph[i][j] = RED;
                            break;
                        case 'B':
                            generalGraph[i][j] = BLUE;
                            blindGraph[i][j] = BLUE;
                            break;

                    }

                }
            }

        }

        int BFS(int startH, int startW, boolean isBlind){

            //이미 방문한 노드가 시작점일 경우 바로 종료
            if(!isBlind && (generalGraph[startH][startW] == VISITED))
                return 0;
            else if(isBlind && (blindGraph[startH][startW] == VISITED))
                return 0;
            
            int initialColor;

            //초기 컬러 설정
            if(!isBlind)
                initialColor = generalGraph[startH][startW];
            else
                initialColor = blindGraph[startH][startW];

            Deque<Coordinate> queue = new ArrayDeque<>();
            queue.push(new Coordinate(startH, startW));

            if(!isBlind)
                generalGraph[startH][startW] = VISITED;
            else
                blindGraph[startH][startW] = VISITED;

            while(!queue.isEmpty()){

                Coordinate present = queue.pollLast();

                for(int i = 0; i < 4; i++){
                    int nextH = present.height + dh[i];
                    int nextW = present.width + dw[i];

                    if(isValid(nextH, nextW, initialColor, isBlind)){
                        queue.add(new Coordinate(nextH, nextW));
                        if(!isBlind)
                            generalGraph[nextH][nextW] = VISITED;
                        else
                            blindGraph[nextH][nextW] = VISITED;

                    }

                }

            }
            return 1;



        }

        private boolean isValid(int nextH, int nextW, int color, boolean isBlind) {
            if(nextH >= 0 && nextW >= 0 && nextH < height && nextW < width) {
                if (!isBlind) {
                    if (generalGraph[nextH][nextW] == color)
                        return true;
                }
                else if (blindGraph[nextH][nextW] == color) {
                    return true;
                }
            }


            return false;

        }

        class Coordinate{
            int height;
            int width;
            Coordinate(int h, int w){
                height = h;
                width = w;

            }
        }


    }
}
