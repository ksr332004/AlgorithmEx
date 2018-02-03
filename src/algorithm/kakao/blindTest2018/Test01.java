package algorithm.kakao.blindTest2018;

import java.util.Scanner;

/**
 * Created by Seran on 2017-09-16.
 */
public class Test01 {
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        int[][] big_arr1 = new int[n][n];
        int[][] big_arr2 = new int[n][n];
        for(int i=0; i<n; i++) {
            int j = n-1;
            while(j > -1) {
                big_arr1[i][j] = arr1[i] % 2;
                arr1[i] = arr1[i]/2;

                big_arr2[i][j] = arr2[i] % 2;
                arr2[i] = arr2[i]/2;
                j--;
            }
        }

        for(int i=0; i<n; i++) {
            String s = "";
            for(int j=0; j<n; j++) {
                if(big_arr1[i][j] == 1 || big_arr2[i][j] == 1) {
                    s += "#";
                } else {
                    s += " ";
                }
            }
            answer[i] = s;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n  = sc.nextInt();

        int[] arr1 = new int[n];
        for(int i=0; i<n; i++) {
            arr1[i] = sc.nextInt();
        }

        int[] arr2 = new int[n];
        for(int i=0; i<n; i++) {
            arr2[i] = sc.nextInt();
        }

        String[] t = solution(n, arr1, arr2);

        for(int i=0; i<n; i++) {
            System.out.println(t[i]);
        }
    }
}
