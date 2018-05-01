package algorithm.baekjoon.path;

import java.util.*;

/**
 * Created by Seran on 2018-04-21.
 * 6118. 숨바꼭질
 */
public class Ex6118 {
    static int INF = Integer.MAX_VALUE;
    static ArrayList<Integer>[] V;
    static PriorityQueue<Node> Q;
    static int[][] check;
    static int distance;

    // 우선순위큐를 위한 헛간에 대한 객체
    static class Node implements Comparable<Node> {
        int node;
        int weight;

        public Node (int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node target) {
            if (this.weight < target.weight) {
                return -1;
            } else if (this.weight > target.weight) {
                return 1;
            }
            return 0;
        }
    }

    static void dijkstra(int start) {
        Q.add(new Node(start, 0));
        check[0][start] = 0;
        check[1][start] = 1;

        while (!Q.isEmpty()) {
            int q = Q.poll().node;
            // 인접 경로 최소 거리 값으로 초기화
            for (int v : V[q]) {
                if (check[1][v] != 1) {
                    check[0][v] = Math.min(check[0][v], check[0][q] + 1);
                    distance = Math.max(distance, check[0][v]);

                    check[1][v] = 1;
                    Q.add(new Node(v, check[0][v]));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 헛간의 개수
        int N = sc.nextInt();
        // 헛간의 경로 수
        int M = sc.nextInt();
        // 경로
        V = new ArrayList[N+1];
        for (int i=1; i<=N; i++) {
            V[i] = new ArrayList<Integer>();
        }
        for (int i=0; i<M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            V[x].add(y);
            V[y].add(x);
        }

        // 우선순위 큐를 이용하여 최단거리 노드 구하기
        Q = new PriorityQueue<Node>();
        check = new int[2][N+1];
        Arrays.fill(check[0], INF);
        distance = 0;

        dijkstra(1);

        // 헛간의 번호와 동일 거리에 있는 헛간의 수 구하기
        int shed = 0;
        int count = 0;
        for (int i=1; i<=N; i++) {
            if (check[0][i] == distance) {
                if (shed == 0) {
                    shed = i;
                }
                count++;
            }
        }

        System.out.println(shed + " " + distance + " " + count);
    }
}
