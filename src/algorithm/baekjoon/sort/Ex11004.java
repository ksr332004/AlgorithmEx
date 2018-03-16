package algorithm.baekjoon.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * Created by Administrator on 2018-03-15.
 * 11004. K번째 수
 * 퀵정렬로 풀기
 * StringTokenizer vs split
 * 동적할당의 경우에는 다이나믹 바인딩이기 때문에 상대적으로 시간 낭비가 더 커 시간 초과의 경우가 더 많다
 */
public class Ex11004 {
    // swap 함수
    static void swap(int[] A, int a, int b) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }

    // 퀵정렬 함수
    static void quicksort(int[] A, int start, int end) {
        int pivot = end;
        int s = start;
        int e = end - 1;

        // 정렬 크기가 0일 경우
        if (s > e) {
            return;
        }

        // 정렬 크기가 2일 경우
        if (s == e) {
            if (A[pivot] < A[s]) {
                swap(A, pivot, s);
            }
            return;
        }

        // 정렬 크기가 3 이상일 경우
        while (s <= e) {
            if (A[s] > A[pivot] && A[e] < A[pivot]) {
                swap(A, s, e);
            }

            if (A[s] <= A[pivot]) {
                s++;
            }

            if (A[e] >= A[pivot]) {
                e--;
            }
        }

        // pivot 위치로 swap
        swap(A, pivot, s);

        quicksort(A, start, s-1);
        quicksort(A, s+1, end);
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
        StringTokenizer tokenizer = new StringTokenizer(s2);
        // 숫자 리스트
        int[] A = new int[5000001];
        int i = 0;
        while (tokenizer.hasMoreTokens()) {
            A[i] = Integer.parseInt(tokenizer.nextToken());
            i++;
        }

        // 퀵정렬
        quicksort(A, 0, N-1);

        // 정답 출력
        writer.write(A[K-1] + "\n");

        reader.close();
        writer.close();
    }
}