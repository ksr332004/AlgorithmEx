package algorithm.baekjoon.etc;

/**
 * Created by Administrator on 2018-02-28.
 * https://www.acmicpc.net/problem/4673
 * 4673. 셀프 넘버
 */
public class Ex4673 {
    public static void main(String[] args) {
        // 양의 정수 n의 범위
        int N = 10000;
        // d(n)의 수 집합
        int[] D = new int[N+1];

        for (int i=1; i<=N; i++) {
            // 양의 정수 n
            int n = i;
            // d(n)의 값
            int sum = i;

            while (n > 0) {
                sum += n%10;
                n = n/10;
            }

            // 생성자가 있는 수 체크
            if (sum <= N) {
                D[sum] = 1;
            }

            // 셀프 넘버인 경우
            if (D[i] != 1) {
                System.out.println(i);
            }
        }
    }
}
