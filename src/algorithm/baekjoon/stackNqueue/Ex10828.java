package algorithm.baekjoon.stackNqueue;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Seran on 2018-06-10.
 * 10828. 스택
 * https://www.acmicpc.net/problem/10828
 */
public class Ex10828 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < N ; i++) {
            String m = sc.next();
            if (m.equals("push")) {
                stack.push(sc.nextInt());
            } else if (m.equals("pop")) {
                if (stack.empty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(stack.pop());
                }
            } else if (m.equals("size")) {
                System.out.println(stack.size());
            } else if (m.equals("empty")) {
                System.out.println(stack.empty() ? 1 : 0);
            } else if (m.equals("top")) {
                if (stack.empty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(stack.lastElement());
                }
            }
        }

    }
}
