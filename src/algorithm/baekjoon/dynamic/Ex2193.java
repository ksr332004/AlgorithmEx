package algorithm.baekjoon.dynamic;

import java.util.Scanner;

/**
 * @author Administrator
 * 2193. 이친수
 * https://www.acmicpc.net/problem/2193
 */

public class Ex2193 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] D = new long[91];
		D[1] = 1;
		D[2] = 1;
		for (int i = 3; i <= n; i++) {
			D[i] = D[i-1] + D[i-2];
		}
		
		System.out.println(D[n]);
	}

}
