package algorithm.baekjoon.etc;

/**
 * Created by Administrator on 2018-02-28.
 * https://www.acmicpc.net/problem/6679
 * 6679. 싱기한 네자리 숫자
 */
public class Ex6679 {
    public static void main(String[] args) {
        // 주어진 싱기한 네자리 숫자
        int s = 1000;
        int e = 9999;

        // 진수
        int[] J  = {10, 12, 16};

        for (int i=s; i<=e; i++) {
            // 첫번째 진수의 각자리 수를 합한 값
            int base = 0;
            for (int j=0; j<J.length; j++) {
                // 각각 진수의 각자리 수를 합한 값
                int sum = 0;
                // 주어진 수
                int temp = i;

                while (temp > 0) {
                    sum += temp%J[j];
                    temp = temp/J[j];
                }

                // 첫번째 진수의 각자리 수를 합한 값 초기화
                if (base == 0) {
                    base = sum;
                }

                // 값이 다를 경우
                if (base != sum) {
                    break;
                }

                // 모든 진수의 각자리 수를 합한 값이 같을 때
                if (j == J.length-1 && base == sum) {
                    System.out.println(i);
                }
            }
        }
    }
}
