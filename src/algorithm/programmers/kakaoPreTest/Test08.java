package algorithm.programmers.kakaoPreTest;

import java.util.Scanner;

/**
 * 2018-09-14
 * @author Seran
 *
 */

public class Test08 {
	
	public static boolean solution(int[] arr) {
        boolean answer = true;
        int max = arr.length;
        int[] temp = new int[max + 1];
        
        for (int i=0; i<max; i++) {
            if (arr[i] > max) {
                answer = false;
                break;
            }
            
            if (temp[arr[i]] != 0) {
                answer = false;
                break;
            }
            
            temp[arr[i]]++;
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
