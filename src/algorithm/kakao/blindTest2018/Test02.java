package algorithm.kakao.blindTest2018;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Seran on 2017-09-16.
 */
public class Test02 {
    public static int solution(String dartResult) {
        int answer = 0;

        String[] divs = {"S*", "S#", "D*", "D#", "T*", "T#", "10", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "S", "D", "T"};

        int[] nums = new int[3];
        int c = -1;
        int[] b = new int[3];
        Arrays.fill(b, 0);
        for(int i=0; i<dartResult.length(); i++) {
            int l = 0;
            if(i == dartResult.length()-1) {
                l = 7;
            }
            for(int j=l; j<divs.length; j++) {
                String temp = dartResult.substring(i,i+divs[j].length());
                if(temp.equals(divs[j])) {
                    i += divs[j].length()-1;
                    if(5 < j && j < 17) {
                        c++;
                        if(divs[j].equals("10")) {
                            nums[c] = 10;
                        } else {
                            nums[c] = j-7;
                        }
                    } else {
                        if(divs[j].charAt(0) == 'D') {
                            nums[c] = nums[c] * nums[c];
                        } else if(divs[j].charAt(0) == 'T') {
                            nums[c] = nums[c] * nums[c] * nums[c];
                        }

                        if(divs[j].length() == 2) {
                            if(divs[j].charAt(1) == '*') {
                                nums[c] = nums[c] * 2;
                                b[c] = 2;
                            } else if(divs[j].charAt(1) == '#') {
                                nums[c] = nums[c] * (-1);
                                b[c] = 1;
                            }

                            if(c > 0) {
                                if(b[c] == 2) {
                                    nums[c-1] = nums[c-1] * 2;
                                }
                            }
                        }
                    }
                    break;
                }
            }
        }

        answer = nums[0] + nums[1] + nums[2];

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String dartResult  = sc.nextLine();

        System.out.println(solution(dartResult));
    }
}
