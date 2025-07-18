package 스터디2025.그리디;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 수묶기_1744 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    List<Integer> positiveSequence = new ArrayList<>();
    List<Integer> negativeSequence = new ArrayList<>();
    int ones = 0;
    int zeros = 0;

    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(br.readLine());

      if (num > 1) {
        positiveSequence.add(num);
      } else if (num < 0) {
        negativeSequence.add(num);
      } else if (num == 1) {
        ones += 1;
      } else {
        zeros += 1;
      }
    }

    int result = ones;

    positiveSequence.sort(Comparator.reverseOrder());
    negativeSequence.sort(null);

    for (int i = 0; i < positiveSequence.size() - 1; i += 2) {
      result += positiveSequence.get(i) * positiveSequence.get(i + 1);
    }

    if (positiveSequence.size() % 2 == 1) {
      result += positiveSequence.get(positiveSequence.size() - 1);
    }

    for (int i = 0; i < negativeSequence.size() - 1; i += 2) {
      result += negativeSequence.get(i) * negativeSequence.get(i + 1);
    }

    if (negativeSequence.size() % 2 == 1) {
      if (zeros == 0){
        result += negativeSequence.get(negativeSequence.size() - 1);
      }
    }

    bw.write(String.valueOf(result));
    bw.flush();
    bw.close();
    br.close();
  }

}
