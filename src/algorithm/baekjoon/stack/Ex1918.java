package algorithm.baekjoon.stack;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Administrator on 2018-03-26.
 * https://www.acmicpc.net/problem/1918
 * [1918. 후위표기식]
 * 작은 단위의 ()를 중심으로 계산
 */
public class Ex1918 {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        // 입력받은 연산
        String S = sc.nextLine();
        // 연산자 순위
        Stack<Character> stack = new Stack<Character>();

        // 연산자
        HashMap<Character, Integer> operators = new HashMap<Character, Integer>();
        operators.put('+', 1);
        operators.put('-', 1);
        operators.put('*', 2);
        operators.put('/', 2);
        operators.put('(', 0);
        operators.put(')', 0);
        // 후위 표기법으로 변환된 답
        String answer = "";

        for (int i=0; i<S.length(); i++) {
            // 연산자가 아닐 경우
            if (!operators.containsKey(S.charAt(i))) {
                answer += S.charAt(i);
                continue;
            }

            if (S.charAt(i) == '(') {
                stack.push(S.charAt(i));
            } else if (stack.isEmpty()) {
                stack.push(S.charAt(i));
            } else if (operators.get(S.charAt(i)) > operators.get(stack.peek())) {
                stack.push(S.charAt(i));
            } else {
                while (!stack.isEmpty() && operators.get(stack.peek()) >= operators.get(S.charAt(i))) {
                    if (stack.peek() == '(') {
                        stack.pop();
                        operators.replace('(', 3);
                        operators.replace(')', 3);
                        break;
                    }
                    answer += stack.pop();
                }

                if (S.charAt(i) == ')') {
                    operators.replace('(', 0);
                    operators.replace(')', 0);
                } else {
                    stack.push(S.charAt(i));
                }
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == ')') {
                stack.pop();
                continue;
            }
            answer += stack.pop();
        }

        System.out.println(answer);
    }
}
