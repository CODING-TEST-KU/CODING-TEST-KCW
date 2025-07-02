package 스터디2024.x6스택의활용;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class 괄호의값_2504 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        System.out.println(sequence(str));


    }

    public static Long sequence(String str){
        if(str.length() == 0)
            return 0L;

        Long result = 0L;
        Deque<String> stack = new ArrayDeque<>();

        for(int i = 0; i < str.length(); i++){
            String next = String.valueOf(str.charAt(i));
            String top = stack.peek();

            switch (next){
                case "(":
                    stack.push(next);
                    break;
                case "[":
                    stack.push(next);
                    break;
                case ")":
                    if(top != null && top.equals("("))
                        stack.pop();
                    else
                        return 0L;
                    break;
                case "]":
                    if(top != null && top.equals("["))
                        stack.pop();
                    else
                        return 0L;
                    break;
            }

        }

        if(!stack.isEmpty())
            return 0L;

        stack.clear();
        for(int i = 0; i < str.length(); i++){
            String next = String.valueOf(str.charAt(i));
            String top = stack.peek();

            switch (next){
                case "(":
                    stack.push(next);
                    break;
                case "[":
                    stack.push(next);
                    break;
                case ")":
                    if(top.equals("(")) {
                        stack.pop();
                        stack.push("2");
                    }
                    else{
                        int sum = 0;
                        while(!top.equals("(")){
                            sum += Integer.parseInt(stack.pop());
                            top = stack.peek();
                        }
                        stack.pop();
                        sum *= 2;
                        stack.push(String.valueOf(sum));
                    }
                    break;
                case "]":
                    if(top.equals("[")) {
                        stack.pop();
                        stack.push("3");
                    }
                    else{
                        int sum = 0;
                        while(!top.equals("[")){
                            sum += Integer.parseInt(stack.pop());
                            top = stack.peek();
                        }
                        stack.pop();
                        sum *= 3;
                        stack.push(String.valueOf(sum));
                    }
                    break;
            }

        }

        while(!stack.isEmpty())
            result += Long.valueOf(stack.pop());

        return result;

    }

}
