package 스터디2024.컴공백준챌린지.일주차;

import java.io.*;
import java.util.*;

public class 네번째점_3009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] x = new String[3];
        String[] y = new String[3];
        String rx;
        String ry;

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            x[i] = st.nextToken();
            y[i] = st.nextToken();
        }

        if(x[0].equals(x[1]))
            rx= x[2];
        else if(x[1].equals(x[2]))
            rx= x[0];
        else
            rx= x[1];


        if(y[0].equals(y[1]))
            ry= y[2];
        else if(y[1].equals(y[2]))
            ry = y[0];
        else
            ry= y[1];

        System.out.println(rx+" " + ry);

    }
}
