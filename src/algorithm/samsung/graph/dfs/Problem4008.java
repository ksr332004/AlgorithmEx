package algorithm.samsung.graph.dfs;

import java.io.File;
import java.util.Scanner;

/**
 * Created by Administrator on 2018-04-13.
 * 4008. [모의 SW 역량테스트] 숫자 만들기
 */
public class Problem4008 {
    static int[] C;
    static int[] TEMP;
    static int[] NUM;
    static int min;
    static int max;

    static void makeCase(int step, int sum) {
        if (step >= C.length) {
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            return;
        }

        for (int i=0; i<C.length; i++) {
            if (TEMP[i] == 1) {
                continue;
            }
            if (step == 0 && i > 0 && C[i] == C[i-1]) {
                continue;
            }

            TEMP[i] = 1;
            if (C[i] == 0) {
                makeCase(step + 1, sum + NUM[step+1]);
            } else if (C[i] == 1) {
                makeCase(step + 1, sum - NUM[step+1]);
            } else if (C[i] == 2) {
                makeCase(step + 1, sum * NUM[step+1]);
            } else if (C[i] == 3) {
                makeCase(step + 1, sum / NUM[step+1]);
            }
            TEMP[i] = 0;
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
            C = new int[M];
            int a = 0;
            for (int i=0; i<4; i++) {
                int t = sc.nextInt();
                for (int j=0; j<t; j++) {
                    C[a] = i;
                    a++;
                }
            }
            // 수식에 사용되는 숫자
            NUM = new int[N];
            for (int i=0; i<N; i++) {
                NUM[i] = sc.nextInt();
            }

            TEMP = new int[M];
            min = 100000001;
            max = -100000001;

            makeCase(0, NUM[0]);

            System.out.println("#" + test_case + " " + (max-min));
        }
    }
}
