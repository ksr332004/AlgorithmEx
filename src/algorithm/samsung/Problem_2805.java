package algorithm.samsung;

import java.io.File;
import java.util.Scanner;

/**
 * Created by Administrator on 2018-01-18.
 * 2805. 농작물 수확하기
 */
public class Problem_2805 {

    public static void main(String[] args) throws Exception {
        String myFile = "D:\\workspace\\AlgorithmEx\\src\\samsungSWExpertAcademy\\input\\";
        File file = new File(myFile, "input.txt");

        Scanner sc = new Scanner(file);

        int T = sc.nextInt();
        for (int test_case=1; test_case<=T; test_case++) {
            int size = sc.nextInt();
            int[][] farm = new int[size+1][size+1];
            for (int i=1; i<=size; i++) {
                String s = sc.next();
                for (int j=1; j<=size; j++) {
                    farm[i][j] = Integer.parseInt(s.substring(j-1, j));
                }
            }

            int answer = 0;
            int mid = (size/2) + 1;
            int s=1, e=size;
            while (s != e) {
                answer += farm[s][mid];
                answer += farm[e][mid];
                for(int i=1; i<s; i++) {
                    answer += farm[s][mid-i];
                    answer += farm[s][mid+i];
                    answer += farm[e][mid-i];
                    answer += farm[e][mid+i];
                }
                s++;
                e--;
            }

            for(int i=1; i<=size; i++) {
                answer += farm[mid][i];
            }

            System.out.println("#" + test_case + " " + answer);
        }
    }
}
