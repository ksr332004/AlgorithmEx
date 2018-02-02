package algorithm.samsung.array;

import java.io.File;
import java.util.Scanner;

/**
 * @author Seran
 * 1211. [S/W 문제해결 기본] 2일차 - Ladder2
 */

public class Problem1211 {

	public static void main(String[] args) throws Exception {
		String myFile = Problem1211.class.getResource("").getPath();
		File file = new File(myFile + "../input/", "input.txt");
		Scanner sc = new Scanner(file);

		while(sc.hasNext()) {
			int test_case = sc.nextInt();
			int N = 100;
			int[][] L = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					L[i][j] = sc.nextInt();
				}
			}
			
			int Answer = 0;
			
			int min = 10001;
			int[] dx = {0, 0, 1};
			int[] dy = {-1, 1, 0};
			
			for(int t=0; t<N; t++) {
				int[][] D = new int[N][N];
				for(int z=0; z<N; z++) {
					for(int x=0; x<N; x++) {
						D[z][x] = L[z][x];
					}
				}
				int i = 0;
				int j = t;
				if(L[i][t] == 1) {
					int temp = 0;
					D[i][t] = 3;
					temp++;
					while(i < N-1) {
						for(int k=0; k<3; k++) {
							if((i+dx[k]) < 0 || (j+dy[k]) < 0 || (i+dx[k]) > N-1 || (j+dy[k]) > N-1) {
								continue;
							}
							if(D[i+dx[k]][j+dy[k]] == 1) {
								D[i+dx[k]][j+dy[k]] = 3;
								temp++;
								i = i+dx[k];
								j = j+dy[k];
								break;
							}
						}
					}
					if(min >= temp) {
						min = temp;
						Answer = t;
					}
				}
			}
			
			System.out.println("#" + test_case + " " + Answer);
		}
	}

}
