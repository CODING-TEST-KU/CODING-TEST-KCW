package 해시;

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class 싸이버개강총회_19583 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int startTime;
        int endTime;
        int streamingEndTime;
        StringTokenizer st1 = new StringTokenizer(st.nextToken(), ":");
        startTime = Integer.parseInt(st1.nextToken()) * 60 + Integer.parseInt(st1.nextToken());
        st1 = new StringTokenizer(st.nextToken(), ":");
        endTime = Integer.parseInt(st1.nextToken()) * 60 + Integer.parseInt(st1.nextToken());
        st1 = new StringTokenizer(st.nextToken(), ":");
        streamingEndTime = Integer.parseInt(st1.nextToken()) * 60 + Integer.parseInt(st1.nextToken());

        String line;
        Set<String> previousSet = new HashSet<>();
        Set<String> afterSet = new HashSet<>();

        while((line = br.readLine()) != null){

            StringTokenizer st2 = new StringTokenizer(line, " ");
            StringTokenizer st3 = new StringTokenizer(st2.nextToken(), ":");
            int time = Integer.parseInt(st3.nextToken()) * 60 + Integer.parseInt(st3.nextToken());
            String name = st2.nextToken();

            if(time <= startTime){
                //시작 시간 이전에 참여한 사람들의 명단을 Set 에 저장한다.
                previousSet.add(name);
            }
            else if(endTime <= time && time <= streamingEndTime){
                //끝난 이후에 채팅친 사람들의 명단을 Set 에 저장한다.
                afterSet.add(name);
            }
        }

        //시작 시간 이전에 참여한 사람들의 Set을 순회하며 끝난 이후에도 있었는지 체크한다.
        Iterator<String> iterator = previousSet.iterator();
        int ans = 0;
        while(iterator.hasNext()){
            String next = iterator.next();
            if(afterSet.contains(next)){
               ans++;
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();

    }
}
