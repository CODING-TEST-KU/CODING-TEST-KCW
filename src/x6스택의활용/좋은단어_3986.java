package x6스택의활용;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class 좋은단어_3986 {
    public static void main(String[] args) throws IOException {
        //버퍼 입출력 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numOfWords = Integer.parseInt(br.readLine());
        int result = 0;

        for(int i = 0; i < numOfWords; i++) {

            String word = br.readLine();
            if(isWellWord(word))
                result++;

        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();

    }

    public static boolean isWellWord(String word) {

        Deque<Character> stack = new ArrayDeque<Character>();
        boolean isWellWord = false;

        for(int i = 0; i < word.length(); i++) {
            char next = word.charAt(i);

            if(stack.isEmpty()) {
                stack.push(next);
                continue;
            }

            char top = stack.peek();

            if(top == next) {
                stack.pop();
            }
            else{
                stack.push(next);
            }


        }

        if(stack.isEmpty())
            isWellWord = true;

        return isWellWord;

    }


}

