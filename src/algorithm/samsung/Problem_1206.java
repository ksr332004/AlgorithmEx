package algorithm.samsung;

import java.io.File;
import java.util.Scanner;

/**
 * @author Seran
 * 1206. [S/W 문제해결 기본] 1일차 - View
 */

public class Problem_1206 {

	public static void main(String[] args) throws Exception {
		String myFile = "C:\\workspace\\AlgorithmEx\\src\\samsungSWExpertAcademy\\input\\";
		File file = new File(myFile, "problem_1206.txt");
		
		Scanner sc = new Scanner(file);
		
		int T = 10;
		for(int test_case=0; test_case<T; test_case++) {
			int N = sc.nextInt();
			int[] buildings = new int[N];
			for(int i=0; i<N; i++) {
				buildings[i] = sc.nextInt();
			}
			
			int Answer = 0;
			for(int i=2; i<N-2; i++) {
				int a = (buildings[i] - buildings[i-1] > 0) ? buildings[i] - buildings[i-1] : 0;
				int b = (buildings[i] - buildings[i-2] > 0) ? buildings[i] - buildings[i-2] : 0; 
				int c = (buildings[i] - buildings[i+1] > 0) ? buildings[i] - buildings[i+1] : 0; 
				int d = (buildings[i] - buildings[i+2] > 0) ? buildings[i] - buildings[i+2] : 0;
				Answer += Math.min(Math.min(a, b), Math.min(c, d));
			}
			
			System.out.println("#" + (test_case+1) + " " + Answer);
		}

	}

}
