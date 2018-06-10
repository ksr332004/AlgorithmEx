package algorithm.baekjoon.string;

import java.util.Scanner;

/**
 * Created by Seran on 2018-06-11.
 * 10808. 알파벳 개수
 * https://www.acmicpc.net/problem/10808
 */
public class Ex10808 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        int[] A = new int[26];
        for (int i = 0; i < s.length() ; i++) {
            A[(int)s.charAt(i)-97]++;
        }

        for (int i = 0; i < A.length ; i++) {
            System.out.print(A[i] + " ");
        }
    }
}
