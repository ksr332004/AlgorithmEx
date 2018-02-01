package algorithm.codility;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Administrator on 2017-11-16.
 */
public class Test02 {
    public static int solution(int[] A, int[] B, int M, int X, int Y) {
        int Answer = 0;
        int n = A.length;
        int weight = 0;
        int capacity = 0;
        Stack<Integer> S = new Stack<Integer>();

        int i = 0;
        while(i<n) {
            if((capacity + 1 <= X) && (weight + A[i] <= Y)) {
                S.push(B[i]);
                capacity++;
                weight += A[i];
                i++;
            } else {
                Answer++;
                while(S.size() != 0) {
                    int beforeValue = S.pop();
                    if((S.size() != 0) && (beforeValue != S.peek())) {
                        Answer++;
                    }
                }
                weight = 0;
                capacity = 0;
                Answer++;
            }
        }

        Answer++;
        while(S.size() != 0) {
            int beforeValue = S.pop();
            if((S.size() != 0) && (beforeValue != S.peek())) {
                Answer++;
            }
        }
        Answer++;

        return Answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        int[] B = new int[n];

        for(int i=0; i<n; i++) {
            A[i] = sc.nextInt();
        }

        for(int i=0; i<n; i++) {
            B[i] = sc.nextInt();
        }

        int M = sc.nextInt();
        int X = sc.nextInt();
        int Y = sc.nextInt();

        System.out.println(solution(A, B, M, X, Y));
    }
}
