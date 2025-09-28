package 스터디2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 회전초밥_2531 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine()," ");

    int numOfPlates = Integer.parseInt(st.nextToken());
    int typeOfFishes = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int coupon = Integer.parseInt(st.nextToken());


    int[] markArray = new int[typeOfFishes + 1];
    Arrays.fill(markArray, 0);
    markArray[coupon] = 1;

    List<Integer> plates = new ArrayList<>();
    for (int i = 0; i < numOfPlates; i++) {
      plates.add(Integer.parseInt(br.readLine()));
    }

    int end = k;
    int presentEatType = 1;
    int maxEatType = 1;

    for(int i = 0; i < k; i++){
      int markCount = markArray[plates.get(i)];
      if(markCount > 0){
        markArray[plates.get(i)]++;

      }
      else {
        presentEatType++;
        markArray[plates.get(i)]++;
      }
    }

    maxEatType = presentEatType;

    for (int start = 1; start < plates.size(); start++) {
      int markCount = markArray[plates.get(start-1)];
      markArray[plates.get(start-1)]--;

      if(markCount == 1){
        presentEatType--;
      }

      markCount = markArray[plates.get(end)];
      markArray[plates.get(end)]++;
      if(markCount == 0){
        presentEatType++;
      }

      end = (end == (plates.size() - 1) ? 0 : end + 1);
      if(presentEatType > maxEatType){
        maxEatType = presentEatType;
      }
    }

    System.out.println(maxEatType);







  }
}
