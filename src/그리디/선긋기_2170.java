package 그리디;

import java.io.*;
import java.util.*;

public class 선긋기_2170 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numOfLine = Integer.parseInt(br.readLine());

        List<LinePair> linePairs = new ArrayList<>();
        for(int i = 0; i < numOfLine; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());

            linePairs.add(new LinePair(x, y));
        }

        //선들을 x에 대하여 정렬한다.
        Collections.sort(linePairs);
        Long totalLength = 0L;

        //길이 측정 및 중복되는 선 제외하는 알고리즘
        for(int i = 0; i < numOfLine - 1; i++){
            LinePair presentPair = linePairs.get(i);
            totalLength += presentPair.length;

            LinePair nextPair = linePairs.get(i+1);
            if (nextPair.x < presentPair.y){
                nextPair.setXY(presentPair.y);
            }
        }
        //마지막 선의 길이 추가
        totalLength += linePairs.get(numOfLine - 1).length;

        bw.write(String.valueOf(totalLength));
        bw.flush();
        bw.close();
        br.close();
    }

    public static class LinePair implements Comparable {

        public Long x;
        public Long y;
        public Long length;

        public void setXY(Long y1){
            if(this.y < y1){
                this.y = y1;
            }

            this.x = y1;

            setLength();
        }

        public void setLength(){
            this.length = this.y - this.x;
        }


        LinePair(Long x, Long y){
            this.x = x;
            this.y = y;
            setLength();
        }


        @Override
        public int compareTo(Object o) {

            if(o instanceof LinePair){
                LinePair lp = (LinePair)o;
                if(this.x > lp.x){
                    return 1;
                }
                else if(this.x < lp.x){
                    return -1;
                }
                else
                    return 0;
            }

            return -1;
        }
    }
}
