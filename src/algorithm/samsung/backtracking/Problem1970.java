package algorithm.samsung.backtracking;

import java.io.File;
import java.util.Scanner;

/**
 * Created by Administrator on 2018-02-21.
 * 1970. 쉬운 거스름돈
 */
public class Problem1970 {
    static int N;
    static int[] currencys = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    static int[] answer;

    private static boolean isPromising(int[] changes) {
        int a = 0;
        int c = 0;

        for (int i=0; i<currencys.length; i++) {
            a += answer[i];
            c += changes[i];
        }

        if (a != 0 && c > a) {
            return false;
        }

        return true;
    }

    static void backtracking (int money, int[] changes, int index) {
        if (money == 0) {
            System.arraycopy(changes, 0, answer, 0, currencys.length);
            return;
        }

        for (int i=index; i<currencys.length; i++) {
            if (money < currencys[i]) {
                continue;
            }

            changes[i] = money / currencys[i];

            if (isPromising(changes)) {
                backtracking(money-(currencys[i]*changes[i]), changes, i);
                changes[i] = 0;
            } else {
                return;
            }
        }
    }

    public static void main (String[] args) throws Exception {
        String myFile = Problem1970.class.getResource("").getPath();
        File file = new File(myFile + "../input/", "input.txt");
        Scanner sc = new Scanner(file);

        int T = sc.nextInt();
        for (int test_case=1; test_case<=T; test_case++) {
            // 거슬러 주어야 할 금액 N
            N = sc.nextInt();
            // 잔돈 개수
            int[] changes = new int[currencys.length];
            // 정답 초기화
            answer = new int[currencys.length];

            backtracking(N, changes, 0);

            System.out.println("#" + test_case);
            for (int i=0; i<currencys.length-1; i++) {
                System.out.print(answer[i] + " ");
            }
            System.out.println();
        }
    }
}
