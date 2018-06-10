package algorithm.baekjoon.stackNqueue;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Seran on 2018-06-10.
 * 9012. 괄호
 * https://www.acmicpc.net/problem/9012
 */
public class Ex9012 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int test_case = 0; test_case < T ; test_case++) {
            String PS = sc.next();
            String answer = "YES";
            Stack<Character> stack = new Stack<Character>();

            for (int i = 0; i < PS.length() ; i++) {
                if (PS.charAt(i) == ')') {
                    if (stack.empty()) {
                        answer = "NO";
                        break;
                    } else {
                        stack.pop();
                    }
                } else {
                    stack.push('(');
                }
            }

            if (!stack.empty()) {
                answer = "NO";
            }

            System.out.println(answer);
        }
    }
}
