package algorithm.baekjoon.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex7576 {
	
	static void printArray(int T[][], int w, int h) {
		for(int i=1; i<=h; i++) {
			for(int j=1; j<=w; j++) {
				System.out.print(T[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		/**
		 * 토마토
		 * 박스 안에 토마토가 몇일만에 익을 것인가?
		 * 익은 토마토를 기준으로 양옆, 위아래만 토마토가 익는다
		 * 익은 토마토 1, 안익은 토마토 0, 빈자리 -1
		 */
		
		Scanner sc = new Scanner(System.in);
		int w = Integer.parseInt(sc.next());
		int h = Integer.parseInt(sc.next());
		
		Queue<Integer> qx = new LinkedList<Integer>();
		Queue<Integer> qy = new LinkedList<Integer>();
		Queue<Integer> qLevel = new LinkedList<Integer>();
		
		boolean flag = true;
		
		int[][] T = new int[h+1][w+1];
		for(int i=1; i<=h; i++) {
			for(int j=1; j<=w; j++) {
				int a = Integer.parseInt(sc.next());
				if(a == 1) {
					qx.offer(i);
					qy.offer(j);
					qLevel.offer(1);
				} else if(a == 0) {
					flag = flag && false;
				}
				T[i][j] = a;
			}
		}
//		printArray(T, w, h);
		
		/**
		 * BFS
		 * 1. 큐에 자신의 위치를 넣어 주고 위치가 확정되면 다른 저장소로 옮겨주면서 큐에 있는 값을 빼준다.
		 * 2. 자신이 움직이 일 수 있는 위치 값을 큐에 넣어준다.
		 * 3. 1번과 2번을 반복한다.
		 * 4. 큐에 더 이상 값이 남아 있지 않게 되면 탐색을 종료한다.
		 * 5. 전체 2차원 배열에 대한 탐색을 하여 혹시 익지 않은 토마토가 있는지 확인한다.
		 */
		int day = 1;
		if(!flag) {
			while(!qx.isEmpty()) {
				boolean isChange = false;
				while(qLevel.peek() != null && qLevel.peek() == day) {
					int x = qx.poll();
					int y = qy.poll();
					qLevel.poll();
					int tx[] = {-1, 0, 0, 1};
					int ty[] = {0, -1, 1, 0};
					for(int i=0; i<4; i++) {
						if((x+tx[i]) < 1 || (x+tx[i]) > h || (y+ty[i]) < 1 || (y+ty[i]) > w) {
							continue;
						}
						if(T[x+tx[i]][y+ty[i]] == 0) {
							T[x+tx[i]][y+ty[i]] = 1;
							qx.offer(x+tx[i]);
							qy.offer(y+ty[i]);
							
							qLevel.offer(day+1);
							isChange = true;
						}
					}
				}
				if(isChange) {
					day++;
				} else {
					break;
				}
				
//				printArray(T, w, h);
//				System.out.println("Day : " + day);
			}
			
			day--;
			
			for(int i=1; i<=h; i++) {
				for(int j=1; j<=w; j++) {
					if(T[i][j] == 0) {
						day = -1;
						break;
					}
				}
			}
			System.out.println(day);
		} else {
			System.out.println(0);
		}
		
		
	}

}

