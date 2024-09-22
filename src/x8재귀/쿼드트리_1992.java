package x8재귀;

import java.io.*;

public class 쿼드트리_1992 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Video video = new Video(N);
        video.initVideo(br);
        video.compression(0,0,N);
        bw.write(video.result.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    public static class Video{
        int[][] video;
        int N;
        StringBuilder result = new StringBuilder();

        Video(int N){
            this.N = N;
            video = new int[N][N];
        }

        void initVideo(BufferedReader br) throws IOException {
            for(int i = 0; i < N; i++){
                String line = br.readLine();
                for(int j = 0; j < N; j++){
                    video[i][j] = Integer.parseInt(line.charAt(j)+"");
                }
            }
        }

        void compression(int startColumn, int startRow, int presentN){

            boolean testResult = test(startColumn, startRow, presentN);
            if(testResult){
                result.append(video[startColumn][startRow]);
            }
            else{
                result.append("(");
                int nextN = presentN/2;
                for(int c = startColumn; c < startColumn + presentN; c+=nextN){
                    for(int r = startRow; r < startRow + presentN; r+=nextN){
                        compression(c, r, nextN);
                    }
                }
                result.append(")");
            }

        }

        boolean test(int startColumn, int startRow, int presentN){

            int testNum = video[startColumn][startRow];

            for(int c = startColumn; c < startColumn + presentN; c++){
                for(int r = startRow; r < startRow + presentN; r++){
                    if(video[c][r] != testNum){
                        return false;
                    }
                }
            }

            return true;
        }


    }
}
