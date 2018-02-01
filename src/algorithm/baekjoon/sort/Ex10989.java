package algorithm.baekjoon.sort;

import java.util.Scanner;

/**
 * Created by Administrator on 2017-09-11.
 * https://www.acmicpc.net/problem/10989
 * [수 정렬하기 3]
 *
 * (해결)
 *
 */
public class Ex10989 {
    static int solution(int[] numbers, int n) {
        int answer = 0;
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] numbers = new int[n];
        for(int i=0; i<n; i++) {
            numbers[i] = sc.nextInt();
        }

        System.out.println(solution(numbers, n));
    }
}
