package algorithm.baekjoon.array;

import java.util.Scanner;

public class Ex1152 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		
		String[] s_arr = s.split(" ");
		
		int n = s_arr.length;
		for(int i=0; i<s_arr.length; i++){
			if(s_arr[i].equals(" ")) {
				n -= 1;
			} else if(s_arr[i].equals("")) {
				n -= 1;
			}
		}
		
		System.out.println(n);

	}

}
