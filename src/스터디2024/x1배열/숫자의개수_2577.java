package 스터디2024.x1배열;

import java.io.*;
import java.util.Arrays;

public class 숫자의개수_2577 {
    public static void main(String[] args) throws IOException {

        //Reader, Writer 선언 및 초기 값 읽기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Long A,B,C;

        A = Long.valueOf(Integer.parseInt(br.readLine()));
        B = Long.valueOf(Integer.parseInt(br.readLine()));
        C = Long.valueOf(Integer.parseInt(br.readLine()));
        //---

        //세 수의 곱 계산 및 String 으로 변환
        Long multi = A*B*C;
        String stringMulti = String.valueOf(multi);
        //---

        //결과를 담을 배열 선언, 0으로 초기화
        int[] resultList = new int[10];
        Arrays.fill(resultList, 0);
        //---

        //stringMulti 의 자리수를 모두 탐색하며 resultList의 해당 인덱스 값을 1 증가시킴
        for(int i = 0; i < stringMulti.length(); i++){

            resultList[Integer.parseInt(Character.toString(stringMulti.charAt(i)))]++;

        }
        //---


        //결과 출력
        for(int i = 0; i< resultList.length; i++){
            bw.write(String.valueOf(resultList[i]));
            bw.newLine();
        }
        //---
        bw.flush();
        br.close();
        bw.close();



    }
}
