package algorithm.codility;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Administrator on 2017-11-16.
 */
public class Test01 {
    public static int solution(int[] A) {
        int Answer = 0;
        int n = A.length;
        Integer[] B = new Integer[n - 1];

        Arrays.sort(A);

        for(int i=1; i<n; i++) {
            B[i-1] = Math.abs(A[i] - A[i-1]);
        }

        Answer = Collections.min(Arrays.asList(B));

        return Answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];

        for(int i=0; i<n; i++) {
            A[i] = sc.nextInt();
        }

        System.out.println(solution(A));
    }
}
