package algorithm.baekjoon.dynamic;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Seran
 * https://www.acmicpc.net/problem/11055
 * 11055. 가장 큰 증가 부분 수열
 */
public class Ex11055 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();  // 배열 A의 크기
		
		int[] A = new int[N];  // 배열 A의 값
		for(int i=0; i<N; i++) {
			A[i] = sc.nextInt();
		}
		
		int[] D = new int[N];
		D[0] = A[0];
		for(int i=1; i<N; i++) {
			D[i] = A[i];
			for(int j=0; j<i; j++) {
				if(A[i] > A[j]) {
					D[i] = Math.max(D[j] + A[i], D[i]);
				}
			}
		}
		
		Arrays.sort(D);
		
		System.out.println(D[N-1]);
	}

}