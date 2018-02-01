package algorithm.samsung;

import java.io.File;
import java.util.Scanner;

/**
 * @author Seran
 * 1949. [모의 SW 역량테스트] 등산로 조성
 */
public class Problem_1949 {

	public static void main(String[] args) throws Exception {
		String myFile = "C:\\workspace\\AlgorithmEx\\src\\samsungSWExpertAcademy\\input\\";
//		File file = new File(myFile, "problem_1949.txt");
		File file = new File(myFile, "test.txt");
		Scanner sc = new Scanner(file);
		
		int T = sc.nextInt();
		for(int test_case=0; test_case<T; T++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			int[][] M = new int[N][N];
			int max = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					M[i][j] = sc.nextInt();
					if(max < M[i][j]) {
						max = M[i][j];
					}
				}
			}
			
			int Answer = 0;
			int[][] L = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(max == L[i][j]) {
						
					}
				}
			}
			
			System.out.println("#" + (test_case+1) + " ");
		}

	}

}
