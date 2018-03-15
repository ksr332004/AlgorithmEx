package algorithm.baekjoon.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by Administrator on 2018-03-15.
 * 11004. K번째 수
 * 퀵정렬로 풀기
 */
public class Ex11004 {
    static void swap(int[] A, int a, int b) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }

    static void quicksort(int[] A) {

    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String s1 = reader.readLine();
        // 숫자 리스트의 개수
        int N = Integer.parseInt(s1.split(" ")[0]);
        // 구해야 하는 위치
        int K = Integer.parseInt(s1.split(" ")[1]);

        String s2 = reader.readLine();
        // 숫자 리스트
        int[] A = new int[N];
        for (int i=0; i<N; i++) {
            A[i] = Integer.parseInt(s1.split(" ")[i]);
        }

        // 퀵정렬
        quicksort(A);

        // 정답 출력
        writer.write(A[K-1]);

        reader.close();
        writer.close();
    }
}
