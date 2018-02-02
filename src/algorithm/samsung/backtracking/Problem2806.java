package algorithm.samsung.backtracking;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Administrator on 2018-01-18.
 * 2806. N-Queen
 */
public class Problem2806 {
    static int count = 0;

    private static boolean isPromising(int level, int[] col) {
        for(int i=0; i<col.length; i++) {
            if(i == level) {
                return true;
            }

            if(col[i] == col[level]) {
                return false;
            } else if(col[i]-(level-i) == col[level]) {
                return false;
            } else if(col[i]+(level-i) == col[level]) {
                return false;
            }
        }
        return true;
    }

    private static void backtracking(int level, int[] col) {
        if(level == col.length) {
            count++;
        } else {
            for(int i=0; i<col.length; i++) {
                col[level] = i;
                if(isPromising(level, col)) {
                    backtracking(level+1, col);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        String myFile = Problem2806.class.getResource("").getPath();
        File file = new File(myFile + "../input/", "input.txt");

        Scanner sc = new Scanner(file);

        int T = sc.nextInt();
        for(int test_case=1; test_case<=T; test_case++) {
            count = 0;

            int N = sc.nextInt();
            int[] col = new int[N];
            Arrays.fill(col, -1);

            backtracking(0, col);

            System.out.println("#" + test_case + " " + count);
        }
    }
}
