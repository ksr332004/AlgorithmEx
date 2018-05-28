package algorithm.baekjoon.dynamic;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Administrator
 * 2156. 포도주 시식
 * https://www.acmicpc.net/problem/2156
 */

public class Ex2156 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] A = new int[10001];
		for (int i = 1; i <= n; i++) {
			A[i] = sc.nextInt();
		}
		
		long[] D = new long[10001];
		D[1] = A[1];
		D[2] = A[1] + A[2];
		for (int i = 3; i <= n; i++) {
			D[i] = Math.max(D[i-1], Math.max(D[i-2], A[i-1] + D[i-3]) + A[i]);
		}
		
		Arrays.sort(D);
		
		System.out.println(D[D.length-1]);
	}

}
