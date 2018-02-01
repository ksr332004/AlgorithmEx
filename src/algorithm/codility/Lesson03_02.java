package algorithm.codility;

import java.util.Scanner;

/**
 * Created by Administrator on 2017-10-24.
 */
public class Lesson03_02 {
    public static int solution(int[] A) {
        int Answer = 0;
        int t1 = 0;
        int t2 = 0;
        for(int i=0; i<A.length; i++) {
            t2 += A[i];
        }
        for(int i=0; i<A.length-1; i++) {
            t1 += A[i];
            t2 -= A[i];
            if(i == 0) {
                Answer = Math.abs(t1-t2);
            }
            if(Answer > Math.abs(t1-t2)) {
                Answer = Math.abs(t1-t2);
            }
        }
        return Answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for(int i=0; i<A.length; i++) {
            A[i] = sc.nextInt();
        }

        System.out.println(solution(A));
    }
}
