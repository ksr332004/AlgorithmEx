package algorithm.samsung;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Seran
 * 2115. [모의 SW 역량테스트] 벌꿀채취
 */
public class Problem_2115 {

	public static void main(String[] args) throws Exception {
		String myFile = "C:\\workspace\\AlgorithmEx\\src\\samsungSWExpertAcademy\\input\\";
		File file = new File(myFile, "week02_01_2115.txt");
//		File file = new File(myFile, "test.txt");
		
		Scanner sc = new Scanner(file);
		
		int T = sc.nextInt();
		for(int test_case=0; test_case<T; test_case++) {
			int N = sc.nextInt(); // 벌통의 크기
			int M = sc.nextInt(); // 벌통의 개수
			int C = sc.nextInt(); // 채취할 수 있는 꿀의 최대 양
			
			int[][] H = new int[N][N]; // 벌통 안에 있는 각각의 꿀의 양
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					H[i][j] = sc.nextInt();
				}
			}
			
			// 각 위치에서 최대의 이득을 취할 수 있는 값을 구함
			int[][] D = new int[N][N];
			int max1 = 0;
			int x1 = 0;
			int y1 = 0;
			for(int i=0; i<N; i++) {
				for(int j=M-1; j<N; j++) {
					int[] temps = new int[M];
					for(int k=M; k>0; k--) {
						temps[M-k] = H[i][j-k+1];
					}
					
					// M 범위에 해당되는 값을 sort 
					Arrays.sort(temps);
					
					// M 범위내에 조합될 수 있는 가능 경우의 값을 구함
					int sumMax = 0;
					int sumTemp = 0;
					for(int z=M-1; z>=0; z--) {
						int c = C;
						int v = z;
						while(v >= 0) {
							if(c >= temps[v]) {
								sumTemp += (temps[v] * temps[v]);
								c -= temps[v];
							}
							v--;
						}
						if(sumMax < sumTemp) {
							sumMax = sumTemp;
						}
						sumTemp = 0;
					}

					D[i][j] = sumMax;
					
					if(max1 < D[i][j]) {
						max1 = D[i][j];
						x1 = i;
						y1 = j;
					}
				}
			}
			
			// 1번째 큰 값을 초기화
			D[x1][y1] = -1;
			
			// 2번째 큰 값을 찾음
			int max2 = 0;
			for(int i=0; i<N; i++) {
				for(int j=M-1; j<N; j++) {
					if(i == x1) {
						if((y1-(N-1)) <= j && j <= (y1+(N-1))) {
							continue;
						}
					}
					if(max2 < D[i][j]) {
						max2 = D[i][j];
					}
				}
			}
			
			System.out.println("#" + (test_case+1) + " " + (max1 + max2));
		}

	}

}
