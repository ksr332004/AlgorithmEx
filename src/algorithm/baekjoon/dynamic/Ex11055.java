package algorithm.baekjoon.dynamic;

import java.util.*;

/**
 * @author Seran
 * https://www.acmicpc.net/problem/11055
 * 11055. 가장 큰 증가 부분 수열
 */
public class Ex11055 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 배열 A의 크기
		int N = sc.nextInt();
		// 배열 A의 값
		int[] A = new int[N];
		for(int i=0; i<N; i++) {
			A[i] = sc.nextInt();
		}

		// n번째 값을 포함 하면서 최대값을 갖는 배열 D
		int[] D = new int[N];
		D[0] = A[0];
		for (int i=1; i<N; i++) {
			// i번째 값보다 작으면서 최대값을 갖는 D의 값 찾기
			for (int j=i-1; j>=0; j--) {
				if (A[i] > A[j]) {
					D[i] = Math.max(D[i], D[j]);
				}
			}
			D[i] += A[i];
		}

		// 배열 D 중 최대 값는 갖는 것을 출력
		Arrays.sort(D);
		System.out.println(D[N-1]);
	}

}
