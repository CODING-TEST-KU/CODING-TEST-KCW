package 스터디2024.해시;

import java.io.*;
import java.util.*;

public class 회사에있는사람_7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Map<String,String> map = new TreeMap<>(Comparator.reverseOrder());
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            map.put(st.nextToken(), st.nextToken());
        }

        Iterator<String> it = map.keySet().iterator();
        while(it.hasNext()){
            String next = it.next();
            if(!map.get(next).equals("leave")){
                bw.write(next);
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
