package algorithm.samsung.search;

import java.io.File;
import java.util.Scanner;

/**
 * @author Seran
 * 1949. [모의 SW 역량테스트] 등산로 조성
 */
public class Problem1949 {
	static int[][] M;
	static int[][] V;
	static int answer;
	static int len;
	static int[][] dir = {{0,-1}, {-1,0}, {0,1}, {1,0}};

	static void solution(int nowX, int nowY, int K) {
		answer = answer < len ? len : answer;

		for(int i=0; i<dir.length; i++) {
			int nextX = nowX + dir[i][0];
			int nextY = nowY + dir[i][1];

			if(nextX < 0 || nextY < 0 || nextX >= M.length || nextY >= M.length) {
				continue;
			}

			if(V[nextX][nextY] == 1) {
				continue;
			}

			if(M[nowX][nowY] > M[nextX][nextY]) {
				V[nextX][nextY] = 1;
				len++;
				solution(nextX, nextY, K);
				V[nextX][nextY] = 0;
				len--;
			} else if(M[nowX][nowY] > M[nextX][nextY] - K) {
				V[nextX][nextY] = 1;
				M[nextX][nextY]--;
				len++;
				solution(nextX, nextY, 0);
				V[nextX][nextY] = 0;
				M[nextX][nextY]++;
				len--;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		String myFile = Problem1949.class.getResource("").getPath();
		File file = new File(myFile + "../input/", "input.txt");
		Scanner sc = new Scanner(file);
		
		int T = sc.nextInt();
		for(int test_case=1; test_case<=T; test_case++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			M = new int[N][N];
			int max = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					M[i][j] = sc.nextInt();
					if(max < M[i][j]) {
						max = M[i][j];
					}
				}
			}
			
			answer = 0;
			V = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(max == M[i][j]) {
						V[i][j] = 1;
						len++;
						solution(i, j, K);
						V[i][j] = 0;
						len--;
					}
				}
			}
			
			System.out.println("#" + (test_case) + " " + answer);
		}

	}

}
