package algorithm.programmers.kakaoPreTest;

import java.util.Scanner;

/**
 * Created by Seran on 2017-09-02.
 */
public class Test01 {
    public static int solution(int n) {
        int answer = 0;

        while(n != 0) {
            answer += n%10;
            n = n/10;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n  = sc.nextInt();

        System.out.println(solution(n));
    }
}
