package x3스택;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class 오아시스재결합2_3015 {

    public static void main(String[] args) throws IOException {

        //reader writer 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Deque<String> stack = new ArrayDeque<>();
        int result = 0;

        //첫번째 element 삽입
        stack.push(br.readLine());

        for(int i = 1; i < N; i++){

            int next = Integer.parseInt(br.readLine());

            while(true) {
                if (stack.isEmpty()) {
                    stack.push(String.valueOf(next));
                    break;
                }

                int peek = Integer.parseInt(stack.peek());

                if (peek == next) {
                    result += stack.size();
                    stack.push(String.valueOf(next));
                    break;
                } else if (peek > next) {
                    result += 1;
                    stack.push(String.valueOf(next));
                    break;
                } else if (peek < next) {
                    result += 1;
                    stack.pop();
                }
            }


        }
    }
}
