package algorithm.kakao.blindTest2018;

import java.util.Scanner;

/**
 * Created by Seran on 2017-09-16.
 */
public class Test04 {
    public static String solution(int n, int t, int m, String[] timetable) {
        String answer = "";

        int[] map = new int[n];
        int start = 900;
        int time = 0;
        for(int j=0; j<t; j++) {
            for(int i=0; i<timetable.length; i++) {
                if(timetable[i].equals("")) {
                    continue;
                }
                if(map[time] < n && start >= Integer.getInteger(timetable[i].replace(":", ""))) {
                    map[time]++;
                    timetable[i] = "";
                }
            }
            time++;
            start = start + t;
        }


        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int t = sc.nextInt();
        int m = sc.nextInt();

        int size = sc.nextInt();
        String[] timetable = new String[size];
        for(int i=0; i<size; i++) {
            timetable[i] = sc.next();
        }

        System.out.println(solution(n, t, m, timetable));
    }
}
