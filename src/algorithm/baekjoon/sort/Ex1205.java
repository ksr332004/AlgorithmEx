package algorithm.baekjoon.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Administrator on 2017-09-11.
 * https://www.acmicpc.net/problem/1205
 * [등수 구하기]
 *
 * (해결)
 *
 * (문제점)
 * 1. 문제를 잘못이해, 100 90 90 80 일때 80을 3으로 계산
 * 2. 3  30 4
 *    40 30 30  이러한 테스트 케이스 통과하지 못함
 * 3. me 값을 먼저 배열에 넣고 정렬 시킨 후 P 범위 내의 가장 작은 값과 비교를 하니 예외 발생
 * 4. 문제를 잘못이해, 조건에 이미 역순으로 정렬이 되어 있음
 */
public class Ex1205 {
    static int solution(int[] scores, int me, int size) {
        int answer = 1;

        Arrays.sort(scores);

        if(scores.length > size && scores[scores.length - size] >= me) {
            answer = -1;
            return answer;
        }
        scores[0] = me;
        Arrays.sort(scores);

        if(scores.length < size) {
            size = scores.length;
        }

        if(scores[scores.length-1] == me) {
            answer = 1;
        } else {
            int loop = 0;
            for(int i=2; i<=size; i++) {
                if(scores[scores.length-i] != scores[scores.length-i+1]) {
                    answer = answer + 1 + loop;
                    loop = 0;
                } else {
                    loop++;
                }
                if(scores[scores.length-i] == me) {
                    answer = answer + loop;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int me = sc.nextInt();
        int size = sc.nextInt();

        int[] scores = new int[n+1];
        for(int i=0; i<n; i++) {
            scores[i] = sc.nextInt();
        }

        System.out.println(solution(scores, me, size));
    }
}
