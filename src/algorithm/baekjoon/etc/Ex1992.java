package algorithm.baekjoon.etc;

import java.util.Scanner;

/**
 * Created by Seran on 2018-04-07.
 * 1992. 쿼드트리
 */
public class Ex1992 {
    static String answer;

    static void divideAndConquer(int[][] A, int x, int y, int n) {
        // 주어진 배열의 수가 0 혹은 1로 이루어 졌는지 판단을 위한 변수 check
        int check = 0;
        for (int i=x; i<x+n; i++) {
            for (int j=y; j<y+n; j++) {
                check += A[i][j];
            }
        }

        if (check == 0) {
            answer += "0";
        } else if (check == n*n) {
            answer += "1";
        } else {
            answer += "(";
            // 상단 왼쪽
            divideAndConquer(A, x, y, n/2);
            // 상단 오른쪽
            divideAndConquer(A, x, y + n/2, n/2);
            // 하단 왼쪽
            divideAndConquer(A, x + n/2, y, n/2);
            // 하단 오른쪽
            divideAndConquer(A, x + n/2, y + n/2, n/2);
            answer += ")";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 영상의 크기 N
        int N = sc.nextInt();
        // 영상의 모양 이차원 배열 A
        int[][] A = new int[N][N];
        for (int i=0; i<N; i++) {
            String s = sc.next();
            for (int j=0; j<N; j++) {
                A[i][j] = s.charAt(j) - 48;
            }
        }

        // 영상을 압축한 결과
        answer = "";

        // 영상을 압축하는 함수
        divideAndConquer(A, 0, 0, N);

        System.out.println(answer);
    }
}
