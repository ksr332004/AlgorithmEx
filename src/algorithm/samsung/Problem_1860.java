package algorithm.samsung;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Seran on 2017-09-30.
 * 1860. 진기의 최고급 붕어빵
 */
public class Problem_1860 {

    public static void main(String args[]) throws Exception {
        String myFile = "C:\\workspace\\AlgorithmEx\\src\\samsungSWExpertAcademy\\input\\";
        File file = new File(myFile, "week01_02.txt");

        Scanner sc = new Scanner(file);
        
        int T = sc.nextInt();
        for(int test_case = 0; test_case < T; test_case++) {
        	String Answer = "Possible";
        	
        	int N = sc.nextInt(); // 손님수
        	int M = sc.nextInt(); // 만드는데 걸리는 시간
        	int K = sc.nextInt(); // 한번에 만들어지는 개수
        	
        	int t = 11111;
        	int[] timestamp = new int[t+1];
        	
        	for(int i=0; i<N; i++) {
        		timestamp[sc.nextInt()] += -1;
        	}
        	
        	for(int i=0; i<=t; i++) {
        		if(i>0 && i%M == 0) {
        			timestamp[i] += K; 
        		}
        		if(i != 0) {
        			timestamp[i] += timestamp[i-1];
        		}
        		if(timestamp[i] < 0) {
        			Answer = "Impossible";
        			break;
        		}
        	}
        	
        	System.out.println("#" + (test_case+1) + " " + Answer);
        }
    }
}
