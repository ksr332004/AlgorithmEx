package algorithm.baekjoon.sort;

import java.util.*;

/**
 * Created by Seran on 2018-06-10.
 * 11650. 좌표 정렬하기
 * https://www.acmicpc.net/problem/11650
 */
public class Ex11650 {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Point> points = new ArrayList<Point>();
        for (int i = 0; i < N ; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            points.add(new Point(x, y));
        }

        Collections.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.x > o2.x) {
                    return 1;
                } else if (o1.x == o2.x) {
                    if (o1.y >= o2.y) {
                        return 1;
                    } else {
                        return -1;
                    }
                } else {
                    return -1;
                }
            }
        });

        for (int i = 0; i < N ; i++) {
            System.out.println(points.get(i).x + " " + points.get(i).y);
        }

    }
}
