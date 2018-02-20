package algorithm.samsung.search;

import java.io.File;
import java.util.Scanner;

/**
 * Created by Administrator on 2018-02-13.
 * 2817. 부분 수열의 합
 * 백준 1182.부분집합의 합과 동일 문제 (https://www.acmicpc.net/problem/1182)
 * [풀이방법]
 * 재귀함수 이용
 */
public class Problem2817 {
    static int answer;

    static void recursive(int[] A,int idx, int K, int sum) {
        // 수열 A를 더한 sum 값과 수열의 합 결과 K값이 같으면 경우의 수를 +1
        if(sum == K) {
            answer++;
            return;
        }

        // 수열 A를 Index 0번부터 수차적으로 더해가면서
        // 더한 sum 값이 수열의 합 결과 K값 보다 작거나 같으면 recursive() 함수를 호출
        for(int i=idx; i<A.length; i++) {
            if(sum + A[i] > K) {
                continue;
            } else {
                recursive(A, i+1, K, sum+A[i]);
            }
        }
    }

    public static void main(String[] args) throws Exception{
        String myFile = Problem2817.class.getResource("").getPath();
        File file = new File(myFile + "../input/", "input.txt");
        Scanner sc = new Scanner(file);

        int T = sc.nextInt();
        for(int test_case=1; test_case<=T; test_case++) {
            answer = 0;

            // 수열의 크기 N, 수의 합 결과 K
            int N = sc.nextInt();
            int K = sc.nextInt();
            // 수열 A
            int[] A = new int[N];
            for(int i=0; i<N; i++) {
                A[i] = sc.nextInt();
            }

            recursive(A, 0, K, 0);

            System.out.println("#" + test_case + " " + answer);
        }
    }
}
