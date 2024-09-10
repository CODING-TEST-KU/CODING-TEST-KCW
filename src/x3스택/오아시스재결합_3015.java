package x3스택;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class 오아시스재결합_3015 {
    public static void main(String[] args) throws IOException {
        //Reader, Writer 선언 및 초기 값 읽기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int temp = 0;
        int result = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < N; i++){

            int presentElement = Integer.parseInt(br.readLine());
            if(stack.isEmpty()){
                stack.push(presentElement);
                continue;
            }
            int previousElement = stack.peek();

            if(presentElement < previousElement){

                result += stack.size() - 1 - temp;
                temp++;
                stack.push(presentElement);
                continue;

            }
            else if(presentElement > previousElement){

                result++;

                while(true){

                    if(stack.isEmpty()){
                        stack.push(presentElement);
                        break;
                    }


                    int peek = stack.peek();

                    if(peek >= presentElement){
                        stack.push(presentElement);
                        break;
                    }
                    else if(peek < presentElement){
                        peek = stack.pop();

                        if(stack.isEmpty()){
                            stack.push(presentElement);
                            break;
                        }

                        if(peek < stack.peek()){
                            temp--;
                            break;

                        }
                        else if(peek == stack.peek()){
                            break;
                        }

                    }

                }

            }
            else if(presentElement == previousElement){
                result += stack.size() - 1 - temp;
                stack.push(presentElement);
                continue;
            }




        }


        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();

    }
}
