package 스터디2024.x3스택;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class 오아시스재결합_3015 {

    public static void main(String[] args) throws IOException {

        //reader writer 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Deque<Element> stack = new ArrayDeque<>();
        Long result = 0L;

        //첫번째 element 삽입
        stack.push(new Element(br.readLine()));

        for(int i = 1; i < N; i++){

            Element next = new Element(br.readLine());

            while(true) {

                if (stack.isEmpty()) {
                    stack.push(next);
                    break;
                }

                Element peek = stack.peek();

                if (Integer.parseInt(peek.height) > Integer.parseInt(next.height)) {
                    result += 1;
                    stack.push(next);
                    break;
                } else if (Integer.parseInt(peek.height) <= Integer.parseInt(next.height)) {

                    if(peek.height.equals(next.height)){
                        next.cumulative += peek.cumulative;
                    }

                    result += peek.cumulative;
                    stack.pop();
                }
            }

        }
        bw.write(String.valueOf(result));
        bw.close();
        br.close();
    }


    public static class Element {
        String height;
        Long cumulative;

        public Element(String height) {
            this.height = height;
            this.cumulative = 1L;
        }
        public Element(String height, Long cumulative) {
            this.height = height;
            this.cumulative = cumulative;
        }
    }

}