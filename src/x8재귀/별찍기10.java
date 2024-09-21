package x8재귀;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 별찍기10 {

    public static int N;
    public static int k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        k = (int) (Math.log(N)/Math.log(3));

        char[][] starList = new char[N][N];
        for(int i = 0; i < N; i++) {
            Arrays.fill(starList[i],'*');
        }

        for(int i = 1; i <= k; i++){

            int present = (int) Math.pow(3, i);

            for(int j = present/3; j < N; j += present){

                int l = j;

                while(l < N){
                    for(int r = 0; r < present/3; r++) {
                        for(int t = 0; t < present/3; t++) {
                            starList[j+r][l+t] = '0';
                        }
                    }

                    l += present;
                }


            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j <N; j++){
                System.out.print(starList[i][j]);
            }
            System.out.println();
        }

    }

}
