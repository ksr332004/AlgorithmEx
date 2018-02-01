package algorithm.baekjoon.dynamic;

import java.util.Scanner;

/**
 * @author Seran
 * [2차원 배열]
 * [2차원 배열 채우기]
 * [차례대로 최소값을 구해가면서 현재값을 더해가는 형식]
 */

public class Ex1149 {
	
	public static void main(String[] args) {
		/**
		 * 1. 가장 비용이 작은 값을 선택 -> r, g, b 중 어느 것이 였는지 선택 
		 * 2. r, g, b 값이 겹치지 않는 것 중 가장 작은 비용을 선택
		 */
		
		Scanner sc = new Scanner(System.in);
		int test_case = Integer.parseInt(sc.nextLine());
		
		int RGB[][] = new int[test_case][3];
		for(int i=0; i<test_case; i++) {
			for(int j=0; j<3; j++) {
				RGB[i][j] = Integer.parseInt(sc.next());
			}
		}
		
		/**
		 * - 주어진 RGB값에 대한 이차원 배열 생성
		 * - 최소값을 구할때 마다 값을 저장해 놓는 이차원 배열 생성
		 * 목표 : RGB 각각에 대한 해당값까지의 최소값을 구한다
		 * D[i][0] = min(D[i-1][1], D[i-1][2]) + RGB[i][0]
		 * D[i][1] = min(D[i-1][1], D[i-1][2]) + RGB[i][1]
		 * D[i][2] = min(D[i-1][0], D[i-1][1]) + RGB[i][2]
		 */
		
		int D[] = new int[3];
		D[0] = RGB[0][0];
		D[1] = RGB[0][1];
		D[2] = RGB[0][2];
		for(int i=1; i<test_case; i++) {
			int T[] = new int[3];
			T[0] = D[0];
			T[1] = D[1];
			T[2] = D[2];
			D[0] = Math.min(T[1], T[2]) + RGB[i][0];
			D[1] = Math.min(T[0], T[2]) + RGB[i][1];
			D[2] = Math.min(T[0], T[1]) + RGB[i][2];
		}
		System.out.println(Math.min(Math.min(D[0], D[1]), D[2]));
		
	}

}