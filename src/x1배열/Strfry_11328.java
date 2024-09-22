package x1배열;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Strfry_11328 {
    public static void main(String[] args) throws IOException {

        //Reader, Writer 선언 및 초기 값 읽기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numOfTestCase = Integer.parseInt(br.readLine());
        //---


        for(int i = 0; i < numOfTestCase; i++){

            StringTokenizer st = new StringTokenizer(br.readLine());

            //strfry로 만들 수 있는 str인지 판단
            String result = isStrfry(st.nextToken(), st.nextToken());

            bw.write(result);
            bw.newLine();
        }

        //flush, close
        bw.flush();
        br.close();
        bw.close();

    }

    public static String isStrfry(String original, String converted){

        //알파벳 갯수를 저장하는 배열 선언 및 초기화
        int[] alphabetArr = new int[26];
        Arrays.fill(alphabetArr, 0);

        //두 문자열의 길이가 다르면 불가능
        if(original.length() != converted.length())
            return "Impossible";

        //original 문자열에 있는 알파벳은 +1, convert 문자열에 있는 알파벳은 -1;
        for(int i = 0; i < original.length(); i++){
            alphabetArr[original.charAt(i) - 'a']++;
            alphabetArr[converted.charAt(i) - 'a']--;
        }

        //두개의 문자열이 같은 알파벳 갯수를 가진다면 배열의 모든 값은 0이여야 함.
        for(int i = 0; i < alphabetArr.length; i++){
            //0이 아닌 숫자가 있을 경우 불가능.
            if(alphabetArr[i] != 0)
                return "Impossible";
        }

        return "Possible";

    }
}
