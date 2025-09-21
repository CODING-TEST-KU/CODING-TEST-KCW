package 스터디2025.DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 피보나치의수2_2748 {

  static long[] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    arr = new long[N + 1];

    for(int i = 0; i < N + 1; i++) {
      arr[i] = -1;
    }

    arr[0] = 0;
    arr[1] = 1;
    bw.write(String.valueOf(iter(N)));
  }

  public static long iter(int N) {
    if(arr[N] == -1) {
      arr[N] = iter(N - 1) + iter(N - 2);
    }
    return arr[N];
  }
}
