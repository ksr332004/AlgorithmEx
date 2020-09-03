package algorithm.codility;

import java.util.HashMap;
import java.util.Map;

public class Lesson08_01 {

    // TODO : 다시풀기
    public static int solution(int[] A) {
        if (A.length == 0) {
            return -1;
        }

        if (A.length == 1) {
            return 0;
        }

        int answer = -1;

        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Integer> keyMap = new HashMap<>();

        for (int i = 0; i < A.length ; i++) {
            if (!countMap.isEmpty() && countMap.containsKey(A[i])) {
                countMap.put(A[i], countMap.get(A[i])+1);
                keyMap.put(A[i], i);
            } else {
                countMap.put(A[i], 1);
                keyMap.put(A[i], i);
            }
        }

        Map.Entry<Integer, Integer> result = countMap.entrySet().stream()
                .max((m1, m2) -> m1.getValue().compareTo(m2.getValue())).get();

        if (result.getValue() > A.length/2) {
            answer = keyMap.get(result.getKey());
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] A = {3,4,3,2,3,-1,3,3};
        int[] B = {3,4,1,2};
        int[] C = {3};
        int[] D = {2,2,2,2,2,2};
        System.out.println(solution(A));
        System.out.println(solution(B));
        System.out.println(solution(C));
        System.out.println(solution(D));
    }
}
