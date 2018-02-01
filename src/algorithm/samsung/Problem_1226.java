package algorithm.samsung;

import java.io.File;
import java.util.Scanner;

/**
 * Created by Seran on 2017-10-06.
 */
public class Problem_1226 {
    static int Answer = 0;

    static void solution(int[][] M, int N, int i, int j) {
        if(M[i][j] == 3) {
            Answer = 1;
            return;
        }
        M[i][j] = 2;
        if((j<N && M[i+1][j] == 0) || (j<N && M[i+1][j] == 3)) {
            solution(M, N, i+1, j);
        }
        if((i<N && M[i][j+1] == 0) || (i<N && M[i][j+1] == 3)) {
            solution(M, N, i, j+1);
        }
        if((i>0 && M[i][j-1] == 0) || (i>0 && M[i][j-1] == 3)) {
            solution(M, N, i, j-1);
        }
        if((j>0 && M[i-1][j] == 0) || (j>0 && M[i-1][j] == 3)) {
            solution(M, N, i-1, j);
        }
        M[i][j] = 0;
    }

    public static void main(String[] args) throws Exception {
        String myFile = "C:\\workspace\\AlgorithmEx\\src\\samsungSWExpertAcademy\\input\\";
		File file = new File(myFile, "week02_02_1226.txt");
//		File file = new File(myFile, "test.txt");
        Scanner sc = new Scanner(file);

        while(sc.hasNext()) {
            int test_case = sc.nextInt();
            Answer = 0;
            int N = 16;
            int[][] M = new int[N][N];
            for(int i=0; i<N; i++) {
                String s = sc.next();
                for(int j=0; j<N; j++) {
                    M[i][j] = Integer.parseInt(s.substring(j,j+1));
                }
            }

            solution(M, N, 1,1);

            System.out.println("#" + test_case + " " + Answer);
        }
    }
}
