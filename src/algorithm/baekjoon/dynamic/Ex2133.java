package algorithm.baekjoon.dynamic;

import java.util.Scanner;

/**
 * Created by Seran on 2018-06-03.
 * 2133. 타일 채우기
 * https://www.acmicpc.net/problem/2133
 */
public class Ex2133 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] D = new int[N+1][8];
        D[0][7] = 1;
        for (int i = 1; i <= N ; i++) {
            D[i][0] = D[i-1][7];
            D[i][1] = D[i-1][6];
            D[i][2] = D[i-1][5];
            D[i][3] = D[i-1][4] + D[i-1][7];
            D[i][4] = D[i-1][3];
            D[i][5] = D[i-1][2];
            D[i][6] = D[i-1][1] + D[i-1][7];
            D[i][7] = D[i-1][0] + D[i-1][3] + D[i-1][6];
        }

        System.out.println(D[N][7]);
    }
}
