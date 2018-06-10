package algorithm.baekjoon.stackNqueue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Seran on 2018-06-11.
 * 10799. 덱
 * https://www.acmicpc.net/problem/10799
 */
public class Ex10866 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Deque<Integer> deque = new LinkedList<Integer>();

        for (int i = 0; i < N ; i++) {
            String m = sc.next();
            if (m.equals("push_front")) {
                deque.addFirst(sc.nextInt());
            } else if (m.equals("push_back")) {
                deque.addLast(sc.nextInt());
            } else if (m.equals("pop_front")) {
                if (deque.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(deque.pollFirst());
                }
            } else if (m.equals("pop_back")) {
                if (deque.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(deque.pollLast());
                }
            } else if (m.equals("size")) {
                System.out.println(deque.size());
            } else if (m.equals("empty")) {
                System.out.println(deque.isEmpty() ? 1 : 0);
            } else if (m.equals("front")) {
                if (deque.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(deque.getFirst());
                }
            } else if (m.equals("back")) {
                if (deque.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(deque.getLast());
                }
            }
        }
    }
}