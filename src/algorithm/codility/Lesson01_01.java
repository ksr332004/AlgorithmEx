package algorithm.codility;

import java.util.Scanner;

/**
 * Created by Seran on 2017-10-19.
 */
public class Lesson01_01 {
    public static int solution(int N) {
        String binaryString = "";
        int Answer = 0;

        while(N>0) {
            binaryString += N%2;
            N = N/2;
        }

        for(int i=0; i<binaryString.length(); i++) {
            if(binaryString.substring(i, i+1).equals("1")) {
                binaryString = binaryString.substring(i, binaryString.length());
                break;
            }
        }

        int max = 0;
        for(int i=0; i<binaryString.length(); i++) {
            if(binaryString.substring(i, i+1).equals("1")) {
                if(max > Answer) {
                    Answer = max;
                }
                max = 0;
            } else {
                max++;
            }
        }

        if(max > Answer) {
            Answer = max;
        }

        return Answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        System.out.println(solution(N));
    }
}
