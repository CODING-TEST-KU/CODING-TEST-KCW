package 스터디2024.x1배열;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두수의합_3273 {

    public static void main(String[] args) throws IOException {
        //Reader, Writer 선언 및 초기 값 읽기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int sequenceSize = Integer.parseInt(br.readLine());
        String sequence = br.readLine();

        StringTokenizer st1 = new StringTokenizer(sequence, " ");
        StringTokenizer st2 = new StringTokenizer(sequence, " ");

        int x = Integer.parseInt(br.readLine());
        //---

        //만족하는 쌍의 개수를 저장하는 변수
        int result = 0;

        //수열에 존재하는 숫자를 인덱스로 가지는 배열. 존재한다면 true
        boolean[] ai = new boolean[2000001];
        Arrays.fill(ai, false);
        while(st1.hasMoreTokens()){

            int i = Integer.parseInt(st1.nextToken());
            ai[i] = true;
        }
        //---

        //합이 x가 되는 인덱스가 true 라면 ai+aj = x가 존재하는 것으로 간주.
        while(st2.hasMoreTokens()){

            int i = Integer.parseInt(st2.nextToken());

            //자기 자신과 더해서 x가 되는 값 또는 x-i가 음수가 되는 (1 <= i < j <= n 을 만족하지 않는 수) 는 제외.
            if(i == x - i || x - i < 0){
                ai[i] = false;
                continue;
            }

            boolean aj = ai[x-i];

            //합이 x가 되는 인덱스가 존재한다면
            if(aj)
                result++;


            //이후 순서쌍에서 중복하여 갯수를 세지 않도록 false 로 변경
            ai[i] = false;

        }


        bw.write(String.valueOf(result));
        bw.flush();

        bw.close();
        br.close();


    }
}
