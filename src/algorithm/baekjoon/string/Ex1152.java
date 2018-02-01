package string;

import java.util.Scanner;

/**
 * Created by Administrator on 2017-09-04.
 * https://www.acmicpc.net/problem/1152
 * [단어의 개수]
 * 띄어쓰기로 구분되어 있는 문장에서 사용된 단어의 개수를 찾아라.
 * (해결)
 * split() 함수를 통해 문자열을 쪼갠 후 쪼개진 단어의 개수를 센다.(예외처리 필수)
 */
public class Ex1152 {

    static int solution(String str)
    {
        String[] strArr = str.split(" ");

        int answer = 0;

        for(int i=0; i<strArr.length; i++) {
            if(!strArr[i].equals("")) {
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
