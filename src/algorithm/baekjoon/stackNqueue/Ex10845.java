package algorithm.baekjoon.stackNqueue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Seran on 2018-06-11.
 * 10845. 큐
 * https://www.acmicpc.net/problem/10845
 */
public class Ex10845 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Deque<Integer> queue = new LinkedList<Integer>();

        for (int i = 0; i < N ; i++) {
            String m = sc.next();
            if (m.equals("push")) {
                queue.add(sc.nextInt());
            } else if (m.equals("pop")) {
                if (queue.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(queue.poll());
                }
            } else if (m.equals("size")) {
                System.out.println(queue.size());
            } else if (m.equals("empty")) {
                System.out.println(queue.isEmpty() ? 1 : 0);
            } else if (m.equals("front")) {
                if (queue.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(queue.getFirst());
                }
            } else if (m.equals("back")) {
                if (queue.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(queue.getLast());
                }
            }
        }
    }
}
