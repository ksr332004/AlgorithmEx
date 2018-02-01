package algorithm.programmers.kakaoPreTest;

import java.util.Scanner;

/**
 * Created by Seran on 2017-09-02.
 * [최대 숫자의 합]
 * https://www.acmicpc.net/problem/2579
 * https://www.acmicpc.net/problem/9465
 * https://www.acmicpc.net/problem/1932
 * N개의 스티커가 원형으로 연결되어 있습니다. 다음 그림은 N = 8인 경우의 예시입니다.
 *  10 14
 * 2      6
 * 9      5
 *   3 11
 * 원형으로 연결된 스티커에서 몇 장의 스티커를 뜯어내어 뜯어낸 스티커에 적힌 숫자의 합이 최대가 되도록 하고 싶습니다.
 * 단 스티커 한 장을 뜯어내면 양쪽으로 인접해있는 스티커는 찢어져서 사용할 수 없게 됩니다.
 *
 * 예를 들어 위 그림에서 14가 적힌 스티커를 뜯으면 인접해있는 10, 6이 적힌 스티커는 사용할 수 없습니다.
 * 스티커에 적힌 숫자가 배열 형태로 주어질 때, 스티커를 뜯어내어 얻을 수 있는
 * 숫자의 합의 최댓값을 return 하는 solution 함수를 완성해 주세요.
 * 원형의 스티커 모양을 위해 배열의 첫 번째 원소와 마지막 원소가 서로 연결되어 있다고 간주합니다.
 *
 * 제한 사항
 * sticker는 원형으로 연결된 스티커의 각 칸에 적힌 숫자가 순서대로 들어있는 배열로, 길이(N)는 1 이상 100,000 이하입니다.
 * sticker의 각 원소는 스티커의 각 칸에 적힌 숫자이며, 각 칸에 적힌 숫자는 1 이상 100 이하의 자연수입니다.
 * 원형의 스티커 모양을 위해 sticker 배열의 첫 번째 원소와 마지막 원소가 서로 연결되어있다고 간주합니다.
 * 입출력 예
 * sticker	                    answer
 * [14, 6, 5, 11, 3, 9, 2, 10]  	  36
 * [1, 3, 2, 5, 4]	               8
 * 입출력 예 설명
 * 입출력 예 #1
 * 6, 11, 9, 10이 적힌 스티커를 떼어 냈을 때 36으로 최대가 됩니다.
 *
 * 입출력 예 #2
 * 3, 5가 적힌 스티커를 떼어 냈을 때 8로 최대가 됩니다.
 *
 * 8 14 6 5 11 3 9 2 10
 * 5 1 3 2 5 4
 * 5 1 2 3 5 4
 * 5 1 10 1 5 10
 */
public class Test06 {
    static int maxSum(int sticker[]) {

        int len = sticker.length;

        if(len == 1) {
            return sticker[0];
        } else if(len == 2) {
            return Math.max(sticker[0], sticker[1]);
        } else if(len == 3) {
            return Math.max(Math.max(sticker[0], sticker[1]), sticker[2]);
        }

        int[] D = new int[len];
        D[0] = sticker[0];
        D[1] = sticker[1];
        D[2] = sticker[2];

        for(int i=3; i<len; i++) {
            if(i == 3) {
                D[i] = sticker[1] + sticker[3];
                continue;
            }
            D[i] = Math.max(D[i-2], D[i-3]) + sticker[i];
        }

        return Math.max(D[len-2], D[len-1]);
    }

    public static int solution(int sticker[]) {
        /**
         * sticker[0]에서 시작할 경우
         * or
         * sticker[1]에서 시작할 경우
         *
         * D[i] = D[i-2] + sticker[i]
         * D[i] = D[i-3] + sticker[i]
         *
         * D[i] = max(D[i-2], D[i-3]) + sticker[i]
         */

        int answer = 0;

        int[] A = sticker;
        int[] B = new int[sticker.length];

        for(int i=0; i<sticker.length; i++) {
            if(i == sticker.length-1) {
                B[i] = A[0];
                break;
            }
            B[i] = A[i+1];
        }

        answer = Math.max(maxSum(A), maxSum(B));

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] sticker = new int[n];
        for(int i=0; i<n; i++) {
            sticker[i] = sc.nextInt();
        }

        System.out.println(solution(sticker));
    }
}
