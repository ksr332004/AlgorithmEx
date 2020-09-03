package algorithm.codility;

public class Lesson10_01 {

    public static int solution(int N) {
        if (N == 0 || N == 1) {
            return N;
        }

        int answer = 0;

        int D = 1;
        int M = N;

        while (D < M) {
            if (N % D == 0) {
                M = N/D;
                if (D == M) {
                    answer += 1;
                } else {
                    answer += 2;
                }
            }
            D++;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(24));
        System.out.println(solution(7));
        System.out.println(solution(9));
        System.out.println(solution(10));
        System.out.println(solution(4));
        System.out.println(solution(16));
    }
}
