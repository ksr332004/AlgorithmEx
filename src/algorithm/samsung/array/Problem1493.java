package algorithm.samsung.array;

import java.io.File;
import java.util.Scanner;

/**
 * Created by Administrator on 2018-02-12.
 * 1493. 수의 새로운 연산
 */
public class Problem1493 {
    // 배열의 크기 정하기
    static int N = 300;
    static int M = 100000;
    // 연산을 위한 배열
    static int[][] A = new int[N+1][N+1];
    static int[][] B = new int[2][M+1];

    public static void main(String[] args) throws Exception {
        String myFile = Problem1493.class.getResource("").getPath();
        File file = new File(myFile + "../input/", "input.txt");
        Scanner sc = new Scanner(file);

        // x=1 일때,
        // 초기값 (1,1) = 1
        // (1,1) = 1 = 1
        // #(1,y) = #(1,y-1) + c (c = y-1)
        // (1,2) = 1+1 = 2
        // (1,3) = 2+2 = 4
        // (1,4) = 4+3 = 7
        // (1,5) = 7+4 = 11

        // x=2 이상 일때,
        // #(x,y) = #(x-1,y) + c (c = x+(y-1))
        // (2,1) = 1+2 = 3
        // (2,2) = 2+3 = 5
        // (2,3) = 4+4 = 8
        // (2,4) = 7+5 = 12
        // (2,5) = 11+6 = 17
        // ...
        // (3,1) = 3+3 = 6
        // (3,2) = 5+4 = 9
        // (3,3) = 8+5 = 13
        // (3,4) = 12+6 = 18
        // (3,5) = 17+7 = 24

        // 2차원 배열 값 세팅
        for(int y=1; y<=N; y++) {
            for(int x=1; x<=N; x++) {
                if(y == 1 && x == 1) {
                    A[y][x] = 1;
                }
                else if(x == 1) {
                    A[y][x] = A[y-1][x] + (y-1);
                }
                else {
                    A[y][x] = A[y][x-1] + (x + (y-1));
                }

                if(A[y][x] > M) {
                    break;
                }

                B[0][A[y][x]] = x;
                B[1][A[y][x]] = y;

            }
        }

        int T = sc.nextInt();
        for(int test_case=1; test_case<=T; test_case++) {
            int answer = 0;

            // 연산을 위한 두 수
            int p = sc.nextInt();
            int q = sc.nextInt();

            answer = A[B[1][p]+B[1][q]][B[0][p]+B[0][q]];

            System.out.println("#" + test_case + " " + answer);
        }
    }
}
