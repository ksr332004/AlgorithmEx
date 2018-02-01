package algorithm.samsung;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Seran
 * 1208. [S/W 문제해결 기본] 1일차 - Flatten
 */

public class Problem_1208 {

	public static void main(String[] args) throws Exception {
		String myFile = "C:\\workspace\\AlgorithmEx\\src\\samsungSWExpertAcademy\\input\\";
		File file = new File(myFile, "problem_1208.txt");
		Scanner sc = new Scanner(file);
		
		int T = 10;
		for(int test_case=0; test_case<T; test_case++) {
			int N = 100;
			int D = sc.nextInt();
			
			int[] boxs = new int[N];
			for(int i=0; i<N; i++) {
				boxs[i] = sc.nextInt();
			}
			
			for(int i=0; i<D; i++) {
				Arrays.sort(boxs);
				boxs[N-1]--;
				boxs[0]++;
			}
			
			Arrays.sort(boxs);
			
			int Answer = boxs[N-1] - boxs[0];
			
			System.out.println("#" + (test_case+1) + " " + Answer);
		}
		
	}

}
