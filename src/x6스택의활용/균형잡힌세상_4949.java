package x6스택의활용;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class 균형잡힌세상_4949 {
    public static void main(String[] args) throws IOException {
        //버퍼 입출력 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String inputStr;

        Label:while(!(inputStr = br.readLine()).equals(".")){

            Deque<Character> stack = new ArrayDeque<>();

            for(int i = 0; i < inputStr.length(); i++){
                char next = inputStr.charAt(i);

                if(isParentheses(next)){
                    if(stack.isEmpty()){
                        if(next == ')' || next == ']'){
                            bw.write("no");
                            bw.newLine();
                            continue Label;
                        }
                    }

                    if(next == '(' || next == '['){
                        stack.push(next);
                        continue;
                    }
                    else {
                        char top = stack.peek();
                        switch(next){
                            case ')':
                                if(top == '('){
                                    stack.pop();
                                    continue;
                                }
                                else{
                                    bw.write("no");
                                    bw.newLine();
                                    continue Label;
                                }
                            case ']':
                                if(top == '['){
                                    stack.pop();
                                    continue;
                                }
                                else{
                                    bw.write("no");
                                    bw.newLine();
                                    continue Label;
                                }
                        }
                    }



                }
                else
                    continue;

            }

            if(!stack.isEmpty()){
                bw.write("no");
                bw.newLine();
            }
            else{
                bw.write("yes");
                bw.newLine();
            }

        }

        bw.flush();
        bw.close();
        br.close();

    }


    public static boolean isParentheses(char s) {
        if(s == ('(') || s == (')') || s == ('[') || s == (']')){
            return true;
        }
        return false;
    }


}
