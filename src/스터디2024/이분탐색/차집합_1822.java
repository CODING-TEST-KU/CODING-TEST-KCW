package 스터디2024.이분탐색;

import java.io.*;
import java.util.*;

public class 차집합_1822 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        br.readLine();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Set<Long> setA = new TreeSet<>();
        while(st.hasMoreTokens()){
            setA.add(Long.valueOf(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine(), " ");
        Set<Long> setB = new HashSet<>();
        while(st.hasMoreTokens()){
            setB.add(Long.valueOf(st.nextToken()));
        }

        Iterator<Long> it = setA.iterator();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(it.hasNext()){
            Long next = it.next();
            if(!setB.contains(next)){
                i++;
                sb.append(next);
                sb.append(" ");
            }
        }

        bw.write(String.valueOf(i));
        if(i!= 0) {
            bw.newLine();
            bw.write(sb.toString());
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
