package algorithm.programmers.kakaoPreTest;

import java.util.Scanner;

/**
 * Created by Seran on 2017-09-02.
 * [땅따먹기 게임]
 * 땅따먹기 게임을 하려고 합니다. 땅따먹기 게임의 땅(land)은 총 N행 4열로 이루어져 있고, 모든 칸에는 점수가 쓰여 있습니다.
 * 1행부터 땅을 밟으며 한 행씩 내려올 때, 각 행의 4칸 중 한 칸만 밟으면서 내려와야 합니다.
 * 단, 땅따먹기 게임에는 한 행씩 내려올 때, 같은 열을 연속해서 밟을 수 없는 특수 규칙이 있습니다.
 *
 * 예를 들면,
 *
 * | 1 | 2 | 3 | 5 |
 * | 5 | 6 | 7 | 8 |
 * | 4 | 3 | 2 | 1 |
 *
 * 로 땅이 주어졌다면, 1행에서 네번째 칸 (5)를 밟았으면, 2행의 네번째 칸 (8)은 밟을 수 없습니다.
 *
 * 마지막 행까지 모두 내려왔을 때, 얻을 수 있는 점수의 최대값을 return하는 solution 함수를 완성해 주세요.
 * 위 예의 경우, 1행의 네번째 칸 (5), 2행의 세번째 칸 (7), 3행의 첫번째 칸 (4) 땅을 밟아 16점이 최고점이 되므로 16을 return 하면 됩니다.
 *
 * 제한사항
 * 행의 개수 N : 100,000 이하의 자연수
 * 열의 개수는 4개이고, 땅(land)은 2차원 배열로 주어집니다.
 * 점수 : 100 이하의 자연수
 * 입출력 예
 * land	                          answer
 * [[1,2,3,5],[5,6,7,8],[4,3,2,1]]	16
 * 입출력 예 설명
 * 입출력 예 #1
 * 문제의 예시와 같습니다.
 *
 * 3 1 2 3 5 5 6 7 8 4 3 2 1
 * 
 */
public class Test05 {
    static int solution(int[][] land) {
        /**
         * D[i][0] = max(D[i-1][1], D[i-1][2], D[i-1][3]) + land[i][0]
         * D[i][1] = max(D[i-1][0], D[i-1][2], D[i-1][3]) + land[i][1]
         * D[i][2] = max(D[i-1][0], D[i-1][1], D[i-1][3]) + land[i][2]
         * D[i][3] = max(D[i-1][0], D[i-1][1], D[i-1][2]) + land[i][3]
         */

        int answer = 0;
        int n = land.length;

        int[][] D = new int[n][4];
        D[0][0] = land[0][0];
        D[0][1] = land[0][1];
        D[0][2] = land[0][2];
        D[0][3] = land[0][3];

        for(int i=1; i<n; i++) {
            D[i][0] = Math.max(Math.max(D[i-1][1], D[i-1][2]), D[i-1][3]) + land[i][0];
            D[i][1] = Math.max(Math.max(D[i-1][0], D[i-1][2]), D[i-1][3]) + land[i][1];
            D[i][2] = Math.max(Math.max(D[i-1][0], D[i-1][1]), D[i-1][3]) + land[i][2];
            D[i][3] = Math.max(Math.max(D[i-1][0], D[i-1][1]), D[i-1][2]) + land[i][3];
        }

        answer = Math.max(Math.max(D[n - 1][0], D[n - 1][1]), Math.max(D[n - 1][2], D[n - 1][3]));

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] land = new int[n][4];
        for(int i=0; i<n; i++) {
            for(int j=0; j<4; j++) {
                land[i][j] = sc.nextInt();
            }
        }

        System.out.println(solution(land));
    }
}