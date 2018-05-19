package algorithm.samsung.etc;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Administrator on 2018-04-13.
 * 4013. [모의 SW 역량테스트] 특이한 자석
 */
public class Problem4013 {
    static ArrayList<LinkedList<Integer>> M;
    static ArrayList<LinkedList<Integer>> INFO;
    
    static void copyInfo() {
    	INFO = new ArrayList<LinkedList<Integer>>(4);
    	for (int i=0; i<4; i++) {
            LinkedList<Integer> I = new LinkedList<Integer>();
            for (int j=0; j<8; j++) {
                I.addLast(M.get(i).get(j));
            }
            INFO.add(I);
        }
    }
    
    static void turn(int num, int t, int preNum) {
    	if (num < 0 || num > 3) {
			return;
		}
    	
    	if (t == 1) {
			M.get(num).addFirst(M.get(num).getLast());
			M.get(num).removeLast();
		} else {
			M.get(num).addLast(M.get(num).getFirst());
			M.get(num).removeFirst();
		}
    	
    	if (num !=3 && num >= preNum && INFO.get(num).get(2) != INFO.get(num+1).get(6)) {
    		turn(num+1, t*(-1), num);
    	}
    	
    	if (num != 0 && num <= preNum && INFO.get(num).get(6) != INFO.get(num-1).get(2)) {
    		turn(num-1, t*(-1), num);
    	}
    }

    public static void main(String[] args) throws Exception {
        String myFile = Problem4013.class.getResource("").getPath();
        File file = new File(myFile + "../input/", "input.txt");

        Scanner sc = new Scanner(file);

        // 총 테스트 케이스
        int T = sc.nextInt();
        for (int test_case=1; test_case<=T; test_case++) {
            // 주어지는 회전 조건의 횟수
            int K = sc.nextInt();
            // 자석의 정보 (맨 위에서부터 시계방향으로)
            M = new ArrayList<LinkedList<Integer>>(4);
            for (int i=0; i<4; i++) {
                LinkedList<Integer> D = new LinkedList<Integer>();
                for (int j=0; j<8; j++) {
                    D.addLast(sc.nextInt());
                }
                M.add(D);
            }
            copyInfo();

            for (int i=0; i<K; i++) {
                int num = sc.nextInt();
                int t = sc.nextInt();
                turn(num-1, t, num-1);
                copyInfo();
            }

            int answer = 0;
            for (int i = 0; i < 4; i++) {
				answer += M.get(i).get(0) * (int)Math.pow(2, i);
			}
            
            System.out.println("#" + test_case + " " + answer);
        }
    }
}