package 스터디2025.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 주사위굴리기_14499 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    Map map = new Map(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    Dice dice = new Dice(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    int numOperation = Integer.parseInt(st.nextToken());
    map.initMap(br);

    StringTokenizer operations = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < numOperation; i++) {
      int topNumber = dice.doOperation(operations.nextToken(), map);
      // 주사위를 돌릴 수 없는 상황
      if (topNumber == -1) {
        continue;
      }
      bw.write(String.valueOf(topNumber));
      bw.newLine();
    }

    bw.flush();
    bw.close();
    br.close();
  }

  public static class Dice {

    // 주사위의 위치
    int r;
    int c;
    // 주사위의 위상
    int[][] phase = new int[4][3];

    public Dice(int r, int c) {
      this.r = r;
      this.c = c;
      for (int i = 0; i < 4; i++) {
        Arrays.fill(phase[i], 0);
      }
    }

    public int doOperation(String operation, Map map) {
      // 위상 변경
      int nextR, nextC;
      if (operation.equals("1")) {
        // 동
        nextR = r;
        nextC = c + 1;

        if (!map.isValidCoordinate(nextR, nextC)) {
          return -1;
        }
        int temp = phase[1][2];
        phase[1][2] = phase[1][1];
        phase[1][1] = phase[1][0];
        phase[1][0] = phase[3][1];
        phase[3][1] = temp;

      } else if (operation.equals("2")) {
        // 서
        nextR = r;
        nextC = c - 1;

        if (!map.isValidCoordinate(nextR, nextC)) {
          return -1;
        }
        int temp = phase[1][0];
        phase[1][0] = phase[1][1];
        phase[1][1] = phase[1][2];
        phase[1][2] = phase[3][1];
        phase[3][1] = temp;

      } else if (operation.equals("3")) {
        // 북
        nextR = r - 1;
        nextC = c;

        if (!map.isValidCoordinate(nextR, nextC)) {
          return -1;
        }
        int temp = phase[0][1];
        phase[0][1] = phase[1][1];
        phase[1][1] = phase[2][1];
        phase[2][1] = phase[3][1];
        phase[3][1] = temp;

      } else {
        // 남
        nextR = r + 1;
        nextC = c;

        if (!map.isValidCoordinate(nextR, nextC)) {
          return -1;
        }
        int temp = phase[3][1];
        phase[3][1] = phase[2][1];
        phase[2][1] = phase[1][1];
        phase[1][1] = phase[0][1];
        phase[0][1] = temp;
      }

      // 지도에 스탬프 찍기
      int stampResult = map.stampPhaseNumber(nextR, nextC, phase[3][1]);
      
      // 지도가 0이 아니라면
      if (stampResult != -1) {
        phase[3][1] = stampResult;
      }

      r = nextR;
      c = nextC;
      // 윗면에 적혀있는 수 반환
      return phase[1][1];
    }
  }

  public static class Map {

    int N;
    int M;
    int[][] phase;

    public Map(int N, int M) {
      this.N = N;
      this.M = M;
    }

    public void initMap(BufferedReader br) throws Exception {
      for (int i = 0; i < N; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int j = 0; j < M; j++) {
          phase[i][j] = Integer.parseInt(st.nextToken());
        }
      }
    }

    public boolean isValidCoordinate(int x, int y) {
      if (x < 0 || x >= N || y < 0 || y >= M) {
        return false;
      }
      return true;
    }

    public int stampPhaseNumber(int r, int c, int diceBottomNumber) {
      if (phase[r][c] == 0) {
        phase[r][c] = diceBottomNumber;
        return -1;
      }
      int returnValue = phase[r][c];
      phase[r][c] = 0;
      return returnValue;
    }

  }

}
