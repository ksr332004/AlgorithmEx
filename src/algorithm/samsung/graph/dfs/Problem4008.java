package algorithm.samsung.graph.dfs;

import java.io.File;
import java.util.Scanner;

/**
 * Created by Administrator on 2018-04-13.
 * 4008. [모의 SW 역량테스트] 숫자 만들기
 */
public class Problem4008 {
    static int[] C;
    static int[] NUM;
    static int min;
    static int max;

    static void makeCase(int step, int sum) {
        if (step >= NUM.length-1) {
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            return;
        }

        for (int i=0; i<C.length; i++) {
            if (C[i] == 0) {
                continue;
            }

            C[i]--;
            if (i == 0) {
                makeCase(step+1, sum + NUM[step+1]);
            } else if (i == 1) {
                makeCase(step+1, sum - NUM[step+1]);
            } else if (i == 2) {
                makeCase(step+1, sum * NUM[step+1]);
            } else if (i == 3) {
                makeCase(step+1, sum / NUM[step+1]);
            }
            C[i]++;
        }
    }

    public static void main(String[] args) throws Exception {
        String myFile = Problem4008.class.getResource("").getPath();
        File file = new File(myFile + "../../input/", "input.txt");

        Scanner sc = new Scanner(file);

        // 총 테스트 케이스
        int T = sc.nextInt();

        for (int test_case=1; test_case<=T; test_case++) {
            // 숫자의 개수
            int N = sc.nextInt();
            // 총 연산자의 개수
            int M  = N-1;
            // 주어진 연산자 각각의 개수
            C = new int[4];
            for (int i=0; i<4; i++) {
                C[i] = sc.nextInt();
            }
            // 수식에 사용되는 숫자
            NUM = new int[N];
            for (int i=0; i<N; i++) {
                NUM[i] = sc.nextInt();
            }

            min = 100000001;
            max = -100000001;

            makeCase(0, NUM[0]);

            System.out.println("#" + test_case + " " + (max-min));
        }
    }
}
