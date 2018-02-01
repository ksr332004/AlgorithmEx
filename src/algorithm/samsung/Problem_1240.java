package algorithm.samsung;

import java.io.File;
import java.util.Scanner;

/**
 * @author Seran
 * 1240. [S/W 문제해결 응용] 1일차 - 단순 2진 암호코드
 */

public class Problem_1240 {

	public static void main(String[] args) throws Exception {
		String myFile = "D:\\workspace\\AlgorithmEx\\src\\samsungSWExpertAcademy\\input\\";
		File file = new File(myFile, "input.txt");
		Scanner sc = new Scanner(file);
		
		String[] cryptoNumbers = {"0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011", "0110111", "0001011"};
		
		int T = sc.nextInt();
		for(int test_case=0; test_case<T; test_case++) {
			String t = sc.next();
			while(t.length() > 10) {
				t = sc.next();
			}

			int N = Integer.parseInt(t); // 세로
			int M = sc.nextInt(); // 가로

			String cryptoString = "";
			boolean f = true;
			for(int i=0; i<N && f; i++) {
				String s = sc.nextLine();
				for(int j=0; j<s.length(); j++) {
					if(s.charAt(j) == '1') {
						int lastIndex = j+55;
						if(s.length()-1 < lastIndex) {
							cryptoString = s.substring((s.length()-1)-55, s.length()-1);
						} else {
							while(s.charAt(lastIndex) != '1') {
								lastIndex--;
							}
							cryptoString = s.substring(lastIndex-55, lastIndex+1);
						}
						f = false;
						break;
					}
				}
			}

			int[] changeNumbers = new int[8];
			for(int i=1; i<=8; i++) {
				for(int j=0; j<cryptoNumbers.length; j++) {
					if(cryptoString.substring(i*7-7,i*7).equals(cryptoNumbers[j])) {
						changeNumbers[i-1] = j;
						break;
					}
				}
			}

			int answer = 0;
			int checkNumber = ((changeNumbers[0] + changeNumbers[2] + changeNumbers[4] + changeNumbers[6]) * 3)
					+ (changeNumbers[1] + changeNumbers[3] + changeNumbers[5]) + changeNumbers[7];

			if(checkNumber%10 == 0) {
				for(int i=0; i<changeNumbers.length; i++) {
					answer += changeNumbers[i];
				}
			}
			
			System.out.println("#" + (test_case+1) + " " + answer);
		}

	}

}
