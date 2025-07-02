package 스터디2024.x9백트래킹;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 비숍_1799 {

    public static List<Integer> result1 = new ArrayList<>();
    public static int n;
    public static int globalNumOfBishop = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n; j++){
                result1.add(Integer.parseInt(st.nextToken()));
            }
        }

        selectNumber(result1, 0, 0);

        System.out.println(globalNumOfBishop);



        bw.flush();
        bw.close();
        br.close();

    }

    public static void selectNumber(List<Integer> result, int numOfBishop, int index){

        if(index == n*n){
            if(globalNumOfBishop < numOfBishop)
                globalNumOfBishop = numOfBishop;


            return;
        }


        int size = 2;
        boolean presentN = true;


        for(int i = 0; i < size; i++){

            List<Integer> nextResult = new ArrayList<>(result);

            if(presentN && nextResult.get(index)!= 0) {
                //대각선 0 처리
                setDiagonalElementsToZero(nextResult, index);
                selectNumber(nextResult, numOfBishop+1, index + 1);
            }
            else {
                nextResult.set(index, 0);
                selectNumber(nextResult, numOfBishop, index + 1);
            }

            presentN = false;
        }



    }
    public static int convertTo1DIndex(int row, int col, int n) {
        return row * n + col;
    }

    public static void setDiagonalElementsToZero(List<Integer> array1D, int targetIndex) {
        int row = targetIndex / n;
        int col = targetIndex % n;

        // 주어진 인덱스에서의 주대각선 (왼쪽 상단에서 오른쪽 하단) 원소를 0으로 설정
        for (int i = 0; i < n; i++) {
            int diagRow = row + i - Math.min(row, col);
            int diagCol = col + i - Math.min(row, col);
            if (diagRow >= 0 && diagRow < n && diagCol >= 0 && diagCol < n) {
                int diagIndex = convertTo1DIndex(diagRow, diagCol, n);
                array1D.set(diagIndex,0);
            }
        }

        // 주어진 인덱스에서의 부대각선 (오른쪽 상단에서 왼쪽 하단) 원소를 0으로 설정
        for (int i = 0; i < n; i++) {
            int antiDiagRow = row + i - Math.min(row, n - 1 - col);
            int antiDiagCol = col - i + Math.min(row, n - 1 - col);
            if (antiDiagRow >= 0 && antiDiagRow < n && antiDiagCol >= 0 && antiDiagCol < n) {
                int antiDiagIndex = convertTo1DIndex(antiDiagRow, antiDiagCol, n);
                array1D.set(antiDiagIndex,0);
            }
        }

    }
}
