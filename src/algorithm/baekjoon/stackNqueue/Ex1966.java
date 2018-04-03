package algorithm.baekjoon.stackNqueue;

import java.util.*;

/**
 * Created by Administrator on 2018-03-30.
 * https://www.acmicpc.net/problem/1966
 * 1966. 프린터 큐
 */
public class Ex1966 {

    // 문서에 대한 정보 클래스
    static class Document {
        int name;        // 문서 이름
        int importance;  // 문서 중요도

        public Document(int name, int importance) {
            this.name = name;
            this.importance = importance;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        // 테스트 케이스
        int testCase = sc.nextInt();

        for (int i=0; i<testCase; i++) {
            // 문서의 수
            int N = sc.nextInt();
            // 몇 번째로 인쇄되었는지 궁금한 문서위치 (위치의 시작점은 0부터 시작)
            int M = sc.nextInt();
            // 문서가 출력되어야 할 순서를 갖는 배열
            Integer[] A = new Integer[N];
            // 현재 Queue에 있는 문서의 중요도
            Queue<Document> queue = new LinkedList<Document>();

            for (int j=0; j<N; j++) {
                A[j] = sc.nextInt();
                queue.offer(new Document(j, A[j]));
            }

            // 문서의 중요도 값을 역정렬한 값이 출력될 문서의 순서
            Arrays.sort(A, Collections.reverseOrder());

            // 정답
            int answer = 0;

            int k = 0;
            while (!queue.isEmpty()) {
                // 현재 queue에서 출력될 값이 우리가 구하려고하는 값이라면 while문을 빠져 나감
                if (queue.peek().name == M && queue.peek().importance == A[k]) {
                    answer++;
                    break;
                }

                // 현재 queue에서 poll할 값이 지금 출력될 값인지 비교
                // 출력될 순서의 문서가 아니라면 queue의 맨뒤로 보냄
                if (queue.peek().importance == A[k]) {
                    queue.poll();
                    answer++;
                    k++;
                } else {
                    queue.offer(new Document(queue.peek().name, queue.peek().importance));
                    queue.poll();
                }
            }

            System.out.println(answer);
        }

    }
}