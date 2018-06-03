package algorithm.baekjoon.dynamic;

import java.util.Scanner;

/**
 * Created by Seran on 2018-06-03.
 * 11054. 가장 긴 바이토닉 부분 수열
 * https://www.acmicpc.net/problem/11054
 */
public class Ex11054 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] S = new int[N];
        for (int i = 0; i < N ; i++) {
            S[i] = sc.nextInt();
        }

        int[] D1 = new int[N]; // 증가
        int[] D2 = new int[N]; // 감소
        D1[0] = 1;
        D2[N-1] = 1;
        for (int i = 1; i < N ; i++) {
            for (int j = 0; j < i ; j++) {
                if (S[i] > S[j] && D1[i] < D1[j]) {
                    D1[i] = D1[j];
                }
                if (S[N-1-i] > S[N-1-j] && D2[N-1-i] < D2[N-1-j]) {
                    D2[N-1-i] = D2[N-1-j];
                }
            }
            D1[i] += 1;
            D2[N-1-i] += 1;
        }

        int b = 0;
        for (int i = 0; i < N ; i++) {
            int sum = D1[i] + D2[i] - 1;
            if (b < sum) {
                b = sum;
            }
        }

        System.out.println(b);
    }
}
