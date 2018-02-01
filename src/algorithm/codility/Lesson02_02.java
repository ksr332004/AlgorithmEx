package algorithm.codility;

import java.util.Scanner;

/**
 * Created by Seran on 2017-10-23.
 */
public class Lesson02_02 {
    public static int[] solution(int[] A, int K) {
        int[] Answer = new int[A.length];
        for(int i=0; i<A.length; i++) {
            int n = i+K;
            Answer[n%A.length] = A[i];
        }
        return Answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N  = sc.nextInt();
        int K  = sc.nextInt();
        int[] A = new int[N];
        for(int i=0; i<N; i++) {
            A[i] = sc.nextInt();
        }

        int[] T = solution(A, K);
        for(int i=0; i<T.length; i++) {
            System.out.print(T[i] + " ");
        }
    }
}
