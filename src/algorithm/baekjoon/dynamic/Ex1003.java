package algorithm.baekjoon.dynamic;

import java.util.Scanner;

/**
 * @author Seran
 * [일차원 배열]
 * 앞 뒤 숫자간의 관계를 통한 점화식 도출
 */

public class Ex1003 {
	public static void main(String[] args) {
		/**
		 * 피보나치 수열
		 * 0과 1에 대한 각각의 점화식을 구함
		 * 0 일 때 : Z[n] = Z[n-1] + Z[n-2]
		 * 1 일 때 : O[n] = O[n-1] + O[n-2]
		 * 초기값 
		 * Z[0] = 1 / Z[1] = 0
		 * O[0] = 0 / O[1] = 1
		 */

		int MAX = 41;
		int[] Z = new int[MAX];
		int[] O = new int[MAX];

		Z[0] = 1;
		Z[1] = 0;
		O[0] = 0;
		O[1] = 1;

		for (int i=2; i<MAX; i++) {
			Z[i] = Z[i-1] + Z[i-2];
			O[i] = O[i-1] + O[i-2];
		}

		Scanner sc = new Scanner(System.in);
		// 테스트 케이스
		int T = sc.nextInt();
		for (int i=0; i<T; i++) {
			int N = sc.nextInt();
			System.out.println(Z[N] + " " + O[N]);
		}
	}

}
