package 스터디2025.이분탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 랜선자르기_1654 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int K = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());

    List<Long> lineLengths = new ArrayList<>();
    long maxValue = 1;
    for (int i = 0; i < K; i++) {
      long currentValue = Long.parseLong(br.readLine());
      if (maxValue <= currentValue) {
        maxValue = currentValue;
      }
      lineLengths.add(currentValue);
    }

    long high = maxValue + 1;
    long low = 1;
    long pivot = (high + low) / 2;

    while (low < high) {
      long sumNumLine = 0;
      for (int i = 0; i < K; i++) {
        sumNumLine += lineLengths.get(i) / pivot;
      }

      if (sumNumLine >= N) {
        low = pivot + 1;
        pivot = ((high + low) / 2);
      } else {
        high = pivot;
        pivot = ((high + low) / 2);
      }

    }

    bw.write(String.valueOf(pivot - 1));
    bw.close();
    br.close();
  }
}
