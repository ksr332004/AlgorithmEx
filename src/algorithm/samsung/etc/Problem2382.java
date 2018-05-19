package algorithm.samsung.etc;

import java.io.File;
import java.util.Scanner;

/**
 * @author Seran
 * 2382. [모의 SW 역량테스트] 미생물 격리
 */
public class Problem2382 {
	static int N;
	static int M;
	static int[][] map;
	static int[][] bio;
	// 미생물의 현재 상태에 대한 임시 저장소
	static int[][] nextMap;
	// 이동방향 상, 하, 좌, 우
	static int[][] way = {{0, 0}, {-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	static void move(int time) {
		if (time > M) {
			return;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0) {
					continue;
				}
				
				// 미생물 이름
				int p = map[i][j];
				// 이동 방향
				int d = bio[p][1];
				// 다음 이동할 방향
				int x = i + way[d][0];
				int y = j + way[d][1];
				
				if (nextMap[x][y] != 0) {
					if (bio[nextMap[x][y]][0] > bio[p][0]) {
						bio[nextMap[x][y]][0] += bio[p][0];
						bio[p][0] = 0;
						p = nextMap[x][y];
					} else {
						bio[p][0] += bio[nextMap[x][y]][0];
						nextMap[x][y] = p;
					}
				} else {
					nextMap[x][y] = p;
				}
				
				if (x == 0) {
					bio[p][0] = bio[p][0]/2;
					bio[p][1] = 2;
				} else if (x == N-1) {
					bio[p][0] = bio[p][0]/2;
					bio[p][1] = 1;
				} else if (y == 0) {
					bio[p][0] = bio[p][0]/2;
					bio[p][1] = 4;
				} else if (y == N-1) {
					bio[p][0] = bio[p][0]/2;
					bio[p][1] = 3;
				}
				
				if (bio[p][0] == 0) {
					nextMap[x][y] = 0;
				}
			}
		}

		for (int k = 0; k < N; k++) {
			for (int l = 0; l < N; l++) {
				map[k][l] = nextMap[k][l];
				nextMap[k][l] = 0;
			}
		}
		
		move(time + 1);
	}

	public static void main(String[] args) throws Exception {
		String myPath = Problem2382.class.getResource("").getPath();
		File file = new File(myPath + "../input/", "input.txt");
		
		Scanner sc = new Scanner(file);
		
		// 테스트 케이스 개수
		int T = sc.nextInt();
		for (int test_case=1; test_case <= T; test_case++) {
			// 한변의 셀의 개수 N
			N = sc.nextInt();
			// 격리 시간 M
			M = sc.nextInt();
			// 미생물 군집의 개수 K
			int K = sc.nextInt();
			// 미생물 위치 지도 map
			map = new int[N][N];
			// 미생물 정보 저장 (0: 미생물 수 / 1: 이동방향)
			bio = new int[K+1][2];
			for (int i=1; i<=K; i++) {
				map[sc.nextInt()][sc.nextInt()] = i;
				// 미생물 수
				bio[i][0] = sc.nextInt();
				// 이동방향
				bio[i][1] = sc.nextInt();
			}
						
			nextMap = new int[N][N];
			
			move(1);
			
			int answer = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] > 0) {
						answer += bio[map[i][j]][0];
					}
				}
			}
			
			System.out.println("#" + test_case + " " + answer);
		}
	}

}
