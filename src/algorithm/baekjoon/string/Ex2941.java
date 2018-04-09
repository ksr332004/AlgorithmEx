package algorithm.baekjoon.string;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Administrator on 2017-09-04.
 * https://www.acmicpc.net/problem/2941
 * [크로아티아 알파벳]
 * "dz=", "c=", "c-", "d-", "lj", "nj", "s=", "z=" 는 한 글자로 세어 총 몇 글자가 씌여져 있는지 값 구하기.
 * (해결)
 * substring(start_index, end_index-1) 함수를 이용하여 2글자 혹은 3글자씩 비교하여 구하기.
 */
public class Ex2941 {
    static int solution(String str)
    {
        int answer = 0;
        String[] croStr = {"dz=", "c=", "c-", "d-", "lj", "nj", "s=", "z="};

        int[] check = new int[str.length()];
        Arrays.fill(check, 0);

        for(int i=0; i<str.length(); i++) {
            if(check[i] != 0) {
                continue;
            }

            if(i < (str.length() - 2) && str.substring(i,i+3).equals(croStr[0])) {
                answer++;
                check[i] = 1;
                check[i+1] = 1;
                check[i+2] = 1;
            } else if(i < (str.length() - 1)) {
                for(int j=1; j<croStr.length; j++) {
                    if(str.substring(i,i+2).equals(croStr[j])) {
                        answer++;
                        check[i] = 1;
                        check[i+1] = 1;
                        break;
                    }
                }
            }

            if(check[i] == 0) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.println(solution(str));
    }
}
