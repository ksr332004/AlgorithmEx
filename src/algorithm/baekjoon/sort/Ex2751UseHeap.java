package algorithm.baekjoon.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by Administrator on 2018-03-15.
 * 2751. 수 정렬하기 2
 * 힙정렬로 풀기
 * ArrayList 이용
 */
public class Ex2751UseHeap {
    // swap 함수
    static void swap(int[] H, int a, int b) {
        int temp = H[a];
        H[a] = H[b];
        H[b] = temp;
    }

    // 주어진 조건을 최대힙 구조로 만드는 함수
    // (H = 주어진 리스트, parent = 부모노드의 인덱스, N = 최대힙을 만들 사이즈(범위))
    static void maxHeapify(int[] H, int parent, int N) {
        int leftChild = parent*2;
        int rightChild = (parent*2) + 1;

        // 자식노드가 하나도 없는 경우
        if (leftChild > N) {
            return;
        }

        // 자식노드가 하나만 남았을 경우 (자식노드가 왼쪽에만 있는 경우)
        if (rightChild > N) {
            if (H[parent] < H[leftChild]) {
                swap(H, parent, leftChild);
            }
            return;
        }

        // 부모노드가 자식노드보다 작을 경우
        if ((H[parent]) < H[leftChild] || (H[parent] < H[rightChild])) {
            if (H[leftChild] >= H[rightChild]) {
                swap(H, parent, leftChild);
                maxHeapify(H, leftChild, N);
            } else {
                swap(H, parent, rightChild);
                maxHeapify(H, rightChild, N);
            }
        }
    }

    // 최대힙 속성을 만족하도록 정렬하는 함수
    static void buildMaxHeap(int[] H) {
        int N = H.length-1;
        // 리스트의 중간부터 max heapify 시작
        int mid = N/2;
        for (int i=mid; i>0; i--) {
            maxHeapify(H, i, N);
        }
    }

    // 힙정렬 메인 함수
    static void heapsort(int[] H) {
        int N = H.length-1;

        buildMaxHeap(H);

        for (int i=N; i>1; i--) {
            swap(H, 1, i);
            maxHeapify(H, 1, i-1);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력 받을 숫자 개수
        int N = Integer.parseInt(reader.readLine());
        // 정렬되지 않는 수들
        int[] H = new int[N+1];
        for (int i=1; i<=N; i++) {
            H[i] = Integer.parseInt(reader.readLine());
        }

        // 힙정렬
        heapsort(H);

        // 정답 출력
        for (int i=1; i<=N; i++) {
            writer.write(H[i] + "\n");
        }

        reader.close();
        writer.close();
    }
}