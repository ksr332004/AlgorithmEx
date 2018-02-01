package algorithm.programmers.kakaoPreTest;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Seran on 2017-09-02.
 */
public class Test03 {

    public static int[] solution(int[][] v) {
        int[] answer = new int[2];

        if(v[0][0] == v[1][0]) {
            answer[0] = v[2][0];
        } else if(v[0][0] == v[2][0]) {
            answer[0] = v[1][0];
        } else if(v[1][0] == v[2][0]) {
            answer[0] = v[0][0];
        }

        if(v[0][1] == v[1][1]) {
            answer[1] = v[2][1];
        } else if(v[0][1] == v[2][1]) {
            answer[1] = v[1][1];
        } else if(v[1][1] == v[2][1]) {
            answer[1] = v[0][1];
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] v = new int[n][2];
        for(int i=0; i<n; i++) {
            v[i][0] = sc.nextInt();
            v[i][1] = sc.nextInt();
        }

        System.out.println(solution(v)[0] + ", " + solution(v)[1]);
    }
}
