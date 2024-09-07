package x1배열;

import java.io.*;

public class 애너그램만들기_1919 {

    public static final int numOfAlphabet = 26;

    public static void main(String[] args) throws IOException {

        //입출력 선언 및 초기값 읽기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

        String s1 = br.readLine();
        String s2 = br.readLine();
        //---

        int[] firstStringAlphabetArray = makeNumOfAlphabetArray(s1);
        int[] secondStringAlphabetArray = makeNumOfAlphabetArray(s2);

        int result = calNumOfAlphabetToDelete(firstStringAlphabetArray, secondStringAlphabetArray);

        //결과 출력
        bw.write(String.valueOf(result));
        bw.flush();

        bw.close();
        br.close();

    }

    //String 의 알파벳 개수를 계산하여 배열 형태로 반환.
    //0번 인덱스 -> a 개수. 1번 인덱스 -> b의 개수
    public static int[] makeNumOfAlphabetArray(String str){

        int[] arr = new int[numOfAlphabet];

        for(int i = 0; i < str.length(); i++){
            arr[str.charAt(i)-'a']++;
        }

        return arr;
    }

    //알파벳들의 개수가 같다면 애너그램 관계.
    //두 배열(알파벳 개수가 들어있는 배열) 의 알파벳 개수를 동일하게 하기 위해 지워야 할 알파벳의 개수를 계산
    public static int calNumOfAlphabetToDelete(int[] arr1, int[] arr2){

        int numOfAlphabetToDelete = 0;

        for(int i = 0; i < numOfAlphabet; i++){
            if(arr1[i] >= arr2[i]){
                numOfAlphabetToDelete += arr1[i] - arr2[i];
            }
            else{
                numOfAlphabetToDelete += arr2[i] - arr1[i];
            }
        }

        return numOfAlphabetToDelete;

    }
}
