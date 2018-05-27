package algorithm.baekjoon.dynamic;

import java.util.Scanner;

/**
 * Created by Seran on 2018-05-27.
 * 11726. 2×n 타일링
 * https://www.acmicpc.net/problem/11726
 * 주어진 수가 배열에 저장되지 않을 정도로 커지기 때문에
 * 중간에 10007로 % 연산을 해줘야하고
 * 연산량이 많은 연산들은 배열의 사이즈를 지정해줘야 한다
 */
public class Ex11726 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] D = new int[1001];

        D[1] = 1;
        D[2] = 2;
        for (int i=3; i<=n; i++) {
            D[i] = (D[i-1] + D[i-2])%10007;
        }

        System.out.println(D[n]);
    }
}