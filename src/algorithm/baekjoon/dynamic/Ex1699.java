package algorithm.baekjoon.dynamic;

import java.util.Scanner;

/**
 * Created by Seran on 2018-06-03.
 * 1699. 제곱수의 합
 * https://www.acmicpc.net/problem/1699
 */
public class Ex1699 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] J = new int[N+1];
        int[] D = new int[N+1];
        J[1] = 1;
        D[1] = 1;
        for (int i = 2; i <= N ; i++) {
            if (i == (J[i-1]+1)*(J[i-1]+1)) {
                D[i] = 1;
                J[i] = J[i-1] + 1;
            } else {
                for (int j = 1; j <= J[i-1] ; j++) {
                    int d = i;
                    d -= j*j;
                    if (D[i] == 0) {
                        D[i] = D[d] + 1;
                    } else {
                        D[i] = Math.min(D[i], D[d] + 1);
                    }
                }
                J[i] = J[i-1];
            }
        }

        System.out.println(D[N]);
    }
}
