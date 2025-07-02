package 스터디2025.정렬;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 먹을것인가먹힐것인가_7795 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int testCaseNum = Integer.parseInt(br.readLine());
    StringBuilder resultString = new StringBuilder();
    for (int i = 0; i < testCaseNum; i++) {
      int result = solve(br);
      resultString.append(result);
      resultString.append("\n");
    }

    bw.write(resultString.toString());
    bw.flush();
    bw.close();
    br.close();
  }

  public static int solve(BufferedReader br) throws IOException {
    StringTokenizer stN = new StringTokenizer(br.readLine(), " ");
    StringTokenizer stA = new StringTokenizer(br.readLine(), " ");
    StringTokenizer stB = new StringTokenizer(br.readLine(), " ");

    int numOfA = Integer.parseInt(stN.nextToken());
    int numOfB = Integer.parseInt(stN.nextToken());

    List<Integer> AList = new ArrayList<>();
    for (int i = 0; i < numOfA; i++) {
      AList.add(Integer.valueOf(stA.nextToken()));
    }

    List<Integer> BList = new ArrayList<>();
    for (int i = 0; i < numOfB; i++) {
      BList.add(Integer.valueOf(stB.nextToken()));
    }

    AList.sort(Collections.reverseOrder());
    BList.sort(Collections.reverseOrder());

    int j = 0;
    int result = 0;
    for (int i = 0; i < numOfA; i++) {
      int currentA = AList.get(i);
      for (; j < numOfB; j++) {
        if (BList.get(j) < currentA) {
          result += numOfB - j;
          break;
        }
      }
    }

    return result;
  }

}
