package algorithm.samsung.array;

import java.io.File;
import java.util.Scanner;

/**
 * @author Seran
 * 1954. 달팽이 숫자
 */

public class Problem1954 {

	public static void main(String[] args) throws Exception {
		String myFile = Problem1954.class.getResource("").getPath();
		File file = new File(myFile + "../input/", "input.txt");
		Scanner sc = new Scanner(file);
		
		int T = sc.nextInt();
		for(int test_case=0; test_case<T; test_case++) {
			System.out.println("#" + (test_case+1));
			
			int N = sc.nextInt();
			int[][] S = new int[N][N];
			int n = N-1;
			int p = 1;
			for(int i=0; i<((N/2)+0.5); i++) {
				for(int j=i; j<=n; j++) {
					if(S[i][j] != 0) {
						break;
					}
					S[i][j] = p++;
				}
				for(int j=i+1; j<=n; j++) {
					if(S[j][n] != 0) {
						break;
					}
					S[j][n] = p++;
				}
				for(int j=n-1; j>=0; j--) {
					if(S[n][j] != 0) {
						break;
					}
					S[n][j] = p++;
				}
				for(int j=n-1; j>0; j--) {
					if(S[j][i] != 0) {
						break;
					}
					S[j][i] = p++;
				}
				n--;
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					System.out.print(S[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

}
