package algorithm.baekjoon.graph.dfs;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Administrator on 2018-04-17.
 * 2668. 숫자고르기
 */
public class Ex2668 {
    static int[] A;
    static Boolean[] V;
    static Boolean[] C;
    static int endValue;
    static int sum;

    static void dfs(int startValue) {
        if (A[startValue] == endValue) {
            C[startValue] = true;
            sum++;
            return;
        }

        if (!V[startValue]) {
            V[startValue] = true;
            dfs(A[startValue]);
            V[startValue] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 주어지는 수의 개수
        int N = sc.nextInt();

        // 저장되는 숫자 배열
        A = new int[N+1];
        for (int i=1; i<=N; i++) {
            A[i] = sc.nextInt();
        }

        V = new Boolean[N+1];
        Arrays.fill(V, false);
        C = new Boolean[N+1];
        Arrays.fill(C, false);

        for (int i=1; i<=N; i++) {
            endValue = i;
            dfs(i);
        }

        System.out.println(sum);

        for (int i=1; i<=N; i++) {
            if (C[i]) {
                System.out.println(i);
            }
        }
    }
}