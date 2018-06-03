package algorithm.baekjoon.dynamic;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Seran on 2018-06-03.
 * 11722. 가장 긴 감소하는 부분 수열
 * https://www.acmicpc.net/problem/11722
 */

public class Ex11722 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N ; i++) {
            A[i] = sc.nextInt();
        }
        int[] D = new int[N];
        D[0] = 1;
        for (int i = 1; i < N ; i++) {
            for (int j = 0; j < i ; j++) {
                if (A[i] < A[j] && D[i] < D[j]) {
                    D[i] = D[j];
                }
            }
            D[i] += 1;
        }

        Arrays.sort(D);

        System.out.println(D[N-1]);
    }
}
