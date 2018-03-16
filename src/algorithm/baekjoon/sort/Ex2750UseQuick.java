package algorithm.baekjoon.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by Administrator on 2018-03-16.
 * 2750. 수 정렬하기
 * https://www.acmicpc.net/problem/2750
 */
public class Ex2750UseQuick {
    static void swap(int[] A, int a, int b) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }

    static void quicksort(int[] A, int start, int end) {
        int pivot = end;
        int s = start;
        int e = end - 1;

        if (s > e) {
            return;
        }

        if (s == e) {
            if (A[pivot] < A[s]) {
                swap(A, pivot, s);
            }
            return;
        }

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

        swap(A, pivot, s);

        quicksort(A, start, s-1);
        quicksort(A, s+1, end);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        // 숫자 리스트의 개수
        int N = Integer.parseInt(reader.readLine());

        // 숫자 리스트
        int[] A = new int[N];
        for (int i=0; i<N; i++) {
            A[i] = Integer.parseInt(reader.readLine());
        }

        // 퀵정렬
        quicksort(A, 0, N-1);

        // 정답 출력
        for (int i=0; i<N; i++) {
            writer.write(A[i] + "\n");
        }

        reader.close();
        writer.close();
    }
}
