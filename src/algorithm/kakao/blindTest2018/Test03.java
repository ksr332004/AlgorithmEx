package algorithm.kakao.blindTest2018;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Seran on 2017-09-16.
 */
public class Test03 {
    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;

        Queue<String> queue = new LinkedList<String>();

        for(int i=0; i<cities.length; i++) {
            if(queue.contains(cities[i].toUpperCase())) {
                answer += 1;
                queue.remove(cities[i].toUpperCase());
            } else {
                answer += 5;
            }
            if(cacheSize > 0) {
                if(queue.size() >= cacheSize) {
                    queue.poll();
                }
                queue.add(cities[i].toUpperCase());
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cacheSize = sc.nextInt();
        int n = sc.nextInt();
        String[] cities = new String[n];
        for(int i=0; i<n; i++) {
            cities[i] = sc.next();
        }

        System.out.println(solution(cacheSize, cities));
    }
}
