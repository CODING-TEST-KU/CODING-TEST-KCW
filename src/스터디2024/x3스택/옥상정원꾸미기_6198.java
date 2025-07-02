package 스터디2024.x3스택;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class 옥상정원꾸미기_6198 {

    public static void main(String[] args) throws IOException {
        //Reader, Writer 선언 및 초기 값 읽기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> stack = new ArrayDeque<>();
        //모든 빌딩을 볼 수 있을 때 최대 약 3,200,000,000까지 가능하므로 int로 불가능.
        Long result = 0L;

        for(int i = 0; i < N; i++){

            int presentElement = Integer.parseInt(br.readLine());

            while(true){
                if(stack.isEmpty()){
                    stack.push(presentElement);
                    break;
                }

                int peekElement = stack.peek();

                if(peekElement > presentElement){
                    stack.push(presentElement);
                    result += stack.size() - 1L;
                    break;
                }
                else{
                    stack.pop();
                }
            }

        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
