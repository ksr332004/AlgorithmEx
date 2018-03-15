package algorithm.samsung.backtracking;

import java.io.File;
import java.util.Scanner;

/**
 * Created by Administrator on 2018-02-21.
 * 1970. 쉬운 거스름돈
 */
public class Problem1970 {
    // 거슬러 주어야 할 금액
    static int N;
    // 돈의 단위
    // (주어진 조건은 10 단위까지 지만 주어지는 금액 단위는 1 단위까지 이기 때문에 임의로 설정,
    // 출력할때는 1 단위 제외)
    static int[] currencys = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    // 정답
    static int[] answer;

    // tracking 여부를 판단하는 함수
    // 이전 거스름돈 개수와 비교하여 개수가 적으면 tracking 진행
    // 아니면 tracking 더 이상 진행하지 않음
    static boolean isPromising(int[] changes) {
        int a = 0;
        int c = 0;

        for (int i=0; i<currencys.length; i++) {
            a += answer[i];
            c += changes[i];
        }

        return !(a != 0 && c > a);
    }

    // backtracking 함수
    static void backtracking (int money, int[] changes, int index) {
        // 주어진 돈이 0 이 되면 종료 (답을 구함)
        if (money == 0) {
            System.arraycopy(changes, 0, answer, 0, currencys.length);
            return;
        }

        // 단위가 큰 금액부터 시작
        for (int i=index; i<currencys.length; i++) {
            // 주어진 돈보다 단위가 클 경우 pass
            if (money < currencys[i]) {
                continue;
            }

            // 주어진 돈의 범위 내에서 단위 돈으로 제외 시킬수 있을 만큼 제외
            changes[i] = money / currencys[i];

            if (!isPromising(changes)) {
                return;
            } else {
                backtracking(money-(currencys[i]*changes[i]), changes, i);
                changes[i] = 0;
            }
        }
    }

    public static void main (String[] args) throws Exception {
        String myFile = Problem1970.class.getResource("").getPath();
        File file = new File(myFile + "../input/", "input.txt");
        Scanner sc = new Scanner(file);

        int T = sc.nextInt();
        for (int test_case=1; test_case<=T; test_case++) {
            // 거슬러 주어야 할 금액 초기화
            N = sc.nextInt();
            // 잔돈 개수
            int[] changes = new int[currencys.length];
            // 정답 초기화
            answer = new int[currencys.length];

            backtracking(N, changes, 0);

            // 정답 출력
            System.out.println("#" + test_case);
            for (int i=0; i<currencys.length-1; i++) {
                System.out.print(answer[i] + " ");
            }
            System.out.println();
        }
    }
}
