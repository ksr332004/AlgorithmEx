package algorithm.samsung.array;

import java.io.File;
import java.util.Scanner;

/**
 * @author Seran
 * 1209. [S/W 문제해결 기본] 2일차 - Sum
 */

public class Problem1209 {

	public static void main(String[] args) throws Exception {
		String myFile = Problem1209.class.getResource("").getPath();
		File file = new File(myFile + "../input/", "input.txt");
		Scanner sc = new Scanner(file);
		
		while(sc.hasNext()) {
			int test_case = sc.nextInt();
			int N = 100;
			int[][] A = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					A[i][j] = sc.nextInt();
				}
			}
			
			int max1 = 0;
			int max2 = 0;
			int max3 = 0;
			int max4 = 0;
			for(int i=0; i<N; i++) {
				int temp1 = 0;
				int temp2 = 0;
				for(int j=0; j<N; j++) {
					temp1 += A[i][j]; // 가로
					temp2 += A[j][i]; // 세로
				}
				
				if(max1 < temp1) {
					max1 = temp1;
				}
				if(max2 < temp2) {
					max2 = temp2;
				}
				
				max3 += A[i][i]; // 왼쪽 위에서 오른쪽 아래 대각선
				max4 += A[i][N-1-i]; // 오른쪽 위에서 왼쪽 아래 대각선
			}

			int Answer = 0;
			Answer = Math.max(Math.max(max1, max2), Math.max(max3, max4));
			
			System.out.println("#" + test_case + " " + Answer);
		}
	}

}
