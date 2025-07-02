package 스터디2024.그리디;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 동전0_11047 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        long numOfCoinType = Long.parseLong(st.nextToken());
        long needSum = Long.parseLong(st.nextToken());

        List<Long> coinList = new ArrayList<>();

        for(int i = 0; i < numOfCoinType; i++) {
            coinList.add(Long.parseLong(br.readLine()));

        }

        long k = 0;
        //거슬러야할 돈이 0이 될 때까지 반복한다.
        Label: while(needSum > 0){
            //코인 타입들을 하나씩 보면서 가장 큰 값으로 거슬러준다.
            for(int i = 0; i < numOfCoinType; i++){

                if(needSum < coinList.get(i)){
                    needSum -= coinList.get(i - 1);
                    k++;
                    continue Label;
                }

                //마지막 요소일 경우
                if(i == numOfCoinType - 1){
                    needSum -= coinList.get(i);
                    k++;
                    continue Label;
                }
            }
        }

        bw.write(String.valueOf(k));
        bw.flush();
        bw.close();
        br.close();

    }
}
