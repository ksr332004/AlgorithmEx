package algorithm.samsung.recursion;

import java.io.File;
import java.util.Scanner;

/**
 * Created by Administrator on 2018-02-21.
 * 1227. [S/W 문제해결 기본] 7일차 - 미로2
 */
public class Problem1227 {
    static int answer;

    static void recursive(int[][] H, int x, int y) {
        // 미로의 끝지점 확인
        if(H[x][y] == 3) {
            answer = 1;
            return;
        }

        // 지나온 길에 대한 표시
        // (표시하지 않으면 지나온 길을 또 다시 탐색할 수 있기 때문)
        H[x][y] = 2;

        // 왼쪽
        if(H[x][y-1] == 0 || H[x][y-1] == 3) {
            recursive(H, x, y-1);
        }
        // 위
        if(H[x-1][y] == 0 || H[x-1][y] == 3) {
            recursive(H, x-1, y);
        }
        // 오른쪽
        if(H[x][y+1] == 0 || H[x][y+1] == 3) {
            recursive(H, x, y+1);
        }
        // 아래
        if(H[x+1][y] == 0 || H[x+1][y] == 3) {
            recursive(H, x+1, y);
        }
    }

    public static void main(String[] args) throws Exception{
        String myFile = Problem1227.class.getResource("").getPath();
        File file = new File(myFile + "../input/", "input.txt");
        Scanner sc = new Scanner(file);

        int N = 100;
        while (sc.hasNext()) {
            int test_case = sc.nextInt();

            // 시작점 정보 초기화
            int x = 0;
            int y = 0;

            // 미로 정보
            int[][] H = new int[N][N];
            for(int i=0; i<N; i++) {
                String s = sc.next();
                for(int j=0; j<N; j++) {
                    H[i][j] = Character.getNumericValue(s.charAt(j));

                    // 미로의 시작점 구하기
                    if(H[i][j] == 2) {
                        x = i;
                        y = j;
                    }
                }
            }

            answer = 0;

            recursive(H, x, y);

            System.out.println("#" + test_case + " " + answer);
        }
    }
}