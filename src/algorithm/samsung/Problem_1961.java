package algorithm.samsung;

import java.io.File;
import java.util.Scanner;

/**
 * @author Seran
 * 1961. 숫자 배열 회전
 */

public class Problem_1961 {

	public static void main(String[] args) throws Exception {
		String myFile = "C:\\workspace\\AlgorithmEx\\src\\samsungSWExpertAcademy\\input\\";
		File file = new File(myFile, "problem_1961.txt");
//		File file = new File(myFile, "test.txt");
		Scanner sc = new Scanner(file);
		
		int T = sc.nextInt();
		for(int test_case=0; test_case<T; test_case++) {
			System.out.println("#" + (test_case+1));
			int N = sc.nextInt();
			int[][] A = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					A[i][j] = sc.nextInt();
				}
			}
			
			int[][] D90 = new int[N][N];
			int[][] D180 = new int[N][N];
			int[][] D270 = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					D90[j][N-1-i] = A[i][j];
					D180[N-1-i][N-1-j] = A[i][j];
					D270[N-1-j][i] = A[i][j];
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					System.out.print(D90[i][j]);
				}
				System.out.print(" ");
				for(int j=0; j<N; j++) {
					System.out.print(D180[i][j]);
				}
				System.out.print(" ");
				for(int j=0; j<N; j++) {
					System.out.print(D270[i][j]);
				}
				System.out.println();
			}
			
		}

	}

}
