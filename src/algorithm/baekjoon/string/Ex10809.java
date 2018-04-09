package algorithm.baekjoon.string;

import java.util.Arrays;
import java.util.Scanner;

public class Ex10809 {
	
	// Arrays.fill(arr, -1); 배열 arr에 -1로 초기화
	// (int)char형 으로 선언하면 아스키코드 값 출력 

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		String s = "";
		
		s = sc.nextLine();
		
		char[] c = s.toCharArray();
		
		int[] arr = new int[26];
		Arrays.fill(arr, -1);
		
		for(int i = 0; i < c.length; i++) {
			if((int)c[i] < 97 || (int)c[i] > 122) {
				break;
			}
			
			if(arr[(int)c[i] - 97] == -1) {
				arr[(int)c[i] - 97] = i;
			}
			
		}
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			System.out.print(" ");
		}
		
	}

}
