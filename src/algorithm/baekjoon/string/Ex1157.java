package string;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Ex1157 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String s = "";
		
		s = sc.nextLine();
		
		char[] c = s.toCharArray();

		int[] a = new int[26];
		Arrays.fill(a, 0);
		
		for(int i=0; i<c.length; i++) {
			if((int)c[i] > 90) {
				a[(int)c[i] - 97] += 1;
			} else {
				a[(int)c[i] - 65] += 1;
			}
		}
		
		int max = 0;
		int maxIndex = 0;
		Stack st = new Stack();
		
		for(int i=0; i<a.length; i++) {
			if (a[i] >= max) {
				max = a[i];
				maxIndex = i;
				st.push(i);
			}
		}
		
		if(st.size() > 1) {
			int m1 = (Integer)st.pop();
			int m2 = (Integer)st.pop();
			
			if(a[m1] == a[m2]) {
				System.out.println("?");
			} else {
				System.out.println((char)(maxIndex + 65));
			}
		} else {
			System.out.println((char)(maxIndex + 65));
		}
		
		

	}

}
