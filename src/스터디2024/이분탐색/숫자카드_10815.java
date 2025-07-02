package 스터디2024.이분탐색;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 숫자카드_10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            if(set.contains(target)) {
                bw.write("1 ");
            }
            else{
                bw.write("0 ");
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
