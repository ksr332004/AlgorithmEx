package algorithm.baekjoon.dynamic;

import java.util.Scanner;

/**
 * @author Administrator
 * 9465. 스티커
 * https://www.acmicpc.net/problem/9465
 */

public class Ex9465 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 0; test_case < T; test_case++) {
			
			int n = sc.nextInt();
			int[][] A = new int[2][n];
			for (int i = 0; i < n; i++) {
				A[0][i] = sc.nextInt();
			}
			for (int i = 0; i < n; i++) {
				A[1][i] = sc.nextInt();
			}
			
			int[][] D = new int[2][n];
			D[0][0] = A[0][0];
			D[1][0] = A[1][0];
			D[0][1] = Math.max(A[0][0], A[1][0] + A[0][1]);
			D[1][1] = Math.max(A[1][0], A[0][0] + A[1][1]);
			for (int i = 2; i < n; i++) {
				D[0][i] = Math.max(D[0][i-1], Math.max(A[1][i-1] + D[0][i-2], D[1][i-2]) + A[0][i]);
				D[1][i] = Math.max(D[1][i-1], Math.max(A[0][i-1] + D[1][i-2], D[0][i-2]) + A[1][i]);
			}
			
			System.out.println(Math.max(D[0][n-1], D[1][n-1]));
			
		}
	}

}
