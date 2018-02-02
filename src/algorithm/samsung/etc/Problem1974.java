package algorithm.samsung.etc;

import java.io.File;
import java.util.Scanner;

/**
 * @author Seran
 * 1974. 스도쿠 검증
 */

public class Problem1974 {

	public static void main(String[] args) throws Exception {
		String myFile = Problem1974.class.getResource("").getPath();
		File file = new File(myFile + "../input/", "input.txt");
		Scanner sc = new Scanner(file);
		
		int T = sc.nextInt();
		for(int test_case=0; test_case<T; test_case++) {
			int N = 9;
			int[][] S = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					S[i][j] = sc.nextInt();
				}
			}
			
			int Answer = 1;
			for(int i=0; i<N; i++) {
				int[] check1 = new int[10]; // 가로
				int[] check2 = new int[10]; // 세로
				for(int j=0; j<N; j++) {
					if(check1[S[i][j]] == 1 || check2[S[j][i]] == 1) {
						Answer = 0;
						break;
					}
					check1[S[i][j]] = 1;
					check2[S[j][i]] = 1;
				}
				if(Answer == 0) {
					break;
				}
			}
			
			if(Answer == 1) {
				for(int i=0; i<N; i=i+3) {
					for(int j=0; j<N; j=j+3) {
						int[] check3 = new int[10]; // 3x3 박스
						for(int x=i; x<i+3; x++) {
							for(int y=j; y<j+3; y++) {
								if(check3[S[x][y]] == 1) {
									Answer = 0;
									break;
								}
								check3[S[x][y]] = 1;
							}
							if(Answer == 0) {
								break;
							}
						}
						if(Answer == 0) {
							break;
						}
					}
					if(Answer == 0) {
						break;
					}
				}
			}
			
			System.out.println("#" + (test_case+1) + " " + Answer);
		}
	}

}
