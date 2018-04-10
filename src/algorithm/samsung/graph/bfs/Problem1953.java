package algorithm.samsung.graph.bfs;

import java.io.File;
import java.util.Scanner;

/**
 * @author Seran
 * 1953. [모의 SW 역량테스트] 탈주범 검거
 */

public class Problem1953 {
	static int N;
	static int M;
	static int L;
	static int[][] map;
	static int[][] road;
	// 왼쪽, 위, 오른쪽, 아래
	static int[][] pipX = {
			{0, 0, 0, 0},
			{0, -1, 0, 1},
			{0, -1, 0, 1},
			{0, 0, 0, 0},
			{0, -1, 0, 0},
			{0, 0, 0, 1},
			{0, 0, 0, 1},
			{0, -1, 0, 0}
	};
	static int[][] pipY = {
			{0, 0, 0, 0},
			{-1, 0, 1, 0},
			{0, 0, 0, 0},
			{-1, 0, 1, 0},
			{0, 0, 1, 0},
			{0, 0, 1, 0},
			{-1, 0, 0, 0},
			{-1, 0, 0, 0}
	};
	static int[] turn = {2, 3, 0, 1};

	static void printMap(int[][] road) {
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				System.out.print(road[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	static void searchForThief(int X, int Y, int time) {
//		if (time > L) {
//			return;
//		}

		road[X][Y] = time;
		System.out.println(time);
		printMap(road);

		int pipType = map[X][Y];
		for (int i=0; i<4; i++) {
			int x = X + pipX[pipType][i];
			int y = Y + pipY[pipType][i];

			if (pipX[pipType][i] + pipY[pipType][i] == 0) {
				continue;
			}
			if (x < 0 || x >= N) {
				continue;
			}
			if (y < 0 || y >= M) {
				continue;
			}
			if (road[x][y] != 0) {
				road[x][y] = Math.min(road[x][y], time);
				continue;
			}

			if (x + pipX[map[x][y]][turn[i]] == X && y + pipY[map[x][y]][turn[i]] == Y) {
				searchForThief(x, y, time+1);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		String myFile = Problem1953.class.getResource("").getPath();
		File file = new File(myFile + "../../input", "input.txt");
		
		Scanner sc = new Scanner(file);

		// 테스트 케이스 T
		int T = sc.nextInt();
		for (int test_case=1; test_case<=T; test_case++) {
			// 지하 터널 지도의 세로 N
			N = sc.nextInt();
			// 지하 터널 지도의 가로 M
			M = sc.nextInt();
			// 맨홀 뚜껑의 위치 세로 R
			int R = sc.nextInt();
			// 맨홀 뚜껑의 위치 가로 C
			int C = sc.nextInt();
			// 탈출 후 소요된 시간 L
			L = sc.nextInt();

			// 지하터널 지도 map
			map = new int[N][M];
			for (int i=0; i<N; i++) {
				for (int j=0; j<M; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			// 탈주범의 위치를 저장하는 road
			road = new int[N][M];

			searchForThief(R, C, 1);

			int answer = 0;
			for (int i=0; i<N; i++) {
				for (int j=0; j<M; j++) {
					if (road[i][j] > 0 && road[i][j] <= L) {
						answer++;
					}
				}
			}

			System.out.println("#" + test_case + " " + answer);
		}

	}

}
