package 스터디2025.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 스티커붙이기_18808 {

  public static void main(String[] args) throws IOException {
    // 필요한 값 읽기
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    // 노트북 생성
    Notebook notebook = new Notebook(N, M);
    for (int i = 0; i < K; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int stickerRowNum = Integer.parseInt(st.nextToken());
      int stickerColumnNum = Integer.parseInt(st.nextToken());

      // 스티커 생성
      Sticker sticker = new Sticker(stickerRowNum, stickerColumnNum, br, i);

      // 스티커를 회전시키면서 노트북에 붙힐 수 있는지 확인
      for (int rotateCount = 0; rotateCount < 4; rotateCount++) {
        if (notebook.stick(sticker)) {
          break;
        }
        sticker.rotate();
      }
    }

    bw.write(String.valueOf(notebook.spaceInUse));
    bw.flush();
    br.close();
    bw.close();
  }

  public static class Grid {

    public int rowNum;
    public int columnNum;
    public boolean[][] shape;

    public Grid(int rowNum, int columnNum, BufferedReader br) {
      this.rowNum = rowNum;
      this.columnNum = columnNum;

      shape = new boolean[rowNum][columnNum];
      shapeInit(br);
    }

    private void shapeInit(BufferedReader br) {

      //BufferedReader가 없을 경우 0으로 채움
      if (br == null) {
        for (int i = 0; i < rowNum; i++) {
          Arrays.fill(shape[i], false);
        }
        return;
      }

      for (int i = 0; i < rowNum; i++) {
        try {
          StringTokenizer st = new StringTokenizer(br.readLine(), " ");
          for (int j = 0; j < columnNum; j++) {
            shape[i][j] = st.nextToken().equals("1");
          }
        } catch (Exception e) {
          System.out.println(Arrays.toString(e.getStackTrace()));
        }
      }
    }
  }

  public static class Sticker extends Grid {

    public int stickerNum;

    public Sticker(int rowNum, int columnNum, BufferedReader br, int stickerNum) {
      super(rowNum, columnNum, br);
      this.stickerNum = stickerNum;
    }
    
    // 행렬 A[n][m] 을 오른쪽으로 90도 회전 시
    // A[m][row-1-n] 로 옮겨짐
    public void rotate() {
      int newRowNum = this.columnNum;
      int newColumnNum = this.rowNum;
      boolean[][] newShape = new boolean[newRowNum][newColumnNum];

      for (int i = 0; i < this.rowNum; i++) {
        for (int j = 0; j < this.columnNum; j++) {
          newShape[j][(rowNum - 1) - i] = shape[i][j];
        }
      }

      this.shape = newShape;
      this.rowNum = newRowNum;
      this.columnNum = newColumnNum;
    }
  }

  public static class Notebook extends Grid {

    public int spaceInUse = 0;

    public Notebook(int rowNum, int columnNum) {
      super(rowNum, columnNum, null);
    }

    public boolean stick(Sticker sticker) {

      int rowDifference = this.rowNum - sticker.rowNum;
      int columnDifference = this.columnNum - sticker.columnNum;
      if (rowDifference < 0 || columnDifference < 0) {
        return false;
      }

      // 한 자리씩 오른쪽 위부터 맞춰본다. 가능하면 붙힌다.
      for (int i = 0; i < rowDifference + 1; i++) {
        for (int j = 0; j < columnDifference + 1; j++) {
          if (availableSpace(sticker, i, j)) {
            commitStick(sticker, i, j);
            return true;
          }
        }
      }
      return false;
    }

    private boolean availableSpace(Sticker sticker, int correctionRowCount,
        int correctionColumnCount) {
      for (int r = 0; r < sticker.rowNum; r++) {
        for (int c = 0; c < sticker.columnNum; c++) {
          if (sticker.shape[r][c] && this.shape[r + correctionRowCount][c
              + correctionColumnCount]) {
            return false;
          }
        }
      }
      return true;
    }

    private void commitStick(Sticker sticker, int correctionRowCount, int correctionColumnCount) {
      for (int r = 0; r < sticker.rowNum; r++) {
        for (int c = 0; c < sticker.columnNum; c++) {
          if (sticker.shape[r][c]) {
            this.shape[r + correctionRowCount][c + correctionColumnCount] = true;
            spaceInUse++;
          }
        }
      }
    }

  }

}
