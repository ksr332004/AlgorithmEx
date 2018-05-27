package algorithm.baekjoon.dynamic;

import java.util.Scanner;

/**
 * Created by Seran on 2018-05-27.
 * 11727. 2×n 타일링 2
 * https://www.acmicpc.net/problem/11727
 */
public class Ex11727 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] D = new long[1001];

        D[1] = 1;
        D[2] = 3;
        for (int i=3; i<=n; i++) {
            if (i%2 == 1) {
                D[i] = ((D[i-1]*2) + (-1))%10007;
            } else {
                D[i] = ((D[i-1]*2) + 1)%10007;
            }
        }

        System.out.println(D[n]);
    }
}