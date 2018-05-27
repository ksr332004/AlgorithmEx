package algorithm.baekjoon.dynamic;

import java.util.Scanner;

/**
 * Created by Seran on 2018-05-01.
 * 9095. 1, 2, 3 더하기
 */
public class Ex9095 {
    static int answer;

    static void findSum(int n) {
        if (n == 0) {
            answer++;
            return;
        }

        if (n-1 >= 0) {
            findSum(n-1);
        }
        if (n-2 >= 0) {
            findSum(n-2);
        }
        if (n-3 >= 0) {
            findSum(n-3);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int test_case=1; test_case<=T; test_case++) {
            int n = sc.nextInt();

            answer = 0;

            findSum(n);

            System.out.println(answer);
        }
    }
}
