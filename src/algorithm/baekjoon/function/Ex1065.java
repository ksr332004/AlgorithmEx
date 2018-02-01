package algorithm.baekjoon.function;

import java.util.Scanner;

public class Ex1065 {
	
	static int check(int num) {
		if(num < 100) {
			return 1;
		}
		
		int a = 0;
		int b = 0;
		int gap = 0;
		
		a = num % 10;
		num = (int)((num - (num % 10)) / 10);
		b = num % 10;
		gap = b - a;
		
		while(num >= 10) {
			num = (int)((num - (num % 10)) / 10);
			a = num % 10;
			if(a != b + gap) {
				return 0;
			}
			b = a;
		}
		return 1;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int sum = 0;
		
 		for(int i=1; i<=n; i++) {
			sum += check(i);
		}
		
		System.out.println(sum);
		
	}

}
