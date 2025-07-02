package 스터디2024.x9백트래킹;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N과M_1 {

    public static List<String> result = new ArrayList<>();
    public static int M;
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<String> numbers = new ArrayList<>();
        for(int i = 1; i <= N; i++){
            numbers.add(String.valueOf(i));
        }

        select(numbers, "", 1);


        result.stream().forEach(s -> {
            try {
                bw.write(s);
                bw.newLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        bw.flush();
        bw.close();
        br.close();

    }

    public static void select(List<String> numbers, String str, int index){

        if(index == M + 1){
            result.add(str);
            return;
        }



        for(String n:numbers){
            List<String> nextNumbers = new ArrayList<>(numbers);
            nextNumbers.remove(n);
            if(index == 1)
                select(nextNumbers, str+n, index+1);
            else
                select(nextNumbers, str+" "+n, index+1);
        }

    }
}
