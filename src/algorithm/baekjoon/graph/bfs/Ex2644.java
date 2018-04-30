package algorithm.baekjoon.graph.bfs;

import java.util.*;

/**
 * Created by Administrator on 2018-04-17.
 * 2644. 촌수계산
 */
public class Ex2644 {
    static ArrayList<Integer>[] F;
    static Queue<Integer> Q;
    static int[] visit;
    static int answer;

    static void bfs(int a, int b) {
        Q.add(a);
        visit[a] = 0;

        while (!Q.isEmpty()) {
            int q = Q.poll();
            for (int i : F[q]) {
                // 현재 노드와 촌수가 계산되어야 하는 사람과 같을 경우
                if (i == b) {
                    answer = visit[q] + 1;
                    return;
                }
                // bfs 탐색
                if (visit[i] == -1) {
                    Q.add(i);
                    visit[i] = visit[q] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 전체 사람 수
        int n = sc.nextInt();
        // 촌수를 계산해야 하는 사람
        int a = sc.nextInt();
        int b = sc.nextInt();
        // 부모 자식간의 수
        int m = sc.nextInt();
        // 가족관계도
        F = new ArrayList[n+1];
        for (int i=1; i<=n; i++) {
            F[i] = new ArrayList<Integer>();
        }
        for (int i=0; i<m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            F[x].add(y);
            F[y].add(x);
        }

        // 방문 여부 체크와 현재 노드의 단계를 저장
        visit = new int [n+1];
        Arrays.fill(visit, -1);
        Q = new LinkedList<Integer>();

        answer = -1;

        bfs(a, b);

        System.out.println(answer);
    }
}
