package algorithm.samsung.array;

import java.io.File;
import java.util.Scanner;

/**
 * @author Seran
 * 1204. [S/W 문제해결 기본] 1일차 - 최빈수 구하기
 */

public class Problem1204 {

	public static void main(String[] args) throws Exception {
		String myFile = Problem1204.class.getResource("").getPath();
		File file = new File(myFile + "../input/", "input.txt");
		Scanner sc = new Scanner(file);
		
		while(sc.hasNext()) {
			int test_case = sc.nextInt();
			
			int N = 1000;
			int[] scores = new int[101];
			for(int i=0; i<N; i++) {
				scores[sc.nextInt()]++;
			}
			
			int Answer = 0;
			int max = 0;
			for(int i=100; i>=0; i--) {
				if(scores[i] > max) {
					max = scores[i];
					Answer = i;
				}
			}
			
			System.out.println("#" + test_case + " " + Answer);
		}
		
	}

}
