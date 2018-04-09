package algorithm.baekjoon.string;

import java.util.Scanner;

public class Ex2908 {
	
	// String : 한 번 생성되면 할당된 메모리 공간이 변하지 않음, Heap 메모리 영역에 저장, 동기화에 신경안써도 됨(Thread-Safe)
	// StringBuffer : 기존의 버퍼 크기를 늘리며 유연하게 동작, 각 메서드 별로 Synchronized Keyword 가 존재하여 멀티스레드 환경에서도 동기화를 지원
	// StringBuilder : 기존의 버퍼 크기를 늘리며 유연하게 동작, StringBuilder는 동기화를 보장하지 않음
	// 연산이 많은 경우 	StringBuilder > StringBuffer >>> String

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StringBuffer s1 = new StringBuffer(sc.next());
		StringBuffer s2 = new StringBuffer(sc.next());
		
		s1 = s1.reverse();
		s2 = s2.reverse();
		
		int i1 = Integer.parseInt(s1.toString());
		int i2 = Integer.parseInt(s2.toString());
		
		if(i1 > i2) {
			System.out.println(i1);
		} else {
			System.out.println(i2);
		}

	}

}
