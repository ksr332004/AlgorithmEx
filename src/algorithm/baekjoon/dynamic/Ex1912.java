package algorithm.baekjoon.dynamic;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Seran on 2018-04-07.
 * 1912. 연속합
 * https://www.acmicpc.net/problem/1912
 */
public class Ex1912 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // n개의 정수
        int n = sc.nextInt();
        // 임의의 수열
        int[] A = new int[n];
        for (int i=0; i<n; i++) {
            A[i] = sc.nextInt();
        }

        // n번째까지 연속된 숫자의 합을 저장하는 배열 D
        int[] D = new int[n];
        D[0] = A[0];
        for (int i=1; i<n; i++) {
            // 이전 값이 음수면 해당 위치의 값부터 다시 더해감
            if (D[i-1] < 0) {
                D[i] = A[i];
                continue;
            }
            D[i] = D[i-1] + A[i];
        }

        // 배열 D 중 가장 큰 값 출력
        Arrays.sort(D);
        System.out.println(D[n-1]);
    }
}
