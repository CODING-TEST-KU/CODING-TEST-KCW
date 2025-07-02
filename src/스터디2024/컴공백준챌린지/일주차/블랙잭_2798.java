package 스터디2024.컴공백준챌린지.일주차;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 블랙잭_2798 {

    static int result = -1;
    static int M;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        List<Integer> numbers = new ArrayList<>();


        st = new StringTokenizer(br.readLine(), " ");

        while(st.hasMoreTokens()) {
            int nextValue = Integer.parseInt(st.nextToken());
            if(nextValue <= M) {
                numbers.add(nextValue);
            }
        }



        for(int i = 0; i < N; i++) {
            Integer iNumber = numbers.get(i);
            for(int j = i + 1; j < N; j++) {
                Integer jNumber = numbers.get(j);
                for(int k = j + 1; k < N; k++) {
                    Integer kNumber = numbers.get(k);
                    int sum = iNumber + jNumber + kNumber;
                    if(isValid(sum)) {
                        if(result < sum){
                            result = sum;
                        }
                    }

                }
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();

    }
    static boolean isValid(int x){
        if(x > M)
            return false;
        return true;
    }


}
