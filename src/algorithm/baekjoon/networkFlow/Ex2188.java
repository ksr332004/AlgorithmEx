package algorithm.baekjoon.networkFlow;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Seran on 2017-12-17.
 */
public class Ex2188 {
    static int N;
    static int M;
    static int[][] map;  // 소가 원하는 축사에 대한 표시
    static boolean[] visited; // dfs의 방문 여부
    static int[] cows;   // 소에 연결된 축사의 번호를 저장
    static int[] cowshed;  // 축사에 연결된 소의 번호를 저장

    // cows의 정점 v에서 cowshed의 매칭되지 않은 정점으로 가는 경로를 찾음
    public static boolean dfs(int v) {
        if(visited[v]) {
          return false;
        }

        visited[v] = true;

        for(int i=1; i<=M; i++) {
            if(map[v][i] == 1) {
                if(cowshed[i] == -1 || dfs(cowshed[i])) {
                    cows[v] = i;
                    cowshed[i] = v;

                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N+1][M+1];

        for(int i=1; i<=N; i++) {
            int c = sc.nextInt();
            for(int j=0; j<c; j++) {
                map[i][sc.nextInt()] = 1;
            }
        }

        cows = new int[N+1];
        cowshed = new int[M+1];

        Arrays.fill(cows, -1);
        Arrays.fill(cowshed, -1);

        int size = 0;

        visited = new boolean[N+1];
        for(int i=1; i<=N; i++) {
            Arrays.fill(visited, false);

            if(dfs(i)) {
                size++;
            }
        }

        System.out.println(size);
    }

}
