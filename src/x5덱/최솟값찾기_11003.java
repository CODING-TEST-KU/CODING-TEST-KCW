package x5덱;

import java.io.*;
import java.util.*;

public class 최솟값찾기_11003 {
    public static void main(String[] args) throws IOException {

        //버퍼 입출력 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int numOfNumbers = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine()," ");

        List<String> result = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        Deque<Integer> minQueue = new ArrayDeque<>();

        //D1 구하기
        result.add(st.nextToken());
        int min = Integer.parseInt(result.get(0));
        deque.addLast(min);
        minQueue.push(min);

        //결과 write
        bw.write(String.valueOf(min));
        bw.write(" ");

        for(int i = 1; i < L; i++){
            int next = Integer.parseInt(st.nextToken());
            deque.addLast(next);
            updateMinQueue(minQueue, next);
            if(min > next)
                min = next;
            bw.write(String.valueOf(min));
            bw.write(" ");
        }

        for(int i = L; i < numOfNumbers; i++){
            int next = Integer.parseInt(st.nextToken());
            int popValue = deque.pollFirst();
            deque.addLast(next);

            if(popValue == minQueue.getLast()){
                minQueue.pollLast();
            }
            updateMinQueue(minQueue, next);

            if(popValue == min){
                //deque내에서 최소값을 찾는다
                int newMinValue = minQueue.getLast();
                //해당 밸류를 리저트에 넣고 min 밸류를 교체한다.
                min = newMinValue;
                bw.write(String.valueOf(min));
                bw.write(" ");
            }
            else{
                if(min > next)
                    min = next;
                bw.write(String.valueOf(min));
                bw.write(" ");

            }

        }

        bw.flush();
        bw.close();
        br.close();

    }

    public static void updateMinQueue(Deque<Integer> minQueue, int next){
        while(true){
            if(minQueue.isEmpty()){
                minQueue.push(next);
                return;
            }

            if(minQueue.peek() > next){
                minQueue.pop();
            }
            else if(minQueue.peek() <= next){
                minQueue.push(next);
                return;
            }
        }
    }
}
