package x3스택;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class 제로_10773 {
    public static void main(String[] args) throws IOException {
        //Reader, Writer 선언 및 초기 값 읽기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < N; i++){

            int presentElement = Integer.parseInt(br.readLine());

            if(presentElement == 0){
                stack.pop();
            }
            else{
                stack.push(presentElement);
            }
        }

        int result = stack.stream().reduce(0,Integer::sum);


        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
