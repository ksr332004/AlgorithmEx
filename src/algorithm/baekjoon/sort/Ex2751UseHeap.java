package algorithm.baekjoon.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Administrator on 2018-03-15.
 * 2751. 수 정렬하기 2
 * 힙정렬로 풀기
 * ArrayList 이용
 */
public class Ex2751UseHeap {
    // 주어진 조건을 최대힙 구조로 만드는 함수
    // (H = 주어진 리스트, parent = 부모노드의 인덱스, N = 최대힙을 만들 사이즈(범위))
    static void maxHeapify(ArrayList<Integer> H, int parent, int N) {
        int leftChild = parent*2;
        int rightChild = (parent*2) + 1;

        // 자식노드가 하나도 없는 경우
        if (leftChild > N) {
            return;
        }

        // 자식노드가 하나만 남았을 경우 (자식노드가 왼쪽에만 있는 경우)
        if (rightChild > N) {
            if (H.get(parent) < H.get(leftChild)) {
                Collections.swap(H, parent, leftChild);
            }
            return;
        }

        // 부모노드가 자식노드보다 작을 경우
        if ((H.get(parent) < H.get(leftChild)) || (H.get(parent) < H.get(rightChild))) {
            if (H.get(leftChild) >= H.get(rightChild)) {
                Collections.swap(H, parent, leftChild);
                maxHeapify(H, leftChild, N);
            } else {
                Collections.swap(H, parent, rightChild);
                maxHeapify(H, rightChild, N);
            }
        }
    }

    // 최대힙 속성을 만족하도록 정렬하는 함수
    static void buildMaxHeap(ArrayList<Integer> H) {
        int N = H.size()-1;
        // 리스트의 중간부터 max heapify 시작
        int mid = N/2;
        for (int i=mid; i>0; i--) {
            maxHeapify(H, i, N);
        }
    }

    // 힙정렬 메인 함수
    static void heapsort(ArrayList<Integer> H) {
        int N = H.size()-1;

        buildMaxHeap(H);

        for (int i=N; i>1; i--) {
            Collections.swap(H, 1, i);
            maxHeapify(H, 1, i-1);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력 받을 숫자 개수
        int N = Integer.parseInt(reader.readLine());
        // 정렬되지 않는 수들
        ArrayList<Integer> H = new ArrayList<Integer>();
        H.add(0);
        for (int i=0; i<N; i++) {
            H.add(Integer.parseInt(reader.readLine()));
        }

        // 힙정렬
        heapsort(H);

        // 정답 출력
        for (int i=1; i<=N; i++) {
            writer.write(H.get(i) + "\n");
        }

        reader.close();
        writer.close();
    }
}