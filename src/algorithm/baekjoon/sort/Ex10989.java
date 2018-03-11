package algorithm.baekjoon.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;

/**
 * Created by Administrator on 2017-09-11.
 * https://www.acmicpc.net/problem/10989
 * [수 정렬하기 3]
 * 퀵 정렬 시간초과
 * Scanner 시간초과
 * numbers에 대한 크기를 지정해 줘야 런타임 에러가 없음
 */
public class Ex10989 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        int[] numbers = new int[10001];
        for (int i=0; i<n; i++) {
            numbers[Integer.parseInt(reader.readLine())] ++;
        }

        for (int i=1; i<=10000; i++) {
            if (numbers[i] > 0) {
                for (int j=0; j<numbers[i]; j++) {
                    writer.write(i + "\n");
                }
            }
        }

        reader.close();
        writer.close();
    }
}
