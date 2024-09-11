package x3스택;

import jdk.jfr.Unsigned;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class 오아시스재결합_3015 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Deque<Element> stack = new ArrayDeque<>();

        Long temp = 0L;
        Long tempPop = -1L;
        Long result = 0L;


        for(int i = 0; i < N; i++){

            Element presentElement = new Element(Long.parseLong(br.readLine()), false);

            while(true){
                if(stack.isEmpty()){
                    stack.push(presentElement);
                    break;
                }

                Element peekElement = stack.peek();

                if(peekElement.height > presentElement.height){
                    stack.push(presentElement);
                    result += stack.size() - 1L - temp;
                    presentElement.isIncreasedTemp = true;
                    temp++;
                    tempPop = -1L;
                    break;
                }
                else if(peekElement.height == presentElement.height){
                    stack.push(presentElement);
                    result += stack.size() - 1L;
                    presentElement.isIncreasedTemp = true;
                    temp++;
                    tempPop = -1L;
                    break;
                }
                else{
                    Element presentPopData = stack.pop();

                    if(tempPop != presentPopData.height)
                        result += 1L;
                    if(presentPopData.isIncreasedTemp)
                        temp--;

                    tempPop = presentPopData.height;
                }
            }

        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();

    }

    public static class Element{
        Long height;
        boolean isIncreasedTemp;

        Element(Long height, boolean isIncreasedTemp){
            this.height = height;
            this.isIncreasedTemp = isIncreasedTemp;

        }

    }
}
