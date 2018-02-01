package algorithm.baekjoon.dynamic;

import java.util.Scanner;

/**
 * @author Seran
 * [일차원 배열]
 * [식세우기]
 * 앞 뒤 숫자간의 관계를 통한 점화식 도출
 */

public class Ex1003 {
	
	static int fibonacciCountZero(int n) {
		if(n == 0) {
			return 1;
		} else if(n == 1) {
			return 0;
		} else {
			return fibonacciCountZero(n-2) + fibonacciCountZero(n-1);
		}
	}
	
	static int fibonacciCountOne(int n) {
		if(n == 0) {
			return 0;
		} else if(n == 1) {
			return 1;
		} else {
			return fibonacciCountOne(n-2) + fibonacciCountOne(n-1);
		}
	}

	public static void main(String[] args) {
		/**
		 * 피보나치 수열
		 * 0과 1에 대한 각각의 점화식을 구함
		 * 0 일 때 : a[n] = a[n-1] + a[n-2]
		 * 1 일 때 : b[n] = b[n-1] + b[n-2]
		 * 초기값 
		 * a[0] = 1 / b[0] = 0
		 * a[1] = 0 / b[1] = 1
		 */
		
		Scanner sc = new Scanner(System.in);
		int count = Integer.parseInt(sc.nextLine());
		int N[] = new int[count];
		for(int i=0; i<count; i++) {
			N[i] = Integer.parseInt(sc.nextLine());
		}
		
		for(int i=0; i<count; i++) {
			System.out.println(fibonacciCountZero(N[i]) + " " + fibonacciCountOne(N[i]));
		}
		
	}

}
