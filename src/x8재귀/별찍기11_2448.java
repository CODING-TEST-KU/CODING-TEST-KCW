package x8재귀;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class 별찍기11_2448 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Star star = new Star(N);
        star.initGraph();
        star.recursion(0,0,N);

        star.render(bw);
        bw.flush();
        bw.close();
        br.close();

    }

    public static class Star{

        boolean[][] starGraph;
        int N;
        int bottomSize;

        Star(int n){
            this.N = n;
            starGraph = new boolean[N][];
        }

        void initGraph(){

            for(int i = 1; i <= N; i++){
                starGraph[i - 1] = new boolean[(i*2) - 1];
            }

            bottomSize = starGraph[N-1].length;

        }

        void recursion(int startH, int startW, int presentN){

            if(presentN == 3){
                insertStar(startH, startW);
                return;
            }

            recursion(startH, startW, presentN/2);
            recursion(startH+presentN/2, startW, presentN/2);
            recursion(startH + presentN/2, startW + starGraph[presentN/2].length - 1, presentN/2);



        }

        private void insertStar(int startH, int startW) {

            starGraph[startH][startW] = true;
            starGraph[startH + 1][startW] = true;
            starGraph[startH + 1][startW + 2] = true;

            for(int i = 0; i < 5; i++){
                starGraph[startH + 2][startW+i] = true;
            }
        }


        void render(BufferedWriter bw) throws IOException {

            for(int i = 0; i < N; i++){
                int length = starGraph[i].length;
                int numOfNull = (bottomSize - length)/2;

                for(int j = 0; j < numOfNull; j++){
                    bw.write(" ");
                }
                for(int j = 0; j < length; j++){
                    if(!starGraph[i][j])
                        bw.write(" ");
                    else
                        bw.write("*");
                }

                for(int j = 0; j < numOfNull; j++){
                    bw.write(" ");
                }

                bw.newLine();
            }
        }



    }
}

