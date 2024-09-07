package x1배열;

import java.io.*;
import java.util.Arrays;

public class 숫자의개수_2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Long A,B,C;

        A = Long.valueOf(Integer.parseInt(br.readLine()));
        B = Long.valueOf(Integer.parseInt(br.readLine()));
        C = Long.valueOf(Integer.parseInt(br.readLine()));

        Long multi = A*B*C;
        String stringMulti = String.valueOf(multi);

        int[] resultList = new int[10];
        Arrays.fill(resultList, 0);

        for(int i = 0; i < stringMulti.length(); i++){

            resultList[Integer.parseInt(Character.toString(stringMulti.charAt(i)))]++;

        }

        for(int i = 0; i< resultList.length; i++){
            bw.write(String.valueOf(resultList[i]));
            bw.newLine();
        }
        bw.flush();
        br.close();
        bw.close();



    }
}
