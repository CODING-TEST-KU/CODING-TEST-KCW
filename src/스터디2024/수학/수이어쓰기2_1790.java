package 스터디2024.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class 수이어쓰기2_1790 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        Long N = Long.valueOf(st.nextToken());
        Long K = Long.valueOf(st.nextToken());

        long[] criticalValues = new long[10];
        criticalValues[0] = 0;

        for(int i = 1; i < 10; i++){
            criticalValues[i] = 9 * ((long) Math.pow(10, i-1)) * i + criticalValues[i - 1];
        }

        int l = String.valueOf(N).length();
        Long maxK = (N - ((long)Math.pow(10, l - 1) - 1))*l + criticalValues[l - 1];

        if(maxK < K){
            System.out.println("-1");
            return;
        }

        for(int i = 0; i < 10; i++){
            if(K - criticalValues[i] <= 0){
                long remain = K - criticalValues[i - 1];
                long start = (long) Math.pow(10, i-1);
                long num = (remain-1) / i;
                int 자리수 = (int) ((remain - 1) %i);

                String resultNum = String.valueOf(start + num);

                System.out.println(resultNum.charAt(자리수));
                return;

            }

        }

        System.out.println("-1");

    }
}
