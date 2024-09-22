package x8재귀;

import java.io.*;
import java.util.Arrays;

public class 별찍기10_2447 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Star star = new Star(N);
        star.recursion(0,0, N);
        star.render(bw);
        bw.close();
        br.close();
    }

    public static class Star{
        boolean[][] starArr;
        int N;

        Star(int N){
            this.N = N;
            starArr = new boolean[N][N];

        }

        //재귀호출
        void recursion(int startColumn, int startRow, int presentN){

            makeHole(startColumn, startRow, presentN);
            int nextN = presentN/3;
            if(nextN == 0){
                return;
            }
            
            //어떻게 나누어서 재호출 할지 정하는 부분
            for(int i = startColumn; i < startColumn + presentN; i+=nextN){
                for(int j = startRow; j < startRow + presentN; j+=nextN){
                    recursion(i, j, nextN);
                }
            }
        }
        
        //모든 부분에서 동일하게 할일
        void makeHole(int startColumn, int startRow, int presentN){

            int nextN = presentN/3;
            for(int i = 0; i < nextN; i++){
                for(int j = 0; j < nextN; j++){
                    starArr[startColumn+nextN+i][startRow+nextN+j] = true;
                }
            }

        }



        public void render(BufferedWriter bw) throws IOException {

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!starArr[i][j]) {
                        bw.write("*");
                    }
                    else{
                        bw.write(" ");
                    }
                }
                bw.newLine();
            }
            bw.flush();
        }


    }

}
