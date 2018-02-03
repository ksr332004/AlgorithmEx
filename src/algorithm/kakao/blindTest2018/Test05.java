package algorithm.kakao.blindTest2018;

import java.util.Scanner;

/**
 * Created by Seran on 2017-09-16.
 */
public class Test05 {
    public static int solution(String str1, String str2) {
        int answer = 0;

        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        String[] arr_str1 = new String[str1.length()-1];
        String[] arr_str2 = new String[str2.length()-1];

        for(int i=0; i<str1.length()-1; i++) {
            String tmp = str1.substring(i, i+2);
            if((tmp.charAt(0) >= 65 && tmp.charAt(0) <= 90) && (tmp.charAt(1) >= 65 && tmp.charAt(1) <= 90)) {
                arr_str1[i] = tmp;
            } else {
                arr_str1[i] = "";
            }
        }

        for(int i=0; i<str2.length()-1; i++) {
            String tmp = str2.substring(i, i+2);
            if((tmp.charAt(0) >= 65 && tmp.charAt(0) <= 90) && (tmp.charAt(1) >= 65 && tmp.charAt(1) <= 90)) {
                arr_str2[i] = tmp;
            }else {
                arr_str2[i] = "";
            }
        }

        double u = 0;
        double n = 0;

        for(int i=0; i<arr_str1.length; i++) {
            if(arr_str1[i].equals("")) {
                continue;
            }
            for(int j=0; j<arr_str2.length; j++) {
                if(arr_str2[j].equals("")) {
                    continue;
                }

                if(arr_str1[i].equals(arr_str2[j])) {
                    n += 1;
                    arr_str2[j] = "";
                    break;
                }
            }
        }

        for(int i=0; i<arr_str1.length; i++) {
            if(!arr_str1[i].equals("")) {
                u += 1;
            }
        }
        for(int k=0; k<arr_str2.length; k++) {
            if(!arr_str2[k].equals("")) {
                u += 1;
            }
        }

        if(n == 0.0 && u == 0.0) {
            answer = 65536;
        } else {
            answer = (int)((n/u)*65536);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str1  = sc.nextLine();
        String str2  = sc.nextLine();

        System.out.println(solution(str1, str2));
    }
}
