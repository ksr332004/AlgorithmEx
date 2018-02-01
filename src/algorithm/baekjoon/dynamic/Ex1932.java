package algorithm.baekjoon.dynamic;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Seran
 * [2차원 배열]
 * [2차원 배열 채우기]
 * [차례대로 최소값을 구해가면서 현재값을 더해가는 형식]
 */


public class Ex1932 {

	public static void main(String[] args) {
		/**
		 * 주어진 삼각형에서 합이 최대가 되는 값을 구하시오.
		 * 단, 경로는 인접한 대각선으로만 욺직일 수 있다.
		 */
		
		Scanner sc = new Scanner(System.in);
		int test_case = Integer.parseInt(sc.nextLine());
		
		int[][] T = new int[test_case][test_case];
		for(int i=0; i<test_case; i++) {
			Arrays.fill(T[i], -1);
		}
		for(int i=0; i<test_case; i++) {
			for(int j=0; j<=i; j++) {
				T[i][j] = Integer.parseInt(sc.next());
			}
		}
		
		/**
		 * D[i][j] = max(D[i-1][j-1], D[i-1][j]) + T[i][j]
		 * j == 1 일 때, D[i][1] = D[i-1][1] + T[i][1]
		 * i == j 일 때, D[i][j] = D[i-1][j-1] + T[i][j]
		 */
		
		int[][] D = new int[test_case][test_case];
		for(int i=0; i<test_case; i++) {
			Arrays.fill(D[i], -1);
		}
		D[0][0] = T[0][0];
		for(int i=1; i<test_case; i++) {
			for(int j=0; j<=i; j++) {
				if(j == 0) {
					D[i][j] = D[i-1][j] + T[i][j];
				} else if(i == j) {
					D[i][j] = D[i-1][j-1] + T[i][j];
				} else {
					D[i][j] = Math.max(D[i-1][j-1], D[i-1][j]) + T[i][j];
				}
			}
		}
		Arrays.sort(D[test_case-1]);
		
		System.out.println(D[test_case-1][test_case-1]);
		
	}

}
