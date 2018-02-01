package algorithm.samsung;

import java.io.File;
import java.util.Scanner;

/**
 * @author Seran
 * 1210. [S/W 문제해결 기본] 2일차 - Ladder1
 */

public class Problem_1210 {

	public static void main(String[] args) throws Exception {
		String myFile = "C:\\workspace\\AlgorithmEx\\src\\samsungSWExpertAcademy\\input\\";
		File file = new File(myFile, "problem_1210.txt");
		Scanner sc = new Scanner(file);
		
		while(sc.hasNext()) {
			int test_case = sc.nextInt();
			int N = 100;
			int[][] L = new int[N][N];
			for(int i=N-1; i>=0; i--) {
				for(int j=0; j<N; j++) {
					L[i][j] = sc.nextInt();
				}
			}
			
			int Answer = 0;
			int[] dx = {0, 0, 1};
			int[] dy = {-1, 1, 0};
			int i=0;
			for(int j=0; j<N; j++) {
				if(L[i][j] == 2) {
					L[i][j] = 3;
					while(i != N-1) {
						for(int k=0; k<3; k++) {
							if((i+dx[k]) < 0 || (j+dy[k]) < 0 || (i+dx[k]) > N-1 || (j+dy[k]) > N-1) {
								continue;
							}
							if(L[i+dx[k]][j+dy[k]] == 1) {
								L[i+dx[k]][j+dy[k]] = 3;
								i = i+dx[k];
								j = j+dy[k];
								break;
							}
						}
					}
					Answer = j;
					break;
				}
			}
			
			System.out.println("#" + test_case + " " + Answer);
		}
		
	}

}
