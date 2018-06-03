package algorithm.baekjoon.dynamic;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Seran on 2018-06-03.
 * 1912. 연속합
 * https://www.acmicpc.net/problem/1912
 */
public class Ex1912 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n ; i++) {
            A[i] = sc.nextInt();
        }

        int[] D = new int[n];
        D[0] = A[0];
        for (int i = 1; i < n ; i++) {
            if (D[i-1] < 0) {
                D[i] = A[i];
            } else {
                D[i] = D[i-1] + A[i];
            }
        }

        Arrays.sort(D);

        System.out.println(D[n-1]);
    }
}
