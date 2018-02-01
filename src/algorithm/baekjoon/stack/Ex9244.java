package algorithm.baekjoon.stack;

import java.util.*;

/**
 * Created by Administrator on 2017-09-22.
 * https://www.acmicpc.net/problem/9244
 * [핀볼]
 * (해결)
 *
 */
public class Ex9244 {

    public static void main(String args[])	{
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        Queue X = new LinkedList();
        Queue Y = new LinkedList();
        for(int i=0; i<T; i++) {
            X.add(sc.nextInt());
            Y.add(sc.nextInt());
            X.add(sc.nextInt());
            Y.add(sc.nextInt());
        }

        int start = sc.nextInt();
        boolean flag = false;
        int preX = start;
        int preY = 0;
        for(int i=0; i<T; i++) {
            int x1 = Integer.parseInt(X.poll().toString());
            int y1 = Integer.parseInt(Y.poll().toString());
            int x2 = Integer.parseInt(X.poll().toString());
            int y2 = Integer.parseInt(Y.poll().toString());

            if(!flag) {
                if((x1 <= start && x2 >= start) || (x2 <= start && x1 >= start)) {
                    flag = true;
                    if(y1 < y2) {
                        preX = x1;
                        preY = y1;
                    } else {
                        preX = x2;
                        preY = y2;
                    }
                }
            } else {
                if(((x1 <= preX && x2 >= preX) || (x2 <= preX && x1 >= preX)) && preY >= y1) {
                    if(y1 < y2) {
                        preX = x1;
                        preY = y1;
                    } else {
                        preX = x2;
                        preY = y2;
                    }
                }
            }
        }

        System.out.println(preX);
    }
}
