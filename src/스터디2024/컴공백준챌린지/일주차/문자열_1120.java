package 스터디2024.컴공백준챌린지.일주차;

import java.io.*;
import java.util.StringTokenizer;

public class 문자열_1120 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String A = st.nextToken();
        String B = st.nextToken();

        int additionalNum = B.length() - A.length();
        int result = 0;
        int maxSum = 0;
        int temp = 0;

        for(int i = 0; i <= additionalNum; i++) {
            for(int j = 0; j < A.length(); j++) {
                   if(A.charAt(j) == B.charAt(j+i)){
                       temp++;
                   }
            }
            if(temp > maxSum) {
                maxSum = temp;
            }
            temp = 0;
        }

        result = maxSum + additionalNum;
        bw.write(String.valueOf(B.length() - result));
        bw.flush();
        bw.close();
        br.close();

    }
}
