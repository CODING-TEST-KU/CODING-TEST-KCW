package 스터디2024.x2연결리스트;

import java.io.*;
import java.util.LinkedList;

public class 키로커_5397 {

    public static void main(String[] args) throws IOException {
        //Reader, Writer 선언 및 초기 값 읽기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numOfTestCase = Integer.parseInt(br.readLine());
        //---

        //테스트케이스 수만큼 알고리즘 반복
        for(int i = 0; i < numOfTestCase; i++){

            String testCase = br.readLine();

            bw.write(findPassword(testCase));
            bw.newLine();

        }



        bw.flush();
        bw.close();
        br.close();

    }

    public static String findPassword(String keyInput){

        //커서 위치 변수
        int offset = 0;

        //결과 저장 리스트
        LinkedList<Character> resultList = new LinkedList<>();


        //keyInput 에 따라 offset 조정 및 resultList에 값 저장
        for(int i = 0; i < keyInput.length(); i++){

            char presentKey = keyInput.charAt(i);

            if(presentKey == '<'){
                if(offset != 0)
                    offset--;
            }
            else if (presentKey == '>') {
                if(offset != resultList.size()){
                    offset++;
                }
            }
            else if (presentKey == '-'){
                if(offset != 0){
                    resultList.remove(offset - 1);
                    offset--;
                }
            }
            else{
                resultList.add(offset, presentKey);
                offset++;
            }

        }

        //linked list를 String 으로 변환
        //String + char 는 쓰지 말자.. 시간 초과 남 StringBuilder 사용
        StringBuilder sb= new StringBuilder();

        for(char e : resultList){
            sb.append(e);
        }

        return sb.toString();
    }
}
