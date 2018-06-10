package algorithm.baekjoon.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Seran on 2018-06-10.
 * 2751. 수 정렬하기 2
 * https://www.acmicpc.net/problem/2751
 */
public class Ex2751UseArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n ; i++) {
            A[i] = sc.nextInt();
        }

        Arrays.sort(A);

        for (int i = 0; i < n ; i++) {
            System.out.println(A[i]);
        }
    }
}
