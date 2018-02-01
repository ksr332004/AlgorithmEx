package algorithm.baekjoon.function;

import java.util.Arrays;

public class Ex4673 {
	
	static int d(int n) {
		int sum = n;
		
		while(n > 9) {
			sum += n%10;
			n = (int)(n/10);
		}
		sum += n;
		
		return sum;
	}
	
	public static void main(String[] args) {
		
		int test_case = 10000;
		
		int[] check = new int[10001];
		Arrays.fill(check, 0);
		
		for(int i=1; i<=test_case; i++) {
			if(d(i) <= test_case) {
				check[d(i)] = 1;
			}
		}
		
		for(int i=1; i<=test_case; i++) {
			if(check[i] == 0) {
				System.out.println(i);
			}
		}

	}

}
