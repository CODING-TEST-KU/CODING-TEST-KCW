package 스터디2024.x5덱;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class AC_5430 {
    public static void main(String[] args) throws IOException {

        //버퍼 입출력 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //테스트 케이스 갯수
        int numOfTestCase = Integer.parseInt(br.readLine());

        for(int i = 0; i < numOfTestCase; i++){

            //문제에서 주는 값들 파싱
            String instructionSet = br.readLine();
            int sizeOfArr = Integer.parseInt(br.readLine());

            //arr 사이즈가 0일 경우 빈 덱으로 실행
            if(sizeOfArr == 0){
                br.readLine();
                bw.write(runInstruction(instructionSet,new ArrayDeque<>()));
                bw.newLine();
                continue;
            }

            //가공되지 않은 Arr 가져오기
            String rawArr = br.readLine();
            //Arr 안의 integer 들만 뽑아냄 -> 2자리 이상 integer 가 있을 수 있음.
            String arrElements = rawArr.substring(1, rawArr.length() - 1);
            StringTokenizer st = new StringTokenizer(arrElements, ",");

            //덱에 데이터 삽입
            Deque<String> deque = new ArrayDeque<>();
            while(st.hasMoreTokens()){
                deque.addLast(st.nextToken());
            }

            //결과 출력
            String result = runInstruction(instructionSet, deque);
            bw.write(result);
            bw.newLine();

        }

        bw.flush();
        bw.close();
        br.close();

    }

    public static String runInstruction(String instructionSet, Deque<String> deque){

        //좌 방향을 삭제 시 false, 우 방향을 삭제 시 true
        boolean currentDeletionDirection = false;

        for(int i = 0; i < instructionSet.length(); i++){
            //명령어 가져오기
            char instruction = instructionSet.charAt(i);

            switch (instruction){
                case 'R':
                    currentDeletionDirection = !currentDeletionDirection;
                    break;
                case 'D':
                    //덱이 비었을 경우 error
                    if(deque.isEmpty())
                        return "error";
                    if(currentDeletionDirection)
                        deque.pollLast();
                    else
                        deque.pollFirst();
                    break;
            }
        }

        int size = deque.size();
        //덱 size 가 0인데 에러가 없을 경우 []를 반환
        if(size == 0)
            return "[]";

        //결과 String 생성
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < size - 1; i++){
            if(!currentDeletionDirection)
                sb.append(deque.pollFirst());
            else
                sb.append(deque.pollLast());
            sb.append(",");
        }
        if(!currentDeletionDirection)
            sb.append(deque.pollFirst());
        else
            sb.append(deque.pollLast());
        sb.append("]");

        return sb.toString();

    }
}
