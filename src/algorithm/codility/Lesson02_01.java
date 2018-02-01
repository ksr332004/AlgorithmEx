package algorithm.codility;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Seran on 2017-10-23.
 */
public class Lesson02_01 {
    public static int solution(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int Answer = 0;
        for(int i=0; i<A.length; i++) {
            if(map.containsKey(A[i])) {
                map.put(A[i], map.get(A[i]) + 1);
            } else {
                map.put(A[i], 1);
            }
        }
        for(int i : map.keySet()) {
            if(map.get(i)%2 == 1) {
                Answer = i;
            }
        }
        return Answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N  = sc.nextInt();
        int[] A = new int[N];
        for(int i=0; i<N; i++) {
            A[i] = sc.nextInt();
        }

        System.out.println(solution(A));
    }
}
