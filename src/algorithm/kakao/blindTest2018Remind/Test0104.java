package algorithm.kakao.blindTest2018Remind;

/**
 * [1차] 프렌즈4블록
 * @author Seran
 *
 */

public class Test0104 {
	
	public static int solution(int m, int n, String[] board) {
		int answer = 0;
		
		char[][] map = new char[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = board[i].charAt(j);
			}
		}
		
		Boolean flag = true;
		while(flag) {
			flag = false;
			
			int[][] check = new int[m][n];
			for (int i = 0; i < m-1; i++) {
				for (int j = 0; j < n-1; j++) {
					if (map[i][j] != '0'
							&& map[i][j] == map[i][j+1]
							&& map[i][j] == map[i+1][j]
							&& map[i][j] == map[i+1][j+1]) {
						check[i][j] = 1;
						check[i][j+1] = 1;
						check[i+1][j] = 1;
						check[i+1][j+1] = 1;
						flag = true;
					}
				}
			}
			
			if (!flag) {
				break;
			}
			
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (check[i][j] == 1) {
						map[i][j] = '0';
						answer++;
					}
				}
			}
			
			for (int j = 0; j < n; j++) {
				String str = "";
				for (int i = m-1; i >= 0; i--) {
					str += map[i][j];
				}
				str = str.replaceAll("0", "");
				for (int i = m-1; i >= 0; i--) {
					map[i][j] = '0';
					if (str.length() >= m-i) {
						map[i][j] = str.charAt(m-i-1);
					}
				}
			}
			
		}
		
		
		
		return answer;
	}

	public static void main(String[] args) {

		String[] A = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
		
		System.out.println(solution(4, 5, A));
		
	}

}
