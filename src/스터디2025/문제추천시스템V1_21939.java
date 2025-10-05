package 스터디2025;

import java.io.*;
import java.util.*;

public class 문제추천시스템V1_21939 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    TreeMap<Integer, TreeSet<Integer>> levelToProblems = new TreeMap<>();
    TreeMap<Integer, Integer> problemsToLevel = new TreeMap<>();

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int problemNum = Integer.parseInt(st.nextToken());
      int level = Integer.parseInt(st.nextToken());

      problemsToLevel.put(problemNum, level);

      if(!levelToProblems.containsKey(level)) {
        levelToProblems.put(level, new TreeSet<>());
        levelToProblems.get(level).add(problemNum);
      }
      else {
        levelToProblems.get(level).add(problemNum);
      }

    }

    int M = Integer.parseInt(br.readLine());

    for (int i = 0; i < M; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String instruction = st.nextToken();

      if(instruction.equals("add")){
        int problemNum = Integer.parseInt(st.nextToken());
        int level = Integer.parseInt(st.nextToken());

        problemsToLevel.put(problemNum, level);

        if(!levelToProblems.containsKey(level)) {
          levelToProblems.put(level, new TreeSet<>());
          levelToProblems.get(level).add(problemNum);
        }
        else{
          levelToProblems.get(level).add(problemNum);
        }
      }
      else if(instruction.equals("solved")){
        int problemNum = Integer.parseInt(st.nextToken());
        int level = problemsToLevel.get(problemNum);
        problemsToLevel.remove(problemNum);
        levelToProblems.get(level).remove(problemNum);
        if(levelToProblems.get(level).isEmpty()){
          levelToProblems.remove(level);
        }
      }
      else if(instruction.equals("recommend")){
        int code = Integer.parseInt(st.nextToken());
        if (code == 1){
          bw.write(String.valueOf(levelToProblems.lastEntry().getValue().last()));
          bw.newLine();
        }
        else{
          bw.write(String.valueOf(levelToProblems.firstEntry().getValue().first()));
          bw.newLine();
        }

      }
    }


    bw.flush();
    bw.close();
    br.close();
  }

}