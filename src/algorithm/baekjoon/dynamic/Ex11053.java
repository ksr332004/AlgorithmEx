package algorithm.baekjoon.dynamic;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Administrator
 * 11053. 가장 긴 증가하는 부분 수열
 * https://www.acmicpc.net/problem/11053
 */

public class Ex11053 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] A = new int[1001];
		for (int i = 0; i < n; i++) {
			A[i] = sc.nextInt();
		}
		
		int[] D = new int[1001];
		D[0] = 1;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (A[j] < A[i]) {
					D[i] = Math.max(D[i], D[j]);
				}
			}
			D[i] += 1;
		}
		
		Arrays.sort(D);
		
		System.out.println(D[D.length-1]);
	}

}
