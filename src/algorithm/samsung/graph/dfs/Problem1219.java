package algorithm.samsung.graph.dfs;

import java.io.File;
import java.util.Scanner;

/**
 * @author Seran
 * 1219. [S/W 문제해결 기본] 4일차 - 길찾기
 */

public class Problem1219 {
	static boolean[] v;
	static int Answer;
	
	public static void dfs(int[][] A, int N, int a) {
		v[a] = true;
		for(int i=0; i<=N; i++) {
			if(A[a][i] == 99) {
				Answer = 1;
				return;
			} else if(A[a][i] == 1 && v[i] == false) {
				dfs(A, N, i);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		String myFile = Problem1219.class.getResource("").getPath();
		File file = new File(myFile + "../input/", "input.txt");
        Scanner sc = new Scanner(file);

        while(sc.hasNext()) {
            int test_case = sc.nextInt();
            Answer = 0;
            int N = 100;
            v = new boolean[N+1];
            int[][] A = new int[N+1][N+1];
            int n = sc.nextInt();
            for(int i=0; i<n; i++) {
            	int a = sc.nextInt();
            	int b = sc.nextInt();
            	if(a == 99 || b == 99) {
            		A[a][b] = 99;
            	} else {
            		A[a][b] = 1;
            	}
            }
            dfs(A, N, 0);
            System.out.println("#" + test_case + " " + Answer);
        }

	}

}
