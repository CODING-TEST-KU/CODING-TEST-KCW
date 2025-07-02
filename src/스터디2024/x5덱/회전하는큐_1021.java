package 스터디2024.x5덱;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 회전하는큐_1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int sizeOfQueue = Integer.parseInt(st.nextToken());
        int numOfTarget = Integer.parseInt(st.nextToken());
        Deque<String> deque = new ArrayDeque<>();


        for(int i = 0; i < sizeOfQueue; i++){
            deque.push(String.valueOf(i + 1));
        }

        st = new StringTokenizer(br.readLine(), " ");
        Long result = 0L;

        for(int i = 0; i < numOfTarget; i++){
            String target = st.nextToken();
            while(true){
                if(deque.getLast().equals(target)){
                    deque.pollLast();
                    break;
                }
            }
        }




    }

}
