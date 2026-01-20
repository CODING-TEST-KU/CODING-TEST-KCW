package 스터디2026.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 설탕배달_2839 {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N;

  public static void main(String[] args) throws IOException {
    N = Integer.parseInt(br.readLine());
    System.out.println(select(N));

  }

  public static int select(int n) {
    if (n == 5) {
      return 1;
    }
    if (n == 3) {
      return 1;
    }
    if (n < 3 || n == 4) {
      return -1;
    }

    int result;
    if ((result = select(n - 5)) != -1) {
      return result + 1;
    } else if ((result = select(n - 3)) != -1) {
      return result + 1;
    } else {
      return -1;
    }
  }

}
