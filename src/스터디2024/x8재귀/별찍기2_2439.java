package 스터디2024.x8재귀;

import java.io.*;

public class 별찍기2_2439 {

    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        printStar(1, bw);
        bw.flush();
        bw.close();
        br.close();
    }

    public static void printStar(int index, BufferedWriter bw) throws IOException {

        if(index == N+1){
            return;
        }

        for(int i = 0; i < N - index; i++){
            bw.write(" ");
        }
        for(int i = 0; i < index; i++){
            bw.write("*");
        }

        bw.newLine();

        printStar(index + 1, bw);
    }
}
