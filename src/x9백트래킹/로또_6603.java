package x9백트래킹;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 로또_6603 {

    public static List<String> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {

            result.clear();

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int k = Integer.parseInt(st.nextToken());

            if(k==0)
                break;

            List<String> initList = new ArrayList<>();
            while(st.hasMoreTokens()){
                initList.add(st.nextToken());
            }
            selectNumber(initList, "", 0);
            result.stream().forEach(r-> {
                try {
                    bw.write(r);
                    bw.newLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();

    }

    public static void selectNumber(List<String> numberSet, String resultString, int index){

        if(index == 6){
            result.add(resultString);
            return;
        }

        int size = numberSet.size();

        for(int i = 0; i < size; i++){
            String n = numberSet.get(0);
            List<String> nextNumberSet = new ArrayList<>(numberSet);

            nextNumberSet.remove(n);
            if(index == 0)
                selectNumber(nextNumberSet, n, index + 1);
            else
                selectNumber(nextNumberSet, resultString +" "+n, index + 1);

            numberSet.remove(n);
        }



    }


}
