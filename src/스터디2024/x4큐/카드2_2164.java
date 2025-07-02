package 스터디2024.x4큐;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class 카드2_2164 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Deque<String> queue = new ArrayDeque<>();

        for(int i = 0; i < N; i++){
            queue.push(String.valueOf(i + 1));
        }

        for(int i = 0; i < N; i++){

            if(queue.size() == 1)
                break;

            //카드를 버린다
            queue.pollLast();
            //맨 앞 카드를 뒤로 넣는다
            queue.push(queue.pollLast());
        }

        bw.write(queue.pollLast());
        bw.flush();
        bw.close();
        br.close();
    }


}
