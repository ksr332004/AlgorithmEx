package algorithm.baekjoon.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Administrator on 2017-09-22.
 * https://www.acmicpc.net/problem/1918
 * [후위표기식]
 *
 * (해결)
 *
 */
public class Ex1918 {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String T = sc.nextLine();

        String Answer = "";

        Stack<Character> stack = new Stack<Character>();

        for(int i=0; i<T.length(); i++) {
            if(T.charAt(i) >= 'A' && T.charAt(i) <= 'Z') {
                Answer += T.charAt(i);
            } else if(T.charAt(i) == ')') {
                while (stack.peek() != '(') {
                    Answer += stack.peek();
                    stack.pop();
                }
                stack.pop();
            } else {
                if(stack.size() != 0 && (T.charAt(i) == '+' || T.charAt(i) == '-') && (stack.peek() == '+' || stack.peek() == '-')) {
                    Answer += T.charAt(i);
                } else if(stack.size() != 0 && (T.charAt(i) == '*' || T.charAt(i) == '/') && (stack.peek() == '*' || stack.peek() == '/')) {
                    Answer += T.charAt(i);
                } else if(stack.size() != 0 && (T.charAt(i) == '+' || T.charAt(i) == '-') && (stack.peek() == '*' || stack.peek() == '/')) {
                    while (stack.size() > 0 && stack.peek() != '(') {
                        Answer += stack.peek();
                        stack.pop();
                    }
                    stack.push(T.charAt(i));
                } else {
                    stack.push(T.charAt(i));
                }
            }
        }

        while (stack.size() != 0) {
            Answer += stack.peek();
            stack.pop();
        }

        System.out.println(Answer);
    }
}
