package algorithm.codility;

import java.util.Scanner;

/**
 * Created by Administrator on 2017-10-24.
 */
public class Lesson03_01 {
    public static int solution(int[] A) {
        int Answer = 0;
        int[] T = new int[A.length+2];
        for(int i=0; i<A.length; i++) {
            T[A[i]] = 1;
        }
        for(int i=1; i<T.length; i++) {
            if(T[i] != 1) {
                Answer = i;
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
