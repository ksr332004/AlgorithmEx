package algorithm.baekjoon.dynamic;

import java.util.Scanner;

public class Ex10844 {

	public static void main(String[] args) {
		/**
		 * 계단 수 구하기
		 * N자리에 해당하는 계단 수의 개수를 구한다.
		 * 계단 수 : 인접한 수가 +1 혹은 -1 차이가 나도록 이루어진 수
		 */
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		/**
		 * i: N자리
		 * j: 0~9까지의 수
		 * 
		 * D[i][j] = D[i-1][j-1] + D[i-1][j+1]
		 *
		 * - 9 >= i,j >= 0
		 * - D[0][0] = 0
		 */
		
		long[][] D = new long[n+1][10];
		for(int i=0; i<=9; i++) {
			D[1][i] = 1;
		}
		
		if(n > 1) {
			for(int i=2; i<=n; i++) {
				for(int j=0; j<=9; j++) {
					if(j == 0) {
						D[i][j] = D[i-1][j+1];
					} else if(j == 9) {
						D[i][j] = D[i-1][j-1];
					} else {
						D[i][j] = D[i-1][j-1] + D[i-1][j+1] % 1000000000;
					}
				}
			}
		}
		
		long sum = 0;
		for(int i=1; i<10; i++) {
			sum += D[n][i] % 1000000000;
		}
		
		System.out.println(sum % 1000000000);
		
	}

}

