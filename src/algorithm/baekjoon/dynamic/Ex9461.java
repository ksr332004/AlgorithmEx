package algorithm.baekjoon.dynamic;

import java.util.Scanner;

/**
 * Created by Seran on 2018-06-03.
 * 9461. 파도반 수열
 * https://www.acmicpc.net/problem/9461
 */
public class Ex9461 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        long[] P = new long[101];
        P[0] = 0;
        P[1] = 1;
        P[2] = 1;
        P[3] = 1;
        P[4] = 2;
        for (int i = 5; i < 101 ; i++) {
            P[i] = P[i-1] + P[i-5];
        }
        for (int test_case = 0; test_case < T ; test_case++) {
            int N = sc.nextInt();
            System.out.println(P[N]);
        }
    }
}
