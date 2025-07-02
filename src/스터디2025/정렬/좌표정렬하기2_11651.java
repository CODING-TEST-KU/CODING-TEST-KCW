package 스터디2025.정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 좌표정렬하기2_11651 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 좌표 갯수 읽기
    int numOfDot = Integer.parseInt(br.readLine());

    List<DOT> dots = new ArrayList<>();
    for (int i = 0; i < numOfDot; i++) {
      // 한줄씩 읽기
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      // DOT 객체 만들어서 List 에 삽입
      dots.add(new DOT(x, y));
    }
    
    //리스트 정렬
    dots.sort(null);
    
    //x, y 출력
    StringBuilder sb = new StringBuilder();
    for (DOT dot : dots) {
      sb.append(dot.x).append(" ").append(dot.y).append("\n");
    }
    
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }

  public static class DOT implements Comparable<DOT> {
    public int x;
    public int y;

    public DOT(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public int compareTo(DOT o) {
      if (this.y < o.y) {
        return -1;
      }
      else if (this.y > o.y) {
        return 1;
      }

      if (this.x < o.x) {
        return -1;
      }
      else if (this.x > o.x) {
        return 1;
      }

      return 0;
    }
  }

}
