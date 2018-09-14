package algorithm.programmers.kakaoPreTest;

import java.util.Scanner;

/**
 * 2018-09-14
 * @author Seran
 *
 */

public class Test09 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        for (int i=0; i<b; i++) {
        	for (int j=0; j<a; j++) {
        		System.out.print("*");
        	}
        	System.out.println();
        }

	}

}
