package 스터디2024.x8재귀;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 색종이만들기_2630 {

    int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Paper p = new Paper(N);
        p.initGraph(br);
        p.recursion(0,0,N);

        Arrays.stream(p.result).forEach(a -> {
            try {
                bw.write(String.valueOf(a));
                bw.newLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        bw.flush();
        bw.close();
        br.close();
    }

    public static class Paper{
        int[][] paperGraph;
        int N;
        //0, 1
        int[] result = new int[2];

        Paper(int N){
            this.N = N;
            paperGraph = new int[N][N];
        }

        void initGraph(BufferedReader br) throws IOException{
            for(int i = 0; i < N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0; j < N; j++){

                    paperGraph[i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }

        void recursion(int startColumn, int startRow, int presentN){

            boolean testResult = test(startColumn, startRow, presentN);

            if(testResult){
                result[paperGraph[startColumn][startRow]] += 1;
            }
            else{
                for(int c = startColumn; c < startColumn + presentN; c+=presentN/2){
                    for(int r = startRow; r < startRow + presentN; r+=presentN/2) {
                        recursion(c, r, presentN/2);
                    }
                }
            }


        }

        boolean test(int startColumn, int startRow, int presentN){

            int testNum = paperGraph[startColumn][startRow];
            for(int c = startColumn; c < startColumn + presentN; c++){
                for(int r = startRow; r < startRow + presentN; r++){
                    if(testNum != paperGraph[c][r]){
                        return false;
                    }
                }
            }
            return true;

        }




    }
}
