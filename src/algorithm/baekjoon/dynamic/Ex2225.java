package algorithm.baekjoon.dynamic;

import java.util.Scanner;

/**
 * @author Administrator
 * 2225. 합분해
 * https://www.acmicpc.net/problem/2225
 */

public class Ex2225 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		long[][] D = new long[K+1][N+1];
		for (int i = 0; i <= K; i++) {
			for (int j = 0; j <= N; j++) {
				if (i == 0) {
					D[i][j] = 0;
					continue;
				}
				if (j == 0) {
					D[i][j] = 1;
					continue;
				}
				D[i][j] = (D[i][j-1] + D[i-1][j]) % 1000000000;
			}
		}
		
		System.out.println(D[K][N]);
	}
}
