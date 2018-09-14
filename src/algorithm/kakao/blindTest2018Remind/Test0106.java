package algorithm.kakao.blindTest2018Remind;

import java.util.Scanner;

/**
 * [1차] 비밀지도
 * @author Seran
 *
 */

public class Test0106 {
	public static int[] binary(int a, int n) {
		int[] A = new int[n];
		
		int i = n-1;
		while(a != 0) {
			A[i] = a%2;
			a = a/2;
			i--;
		}
		
		return A;
	}
	
	public static String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		
		String map = "";
		
		for (int i=0; i<n; i++) {
			int[] A = binary(arr1[i], n);
			int[] B = binary(arr2[i], n);
			
			for (int j=0; j<n; j++) {
				if (A[j] + B[j] == 0) {
					map += " ";
				} else {
					map += "#";
				}
			}
			answer[i] = map;
			map = "";
		}
		
		return answer;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = 5;
		int[] arr1 = {9, 20, 28, 18, 11};
		int[] arr2 = {30, 1, 21, 17, 28};

		String[] S = solution(n, arr1, arr2);
		for (int i = 0; i < arr2.length; i++) {
			System.out.println(S[i]);
		}
	}

}
