package algorithm.baekjoon.dynamic;

import java.util.Scanner;

/**
 * @author Seran
 * [일차원 배열]
 * [식세우기]
 * [차례대로 최소값을 구해가면서 현재값을 더해가는 형식]
 */


public class Ex2579 {

	public static void main(String[] args) {
		/**
		 * 최대값으로 계단 오르기
		 * 계단을 올라 올 수 있는 방법은 한칸 혹은 두칸이다
		 * - 처음 시작만 계단을 연속으로 두 번 오를 수 있음
		 * - 첫번째, 두번째, 세번째 까지는 구해봐야함
		 */
		
		Scanner sc = new Scanner(System.in);
		int test_case = Integer.parseInt(sc.nextLine());
		
		int[] T = new int[test_case + 1];
		T[0] = 0;
		for(int i=1; i<=test_case; i++) {
			T[i] = Integer.parseInt(sc.nextLine());
		}
		
		/**
		 * 2칸 올라온 경우 : D[n] = D[n-2] + T[n]
		 * 1칸 올라온 경우 : D[n] = D[n-3] + T[n-1] + T[n]
		 *             - 1칸 올라오기 전 경우는 2칸을 올라온 경우 밖에 없음
		 * D[n] = max(D[n-2], D[n-3] + T[n-1]) + T[n]
		 */
		
		int[] D = new int[test_case + 1];
		D[0] = T[0];
		D[1] = T[1];
		D[2] = T[1] + T[2];
		for(int i=3; i<=test_case; i++) {
			D[i] = Math.max(D[i-2], D[i-3] + T[i-1]) + T[i];
		}
		
		System.out.println(D[test_case]);
	}

}
