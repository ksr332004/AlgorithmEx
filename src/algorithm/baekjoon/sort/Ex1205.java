package algorithm.baekjoon.sort;

import java.util.Scanner;

/**
 * Created by Administrator on 2017-09-11.
 * https://www.acmicpc.net/problem/1205
 * [등수 구하기]
 */
public class Ex1205 {
    static int solution (int[] scores, int me, int size) {
        int n = scores.length;
        // 등수를 현재 랭킹 중 맨 마지막으로 초기화
        int answer = n + 1;

        // 랭킹에 들어 가지 못할 경우
        if (size <= n  && me <= scores[n - 1]) {
            answer = -1;
            return answer;
        }

        // 랭킹 1위일 경우
        if (n == 0 || scores[0] <= me) {
            answer = 1;
            return answer;
        }

        // 그 외
        for (int i=1; i<n; i++) {
            if (me >= scores[i]) {
                answer = i + 1;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int me = sc.nextInt();
        int size = sc.nextInt();

        int[] scores = new int[n];
        for (int i=0; i<n; i++) {
            scores[i] = sc.nextInt();
        }

        System.out.println(solution(scores, me, size));
    }
}
