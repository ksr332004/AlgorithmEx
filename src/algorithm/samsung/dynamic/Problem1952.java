package algorithm.samsung.dynamic;

import java.io.File;
import java.util.Scanner;

/**
 * @author Seran
 * 1952. [모의 SW 역량테스트] 수영장
 */
public class Problem1952 {

	public static void main(String[] args) throws Exception {
		String myFile = Problem1952.class.getResource("").getPath();
		File file = new File(myFile + "../input/", "input.txt");
		
		Scanner sc = new Scanner(file);
		
		int T = sc.nextInt();
		for(int test_case=0; test_case<T; test_case++) {
			int day = sc.nextInt();
			int month = sc.nextInt();
			int threeMonth = sc.nextInt();
			int year = sc.nextInt();
			
			int[] myUseDays = new int[12];
			for(int i=0; i<12; i++) {
				myUseDays[i] = sc.nextInt();
			}
			
			// DP 이용
			int[] D = new int[12];
			D[0] = Math.min(myUseDays[0]*day, month);
			D[1] = Math.min(myUseDays[1]*day, month) + D[0];
			D[2] = Math.min(Math.min(myUseDays[2]*day, month) + D[1], threeMonth);
			for(int i=3; i<12; i++) {
				D[i] = Math.min(Math.min(myUseDays[i]*day, month) + D[i-1], threeMonth + D[i-3]);
			}
			
			System.out.println("#" + (test_case+1) + " "  + Math.min(D[11], year));
		}
		
	}

}
