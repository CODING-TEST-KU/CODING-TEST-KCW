package 스터디2024.이분탐색;

import java.io.*;
import java.util.*;

public class 좌표압축_18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input, " ");
        Set<Long> set = new TreeSet<>();

        //number 에 따라서 sort 하며 삽입
        for(int i = 0; i < N; i++){
            set.add(Long.valueOf(st.nextToken()));
        }


        Iterator<Long> iterator = set.iterator();
        Map<Long, Integer> map = new HashMap<>();
        int i = 0;
        while(iterator.hasNext()){
            Long next = iterator.next();
            map.put(next,i++);
        }

        StringTokenizer st1 = new StringTokenizer(input, " ");
        StringBuilder sb = new StringBuilder();
        for(int j = 0; j < N; j++){
            sb.append(map.get(Long.valueOf(st1.nextToken())));
            sb.append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();




    }

}
