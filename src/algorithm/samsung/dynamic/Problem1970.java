package algorithm.samsung.dynamic;

import java.io.File;
import java.util.Scanner;

/**
 * Created by Administrator on 2018-02-21.
 * 1970. 쉬운 거스름돈
 */
public class Problem1970 {
    public static void main(String[] args) throws Exception {
        String myFile = Problem1970.class.getResource("").getPath();
        File file = new File(myFile + "../input/", "input.txt");
        Scanner sc = new Scanner(file);

        int T = sc.nextInt();
        for(int test_case=1; test_case<=T; test_case++) {
            // 거슬러 주어야 할 금액 N
            int N = sc.nextInt();
            //


            System.out.println("#" + test_case + " ");
        }
    }
}
