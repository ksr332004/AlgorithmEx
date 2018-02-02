package algorithm.samsung.etc;

import java.io.File;
import java.util.Scanner;

/**
 * Created by Administrator on 2017-09-26.
 * 1859. 백만 장자 프로젝트
 */
public class Problem1859 {
    // 최대값 찾는 함수
    static int findMax(int[] A, int index) {
        int max = A[index];
        for(int i=index+1; i<A.length; i++) {
            if(max < A[i]) {
                max = A[i];
            }
        }
        return max;
    }

    public static void main(String args[]) throws Exception	{
        String myFile = Problem1859.class.getResource("").getPath();
        File file = new File(myFile + "../input/", "input.txt");

        Scanner sc = new Scanner(file);

        int T = sc.nextInt();
        for(int test_case = 0; test_case < T; test_case++) {
            int size = sc.nextInt();
            int[] A = new int[size];
            for(int i=0; i<size; i++) {
                A[i] = sc.nextInt();
            }

            /**
             * 1. 최대값을 찾고 최대값이 나오기 전까지 현재값과 최대값의 차이를 더함
             * 2. 최대값이 발견된 그 이후의 배열값에서 최대값을 찾음
             * 3. 1번과 2번은 무한히 반복(주어진 배열값이 끝날때 까지)
             */
            long Answer = 0;
            int i = 0;
            while(i < size) {
                int max = findMax(A, i);
                int j = i;
                while (A[j] != max) {
                    Answer += (max - A[j]);
                    j++;
                }
                i = j + 1;
            }

            System.out.println("#" + (test_case+1) + " " + Answer);
        }
    }
}
