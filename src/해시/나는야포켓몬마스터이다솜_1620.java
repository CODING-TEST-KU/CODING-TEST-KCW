package 해시;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 나는야포켓몬마스터이다솜_1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String,String> stringToIntegerMap = new HashMap<>();
        Map<String,String> integerToStringMap = new HashMap<>();

        for(int i = 1; i < N+1; i++){
            String next = br.readLine();
            stringToIntegerMap.put(next, String.valueOf(i));
            integerToStringMap.put(String.valueOf(i), next);
        }

        for(int i = 0; i < M; i++){
            String next = br.readLine();
            if(stringToIntegerMap.containsKey(next)){
                bw.write(stringToIntegerMap.get(next));
                bw.newLine();
            }
            else{
                bw.write(integerToStringMap.get(next));
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
