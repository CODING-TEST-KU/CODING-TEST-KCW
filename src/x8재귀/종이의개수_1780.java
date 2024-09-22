package x8재귀;

import java.io.*;
import java.util.StringTokenizer;

public class 종이의개수_1780 {

    public static Result result = new Result();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] paper = new int[N][N];

        //paper 초기화
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for(int j = 0; j < N; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        testPaper(paper, 0, 0, N);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void testPaper(int[][] paper, int startColumn, int startRow, int n){

        if(n == 1){
            addResult(paper[startColumn][startRow]);
            return;
        }

        int testNum = paper[startColumn][startRow];

        boolean isValid = true;
        for(int c = startColumn; c < startColumn + n; c++){
            for(int r = startRow; r < startRow + n; r++){

                if(paper[c][r] != testNum){
                    isValid = false;
                    break;
                }
            }
        }

        if(isValid) {
            addResult(testNum);
            return;
        }

        int nextN = n/3;
        for(int c = startColumn; c < startColumn + n; c+=nextN){
            for(int r = startRow; r < startRow + n; r+=nextN){
                testPaper(paper, c, r, nextN);
            }
        }

    }

    private static void addResult(int testNum) {
        switch (testNum){
            case 1:
                result.one++;
                break;
            case 0:
                result.zero++;
                break;
            case -1:
                result.minusOne++;
        }
    }

    public static class Result{
        int one = 0;
        int zero = 0;
        int minusOne = 0;

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(minusOne);
            sb.append("\n");
            sb.append(zero);
            sb.append("\n");
            sb.append(one);

            return sb.toString();
        }
    }
}
