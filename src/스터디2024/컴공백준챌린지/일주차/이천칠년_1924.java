package 스터디2024.컴공백준챌린지.일주차;

import java.io.*;
import java.util.StringTokenizer;

public class 이천칠년_1924 {

    public static int[] calendar = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());

        int theDay = 0;
        for(int i = 0; i < month; i++){
            theDay += calendar[i];
        }
        theDay += day;

        theDay = theDay%7 - 1;

        switch (theDay){
            case 0:
                bw.write("MON");
                break;
            case 1:
                bw.write("TUE");
                break;
            case 2:
                bw.write("WED");
                break;
            case 3:
                bw.write("THU");
                break;
            case 4:
                bw.write("FRI");
                break;
            case 5:
                bw.write("SAT");
                break;
            case -1:
                bw.write("SUN");
                break;

        }
        bw.flush();
        bw.close();
        br.close();


    }


}
