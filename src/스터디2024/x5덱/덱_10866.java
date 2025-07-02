package 스터디2024.x5덱;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 덱_10866 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Deque<String> queue = new ArrayDeque<>();

        for(int i = 0; i < N; i++){
            String tempConstruction = br.readLine();
            int j = 0;

            switch(tempConstruction){
                case "pop_front":
                    if (!queue.isEmpty())
                        bw.write(queue.pollLast());
                    else
                        bw.write("-1");
                    break;
                case "pop_back":
                    if (!queue.isEmpty())
                        bw.write(queue.pollFirst());
                    else
                        bw.write("-1");
                    break;
                case "size":
                    bw.write(String.valueOf(queue.size()));
                    break;
                case "empty":
                    if(queue.isEmpty())
                        bw.write("1");
                    else
                        bw.write("0");
                    break;
                case "front":
                    if(queue.isEmpty())
                        bw.write("-1");
                    else
                        bw.write(queue.getLast());
                    break;
                case "back":
                    if(queue.isEmpty())
                        bw.write("-1");
                    else
                        bw.write(queue.getFirst());
                    break;
                default:
                    StringTokenizer st = new StringTokenizer(tempConstruction, " ");

                    if(st.nextToken().equals("push_back"))
                        queue.push(st.nextToken());
                    else
                        queue.addLast(st.nextToken());


                    j = 1;
                    break;
            }

            if(j == 0)
                bw.newLine();

        }

        bw.flush();
        bw.close();
        br.close();
    }

}
