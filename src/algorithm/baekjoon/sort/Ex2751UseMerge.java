package algorithm.baekjoon.sort;

import java.util.Scanner;

/**
 * Created by Seran on 2017-09-16.
 * https://www.acmicpc.net/problem/2751
 * [수 정렬하기 2]
 * (해결)
 * Merge Sort 이용
 */
public class Ex2751UseMerge {
    static int[] merge(int s[], int stsrtIndex, int middleIndex, int endIndex) {
        int leftIndex = stsrtIndex;
        int rightIndex = middleIndex + 1;
        int destIndex = 0;

        int[] d = new int[endIndex - stsrtIndex + 1];

        while(leftIndex <= middleIndex
                && rightIndex <= endIndex) {
            if(s[leftIndex] < s[rightIndex]) {
                d[destIndex] = s[leftIndex];
                leftIndex++;
            } else {
                d[destIndex] = s[rightIndex];
                rightIndex++;
            }
            destIndex++;
        }

        while(leftIndex <= middleIndex) {
            d[destIndex++] = s[leftIndex++];
        }
        while(rightIndex <= endIndex) {
            d[destIndex++] = s[rightIndex++];
        }

        destIndex = 0;
        for(int i=stsrtIndex; i<=endIndex; i++) {
            s[i] = d[destIndex++];
        }

        return s;
    }


    static int[] merge_sort(int s[], int stsrtIndex, int endIndex){
        int middleIndex;

        if(endIndex - stsrtIndex < 1) {
            return s;
        }

        middleIndex = (stsrtIndex + endIndex) / 2;

        merge_sort(s, stsrtIndex, middleIndex);
        merge_sort(s, middleIndex + 1, endIndex);

        merge(s, stsrtIndex, middleIndex, endIndex);
        return s;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int[] numbers = new int[n];
        for(int i=0; i<n; i++) {
            numbers[i] = Integer.parseInt(sc.nextLine());
        }

        int[] answer = merge_sort(numbers, 0, n-1);
        for (int i=0; i<answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
}
