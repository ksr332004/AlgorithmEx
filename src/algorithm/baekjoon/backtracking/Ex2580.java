package algorithm.baekjoon.backtracking;

import java.util.Scanner;

/**
 * Created by Administrator on 2017-10-25.
 * [스도쿠]
 * https://www.acmicpc.net/problem/2580
 */
public class Ex2580 {
    static int[][] map;
    static int currentRow, currentCol;

    static boolean checkRow(int r, int n) {
        for(int i=0; i<9; i++) {
            if(map[r][i] == n) {
                return false;
            }
        }
        return true;
    }

    static boolean checkCol(int c, int n) {
        for(int i=0; i<9; i++) {
            if(map[i][c] == n) {
                return false;
            }
        }
        return true;
    }

    static boolean checkBox(int r, int c, int n) {
        for(int i=r/3; i<(r/3)+3; i++) {
            for(int j=c/3; j<(c/3)+3; j++) {
                if(map[i][j] == n) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean isSafe(int n, int r, int c) {
        if(checkRow(r, n) && checkCol(c, n) && checkBox(r, c, n)) {
            return true;
        }
        return false;
    }

    static boolean findEmpty() {
        for(int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (map[i][j] == 0) {
                    currentRow = i;
                    currentCol = j;
                    return false;
                }
            }
        }
        return true;
    }

    static boolean fill() {
        int r = 0;
        int c = 0;

        if (findEmpty()) {
            return true;
        }

        r = currentRow;
        c = currentCol;

        for (int n = 0; n < 9; n++) {
            if (isSafe(n, r, c)) {
                map[r][c] = n;
                if (fill()) {
                    return true;
                }
                // failure
                map[r][c] = 0;
            }
        }
        // backtracking
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        map = new int[9][9];
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        fill();

        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
