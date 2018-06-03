package algorithm.baekjoon.dynamic;

import java.util.Scanner;

/**
 * Created by Seran on 2018-06-03.
 * 2579. 계단 오르기
 * https://www.acmicpc.net/problem/2579
 */

public class Ex2579 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < N ; i++) {
			A[i] = sc.nextInt();
		}
		long[] D = new long[N];
		D[0] = A[0];
		D[1] = A[0] + A[1];
		D[2] = Math.max(A[0], A[1]) + A[2];
		for (int i = 3; i < N ; i++) {
			D[i] = Math.max(D[i-3] + A[i-1], D[i-2]) + A[i];
		}

		System.out.println(D[N-1]);
	}

}
