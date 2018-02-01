package algorithm.baekjoon.array;

import java.util.Arrays;
import java.util.Scanner;

public class Ex2577 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		long c = sc.nextInt();
		
		for(int i=0; i<2; i++){
			c = c * sc.nextLong();
		}
		
		char[] c_arr = Long.toString(c).toCharArray();
		int[] i_arr = new int[10];
		
		for(int i=0; i<c_arr.length; i++) {
			i_arr[(int)c_arr[i] - 48] ++;
		}
		
		for(int i=0; i<i_arr.length; i++) {
			System.out.println(i_arr[i]);
		}
	}

}
