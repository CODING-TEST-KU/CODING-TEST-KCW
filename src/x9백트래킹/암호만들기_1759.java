package x9백트래킹;

import java.io.*;
import java.util.*;

public class 암호만들기_1759 {

    public static int L;
    public static int C;
    public static List<String> resultList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        List<String> initList = new ArrayList<>();
        for(int i = 0; i < C; i++){
            initList.add(st.nextToken());
        }
        Collections.sort(initList);
        Result r = new Result();

        backTracking(initList, r, 0);

        for(int i = 0; i < resultList.size(); i++){
            bw.write(resultList.get(i));
            if(i != resultList.size()-1)
                bw.newLine();

        }

        bw.flush();
        bw.close();
        br.close();



    }

    public static void backTracking(List<String> presentList, Result result, int index){
        if(index == L){
            if(result.isValid)
                resultList.add(result.result);
            return;
        }

        int size = presentList.size();

        for(int i = 0; i < size; i++){

            List<String> nextList = new ArrayList<>(presentList);
            String n = presentList.get(0);
            nextList.remove(n);
            Result nextResult = new Result(result, n);

            if(n.equals("a")||n.equals("e")||n.equals("i")||n.equals("o")||n.equals("u")){
                nextResult.isValid = true;
            }

            backTracking(nextList, nextResult, index + 1);

            presentList.remove(0);

        }


    }
    public static class Result{
        String result = "";
        boolean isValid = false;

        Result(){

        }
        Result(Result r, String n){
            this.result = new String(r.result+n);
            this.isValid = r.isValid;
        }

    }


}
