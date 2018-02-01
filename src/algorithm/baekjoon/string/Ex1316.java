package string;

import java.util.Arrays;
import java.util.Scanner;

public class Ex1316 {
	
	static boolean check(char[] c) {
		int[] a = new int[26];
		Arrays.fill(a, 0);
		a[(int)c[0]-97] = 1;

		char b = c[0];
		
		for(int i=1; i<c.length; i++){
			if(c[i] != b) {
				if(a[(int)c[i]-97] == 1) {
					return false;
				}
				a[(int)c[i]-97] = 1;
			}
			b = c[i];
		}
		return true;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int test_case = Integer.parseInt(sc.nextLine());
		
		int count = 0;
		
		for(int i=0; i<test_case; i++) {
			char[] c = sc.nextLine().toCharArray();
			if(check(c)) {
				count++;
			}
		}
		
		System.out.println(count);
		
	}

}
