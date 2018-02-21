package algorithm.samsung.search;

import java.io.File;
import java.util.Scanner;

/**
 * Created by Administrator on 2018-02-21.
 * 1486. 장훈이의 높은 선반
 */
public class Problem1486 {
    static int answer;

    static void recursive(int[] H, int B, int idx, int sum) {
        for(int i=idx; i<H.length; i++) {
            // 점원들의 키의 합이 선반 높이 B를 넘는 순간
            // 선반 높이에 근접한 값을 가지고 있는 answer 값과 비교하여 answer 값을 갱신
            if(H[i] + sum >= B) {
                // answer가 초기 값(-1)을 가지고 있다면 값 갱신
                if(answer == -1) {
                    answer = H[i] + sum - B;
                } else if((H[i] + sum -B) < answer) {
                    answer = H[i] + sum - B;
                }
            } else {
                recursive(H, B, i+1, H[i] + sum);
            }
        }
    }

    public static void main(String[] args) throws Exception{
        String myFile = Problem1486.class.getResource("").getPath();
        File file = new File(myFile + "../input/", "input.txt");
        Scanner sc = new Scanner(file);

        int T = sc.nextInt();
        for(int test_case=1; test_case<=T; test_case++) {
            answer = -1;

            // 점원들의 수
            int N = sc.nextInt();
            // 선반의 높이
            int B = sc.nextInt();

            // 점원들의 키
            int[] H = new int[N];
            for(int i=0; i<N; i++) {
                H[i] = sc.nextInt();
            }

            recursive(H, B, 0, 0);

            System.out.println("#" + test_case + " " + answer);
        }
    }
}
