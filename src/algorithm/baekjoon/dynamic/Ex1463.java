package algorithm.baekjoon.dynamic;

import java.util.Scanner;

/**
 * @author Seran
 * [일차원 배열]
 * [차례로 칸 채우기]
 * [차례대로 최소값을 구해가면서 현재값을 더해가는 형식]
 * 주어진 특정 숫자에 국한되어 문제를 보지 않고 1부터 차례대로 값을 채워간다는 생각으로 접근해야함
 */

public class Ex1463 {
	
	public static void main(String[] args) {
		/**
		 * 1로 만들기
		 * N이 주어짐
		 * N을 3으로 나누기, 2로 나누기, 1을 빼기 중 하나를 수행해서
		 * 최단 횟수로 1이 되도록 해야함  
		 */
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		/**
		 * Top-down 방식
		 * D[n] = D[n/3] + 1
		 * D[n] = D[n/2] + 1
		 * D[n] = D[n-1] + 1
		 * 초기 조건 : D[1] = 0
		 * 해당 로직이 반복적으로 돌면서 D[n]에 저장되어있던 횟수보다 더 적은 횟수가 나온다면 그 값으로 변환 해줘야한다.
		 */
		
		/**
		 * Bottom-up 방식
		 * D[n] = min(D[n-1], D[n/2], D[n/3]) + 1
		 * 초기 조건 : D[1] = 0
		 */
		
		int[] D = new int[n+1];
		D[0] = 0;
		D[1] = 0;
		for(int i=2; i<=n; i++) {
			int min = D[i-1] + 1;
			if(i%2 == 0) {
				min = (min > D[i/2] + 1 ? D[i/2] + 1 : min);
			}
			if(i%3 == 0) {
				min = (min > D[i/3] + 1 ? D[i/3] + 1 : min);
			}
			D[i] = min;
		}
		
		System.out.println(D[n]);
		
	}

}
