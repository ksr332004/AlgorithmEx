package algorithm.baekjoon.sort;

import java.util.*;

/**
 * Created by Seran on 2018-06-10.
 * 11651. 좌표 정렬하기 2
 * https://www.acmicpc.net/problem/11651
 */
public class Ex11651 {
    static class Location {
        int x;
        int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        List<Location> locations = new ArrayList<Location>();
        for (int i = 0; i < N ; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            locations.add(new Location(x, y));
        }

        Collections.sort(locations, new Comparator<Location>() {
            @Override
            public int compare(Location o1, Location o2) {
                if (o1.y > o2.y) {
                    return 1;
                } else if (o1.y == o2.y) {
                    if (o1.x >= o2.x) {
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
            System.out.println(locations.get(i).x + " " + locations.get(i).y);
        }
    }
}
