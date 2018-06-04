package algorithm.baekjoon.dynamic;

import java.util.Scanner;

/**
 * @author Administrator
 * 11052. 붕어빵 판매하기
 * https://www.acmicpc.net/problem/11052
 */

public class Ex11052 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] P = new int[N+1];
		for (int i = 1; i <= N; i++) {
			P[i] = sc.nextInt();
		}
		
		int[] D = new int[N+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				D[i] = Math.max(P[j] + D[i-j], D[i]);
			}
		}
		
		System.out.println(D[N]);
	}

}
