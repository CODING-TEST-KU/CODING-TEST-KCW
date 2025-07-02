package 스터디2024.x8재귀;

import java.io.*;

public class 재귀함수가뭔가요_17478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
        recursion(N, N, sb);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    public static void recursion(int size, int n, StringBuilder sb){

        int stickNum = (size - n) * 4;
        StringBuilder stickBuilder = new StringBuilder();
        stickBuilder.append("");
        for(int i = 0; i < stickNum; i++){
            stickBuilder.append("_");
        }

        String stick = stickBuilder.toString();

        if(n == 0){
            sb.append(stick);
            sb.append("\"재귀함수가 뭔가요?\"\n");
            sb.append(stick);
            sb.append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");

        }
        else {
            sb.append(stick);
            sb.append("\"재귀함수가 뭔가요?\"\n");
            sb.append(stick);
            sb.append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
            sb.append(stick);
            sb.append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
            sb.append(stick);
            sb.append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");

            recursion(size, n - 1, sb);
        }

        if(n==size){
            sb.append(stick);
            sb.append("라고 답변하였지.");
            return;
        }
        sb.append(stick);
        sb.append("라고 답변하였지.\n");

        return;

    }
}
