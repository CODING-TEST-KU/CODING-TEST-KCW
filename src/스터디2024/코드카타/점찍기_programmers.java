package 스터디2024.코드카타;

public class 점찍기_programmers {

    public static void main(String[] args) {

        System.out.println(solution(2, 4));
    }

    public static long solution(long k, long d) {
        long answer = 0;



        for(long i = 0; i <= d; i+=k) {
            long maxY = (long)Math.sqrt(d*d-i*i);
            long count = maxY/k + 1;
            answer = answer + count;
        }


        return answer;
    }

}
