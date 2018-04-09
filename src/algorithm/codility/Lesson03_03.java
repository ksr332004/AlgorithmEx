package algorithm.codility;

import java.util.Scanner;

/**
 * Created by Administrator on 2017-10-24.
 */
public class Lesson03_03 {
    public static int solution(int X, int Y, int D) {
        int Answer = 0;
        if((Y - X) < 0) {
            Answer = 1;
        } else {
            if(((Y - X) % D) > 0) {
                Answer = ((Y - X) / D) + 1;
            } else {
                Answer = ((Y - X) / D);
            }
        }
        return Answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int Y = sc.nextInt();
        int D = sc.nextInt();

        System.out.println(solution(X, Y, D));
    }
}
