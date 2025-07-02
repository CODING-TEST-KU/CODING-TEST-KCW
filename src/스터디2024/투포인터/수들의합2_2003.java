package 스터디2024.투포인터;

import java.io.*;
import java.util.StringTokenizer;

public class 수들의합2_2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        Long M = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        long[] sequence = new long[N];
        for(int i = 0; i < N; i++){
            sequence[i] = Integer.parseInt(st.nextToken());
        }


        int start = 0;
        int end = 0;
        Long intervalSum = 0L;
        Long answer = 0L;


        while(true){
            if(intervalSum.equals(M)){
                intervalSum -= sequence[start++];
                answer += 1;
            }
            else if(intervalSum > M){
                intervalSum -= sequence[start++];
            }
            else{
                if(end == N){
                    break;
                }
                intervalSum += sequence[end++];
            }

        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();

    }

}
