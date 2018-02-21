package algorithm.samsung.queue;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Administrator on 2018-02-21.
 * 1225. [S/W 문제해결 기본] 7일차 - 암호생성기
 */
public class Problem1225 {
    public static void main(String[] args) throws Exception {
        String myFile = Problem1225.class.getResource("").getPath();
        File file = new File(myFile + "../input/", "input.txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNext()) {
            int test_case = sc.nextInt();

            // 주어지는 8개의 숫자
            Queue<Integer> A = new LinkedList<Integer>();
            for (int i=0; i<8; i++) {
                A.add(sc.nextInt());
            }

            int count = 1;
            // 숫자들 중 0을 포함하지 않을 때만 while문을 수행
            while (!A.contains(0)) {
                // 첫번째 숫자를 꺼내 맨 뒤 위치로 숫자를 넣음
                // 이때, 숫자 감소시 음수면 0으로 치환
                int t = A.poll() - count;
                t = (t < 0) ? 0 : t;
                A.offer(t);

                count++;
                count = (count == 6) ? 1 : count;
            }

            System.out.print("#" + test_case + " ");
            while (!A.isEmpty()) {
                System.out.print(A.poll() + " ");
            }
            System.out.println();
        }
    }
}
