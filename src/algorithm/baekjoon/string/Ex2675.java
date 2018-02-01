package string;

import java.util.Scanner;

public class Ex2675 {
	
	// 스페이스 공백 단위로 값을 읽어 드릴 때는 sc.next()를 사용
	// [문제점] 숫자 다음 문자를 입력 받을 때 sc.next()과 sc.nextLine()를 같이 쓰면 에러발생
	// [해결] sc.next()로 숫자형을 받고 이것을 Integer.parseInt로 int형으로 변환

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = Integer.parseInt(sc.next());        

		for(test_case = 1; test_case <= T; test_case++) {
			int r = Integer.parseInt(sc.next()); // 반복횟수
			char[] s = sc.next().toCharArray(); // 입력받은 문자열
			String t = "";
			
			for(int j = 0; j < s.length; j++) {
				for(int z = 0; z < r; z++) {
					t += s[j];
				}
			}
			
			System.out.println(t);
		}
	}

}
