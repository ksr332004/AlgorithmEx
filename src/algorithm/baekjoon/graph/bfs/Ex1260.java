package algorithm.baekjoon.graph.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex1260 {

	public static void main(String[] args) {
		/**
		 * BFS : 넓이 우선 탐색
		 * 방문할 수 있는 정점 에 대한 탐색
		 * 양방향 간선
		 */
		
		Scanner sc = new Scanner(System.in);
		int v = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());
		int s = Integer.parseInt(sc.next());
		
		int[][] G = new int[v+1][v+1];
		for(int i=1; i<=v; i++) {
			Arrays.fill(G[i], 0);
		}
		for(int i=1; i<=m; i++) {
			int a = Integer.parseInt(sc.next());
			int b = Integer.parseInt(sc.next());
			G[a][b] = 1;
			G[b][a] = 1;
		}
		
		Queue<Integer> R = new LinkedList<Integer>();
		Queue<Integer> Q = new LinkedList<Integer>();
		
		Q.offer(s);
		
		while(!Q.isEmpty()) {
			for(int i=1; i<=v; i++) {
				if(G[Q.peek()][i] == 1 && Q.contains(i) == false) {
					if(!R.contains(i)) {
						Q.offer(i);
					}
				}
			}
			R.offer(Q.peek());
			Q.poll();
		}
		
		while(!R.isEmpty()) {
			System.out.print(R.poll() + " ");
		}
	}

}
