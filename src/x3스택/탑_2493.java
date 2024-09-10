package x3스택;

import java.io.*;
import java.util.*;

public class 탑_2493 {
    public static void main(String[] args) throws IOException {
        //Reader, Writer 선언 및 초기 값 읽기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        Deque<Element> remainingStack = new ArrayDeque<>();
        Deque<Element> mainStack = new ArrayDeque<>();
        int[] resultList = new int[N];


        for (int i = 0; i < N; i++) {
            remainingStack.push(new Element(Integer.parseInt(st.nextToken()), i+1));
        }


        for (int i = 0; i < N; i++) {

            Element presentElement = remainingStack.pop();

            while(true){
                if(mainStack.isEmpty()){
                    mainStack.push(presentElement);
                    break;
                }

                Element peekElement = mainStack.peek();

                if(presentElement.height >= peekElement.height){
                    mainStack.pop();
                    resultList[peekElement.number - 1] = presentElement.number;
                }
                else if(presentElement.height < peekElement.height){
                    mainStack.push(presentElement);
                    break;
                }

            }

        }

        mainStack.stream().forEach(s-> resultList[s.number - 1] = 0);

        for(int i = 0; i < N - 1; i++){
            bw.write(String.valueOf(resultList[i]));
            bw.write(" ");
        }
        bw.write(String.valueOf(resultList[N - 1]));
        bw.flush();
        bw.close();
        br.close();

    }

    public static class Element{
        public Integer height;
        public Integer number;

        public Element(Integer height, Integer number){
            this.height = height;
            this.number = number;
        }

    }
}
