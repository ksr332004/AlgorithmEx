package algorithm.samsung.queue;

import java.io.File;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author Seran
 * 2477. [모의 SW 역량테스트] 차량 정비소
 */

public class Problem2477 {
	
	static class CustomerN implements Comparable<CustomerN> {
		int number;
		int time;
		
		public CustomerN(int number, int time) {
			this.number = number;
			this.time = time;
		}
		
		public int compareTo (CustomerN target) {
			if (this.time > target.time) {
				return 1;
			} else if (this.time == target.time) {
				if (this.number > target.number) {
					return 1;
				} else {
					return -1;
				}
			} else if (this.time < target.time) {
				return -1;
			}
			return 0;
		}
	}
	
	static class CustomerM implements Comparable<CustomerM> {
		int number;
		int time;
		int usedN;
		
		public CustomerM(int number, int time, int usedN) {
			this.number = number;
			this.time = time;
			this.usedN = usedN;
		}
		
		public int compareTo (CustomerM target) {
			if (this.time > target.time) {
				return 1;
			} else if (this.time == target.time) {
				if (this.usedN > target.usedN) {
					return 1;
				} else {
					return -1;
				}
			} else if (this.time < target.time) {
				return -1;
			}
			return 0;
		}
	}

	public static void main(String[] args) throws Exception {
		String myFile = Problem2477.class.getResource("").getPath();
		File file = new File(myFile + "../input/", "input.txt");
		
		Scanner sc = new Scanner(file);
		
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			// 접수 창구 수
			int N = sc.nextInt();
			// 정비 창구 수
			int M = sc.nextInt();
			// 방문 고객 수
			int K = sc.nextInt();
			
			// 지갑 두고간 고객의 이용 N 창구 번호
			int A = sc.nextInt();
			// 지갑 두고간 고객의 이용 M 창구 번호
			int B = sc.nextInt();
			
			// 각 접수 창구 처리 시간
			int[][] a = new int[N][2];
			for (int i = 0; i < a.length; i++) {
				a[i][0] = sc.nextInt();
			}
			// 각 정비 창구 처리 시간
			int[][] b = new int[M][2];
			for (int i = 0; i < b.length; i++) {
				b[i][0] = sc.nextInt();
			}
			// 고객 정보
			int[][] custInfo = new int[K+1][2];
			// N 접수 창구 고객 도착 시간
			PriorityQueue<CustomerN> P1 = new PriorityQueue<CustomerN>();
			for (int i = 0; i < K; i++) {
				int t = sc.nextInt();
				P1.offer(new CustomerN(i+1, t));
			}

			// M 접수 창구 고객 도착 시간
			PriorityQueue<CustomerM> P2 = new PriorityQueue<CustomerM>();
			
			int count = K;
			int time = 0;
			while (count > 0) {
				for (int i = 0; i < N; i++) {
					if (!P1.isEmpty() && a[i][1] == 0 && time >= P1.peek().time) {
						a[i][1] = a[i][0];
						P2.add(new CustomerM(P1.peek().number, time + a[i][0], i+1));
						custInfo[P1.peek().number][0] = i+1;
						P1.poll();
						a[i][1]--;
						count--;
					} else if (a[i][1] > 0) {
						a[i][1]--;
					}
				}
				time++;
			}
			
			count = K;
			time = P2.peek().time;
			while (count > 0) {
				for (int i = 0; i < M; i++) {
					if (!P2.isEmpty() && b[i][1] == 0 && time >= P2.peek().time) {
						b[i][1] = b[i][0];
						custInfo[P2.peek().number][1] = i+1;
						P2.poll();
						b[i][1]--;
						count--;
					} else if (b[i][1] > 0) {
						b[i][1]--;
					}
				}
				time++;
			}
			
			int answer = 0;
			for (int i = 1; i <= K; i++) {
				if (custInfo[i][0] == A && custInfo[i][1] == B) {
					answer += i;
				}
			}
			answer = (answer == 0) ? -1 : answer;
			
			System.out.println("#" + test_case + " " + answer);
		}
	}

}
