package algorithm.baekjoon.graph.dfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex1260 {
	
	static int[][] G;
	static int v;
	static Queue<Integer> R = new LinkedList<Integer>();
	
	static void dfs(int s) {
		R.offer(s);
		for(int i=1; i<=v; i++) {
			if(G[s][i] == 1 && R.contains(i) == false) {
				dfs(i);
			}
		}
	}

	public static void main(String[] args) {
		/**
		 * DFS : 깊이 우선 탐색
		 * 방문할 수 있는 정점 에 대한 탐색
		 */
		
		Scanner sc = new Scanner(System.in);
		v = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());
		int s = Integer.parseInt(sc.next());
		
		G = new int[v+1][v+1];
		for(int i=1; i<=v; i++) {
			Arrays.fill(G[i], 0);
		}
		for(int i=1; i<=m; i++) {
			int a = Integer.parseInt(sc.next());
			int b = Integer.parseInt(sc.next());
			G[a][b] = 1;
			G[b][a] = 1;
		}
		
		dfs(s);
		
		while(!R.isEmpty()) {
			System.out.print(R.poll() + " ");
		}

	}

}
