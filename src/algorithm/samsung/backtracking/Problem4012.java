package algorithm.samsung.backtracking;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Seran
 * 4012. [모의 SW 역량테스트] 요리사
 */

public class Problem4012 {
	static int[][] S;
	static int min;
	
	static int sum(Boolean[] C) {
		int a = 0;
		int b = 0;
		for (int i = 0; i < C.length; i++) {
			for (int j = 0; j < C.length; j++) {
				if (i == j) {
					continue;
				}				
				if (C[i] && C[j]) {
					a += S[i][j];
				}
				if (!C[i] && !C[j]) {
					b += S[i][j];
				}
			}
		}
		
		int s = Math.abs(a-b);
		return s;
	}
	
	static void make(Boolean[] C, int N, int count, int food) {
		
		if (count == N) {
			int s = sum(C);
			if (min == -1 || min > s) {
				min = s;
			}
			return;
		}
		
		if (food > 0) {
			C[count] = true;
			make(C, N, count+1, food-1);
			C[count] = false;
		}
		make(C, N, count+1, food);
	}

	public static void main(String[] args) throws Exception {
		String myFile = Problem4012.class.getResource("").getPath();
		File file = new File(myFile + "../input/", "input.txt");
		
		Scanner sc = new Scanner(file);
		
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			// 식재료 배열 사이즈
			int N = sc.nextInt();
			// 식재료 정보
			S = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					S[i][j] = sc.nextInt();
				}
			}
			
			Boolean[] C = new Boolean[N];
			Arrays.fill(C, false);
			
			min = -1;
			
			make(C, N, 0, N/2);
			
			System.out.println("#" + test_case + " " + min);
		}
	}

}
