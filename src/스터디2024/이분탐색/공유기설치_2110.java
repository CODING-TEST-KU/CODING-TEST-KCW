package 스터디2024.이분탐색;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 공유기설치_2110 {
    static int[] distance;
    static int n;
    static int c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int[] location = new int[n];

        for(int i = 0; i < n; i++){
            location[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(location);

        distance = new int[n - 1];

        for(int i = 0; i < n - 1; i++){
            distance[i] = location[i+1] - location[i];
        }


        int maxDistance = (location[location.length-1] + 0) / 2;
        int ans = isPossibleForDistance(0, location[location.length - 1], maxDistance);
        System.out.println(ans);
        br.close();

    }

    public static int isPossibleForDistance(int startD, int endD, int maxDistance){

        if(startD == endD){
            return maxDistance;
        }

        long sumOfDistance = 0;
        int presentSetUp = 1;  //1번 집에는 무조건 공유기 설치

        for(int i = 0; i < n - 1; i++){
            sumOfDistance += distance[i];
            if(sumOfDistance >= (long) maxDistance){
                presentSetUp += 1;
                sumOfDistance = 0;
                if(presentSetUp == c) {
                    return isPossibleForDistance(maxDistance, endD, Math.round((endD + maxDistance) / 2.0f));
                }
            }
        }
        return isPossibleForDistance(startD, maxDistance - 1, (maxDistance - 1 + startD) / 2);
    }
}
