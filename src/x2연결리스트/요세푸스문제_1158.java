package x2연결리스트;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class 요세푸스문제_1158 {
    public static void main(String[] args) throws IOException {
        //Reader, Writer 선언 및 초기 값 읽기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        //---

        CustomLinkedList<Integer> linkedList = new CustomLinkedList<>();

        //연결리스트 초기화
        for(int i = 1; i <= N; i++){
            linkedList.add(i);
        }
        //---

        //결과 리스트 선언
        List<Integer> result = new ArrayList<>();
        //---

        while(!linkedList.isEmpty()){

            //K값에 따라 지워야할 노드를 찾는다
            for(int i = 0; i < K - 1; i++){
                linkedList.nextNodeIndex();
            }

            //찾은 노드의 데이터값을 result 리스트에 저장하고 노드를 삭제한다.
            result.add(linkedList.get(linkedList.presentNodeIndex()));
            linkedList.remove(linkedList.presentNodeIndex());

        }


        //결과 출력
        bw.write('<');
        for (int i = 0; i < result.size(); i++) {
            bw.write(String.valueOf(result.get(i)));
            if (i != result.size() - 1) {  // 마지막에는 쉼표와 공백을 추가하지 않음
                bw.write(", ");
            }
        }
        //---
        bw.write('>');
        bw.flush();
        bw.close();
        br.close();
    }

    public static class CustomLinkedList<T> extends LinkedList<T>{

        private int offset = 0;

        @Override
        public T remove(int index) {

            if(super.size() - 1 == offset){
                offset = 0;
            }

            return super.remove(index);

        }

        public int nextNodeIndex(){
            if(super.size() - 1 <= offset)
                offset = 0;
            else
                offset++;

            return offset;
        };

        public int presentNodeIndex(){
            return offset;
        }

    }

}
