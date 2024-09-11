package x4큐;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 큐_10845 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Deque<String> queue = new ArrayDeque<>();

        for(int i = 0; i < N; i++){
            String tempConstruction = br.readLine();
            int j = 0;

            switch(tempConstruction){
                case "pop":
                    if (!queue.isEmpty())
                        bw.write(queue.pollLast());
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
                    st.nextToken();
                    queue.push(st.nextToken());
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
