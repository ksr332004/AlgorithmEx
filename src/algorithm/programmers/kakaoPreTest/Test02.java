package algorithm.programmers.kakaoPreTest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Seran on 2017-09-02.
 */
public class Test02 {
    public static boolean solution(int[] arr) {
        boolean answer = true;

        int[] T = new int[arr.length + 1];
        Arrays.fill(T, 0);
        T[0] = 1;

        for(int i=0; i<arr.length; i++) {
            if(arr[i] > arr.length) {
                answer = false;
                break;
            }
            T[arr[i]] = 1;
        }

        if(answer) {
            for(int i=0; i<T.length; i++) {
                if(T[i] == 0) {
                    answer = false;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(solution(arr));
    }
}
