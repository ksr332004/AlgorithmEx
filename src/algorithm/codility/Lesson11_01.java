package algorithm.codility;

import java.util.ArrayList;
import java.util.List;

public class Lesson11_01 {

    public static int[] solution(int N, int[] P, int[] Q) {
        List<Integer> primes = new ArrayList<>();
        if (N > 1) {
            primes.add(2);
        }
        for (int i = 2; i <= N/2; i++) {
            for (int j = 0; j <primes.size() ; j++) {
                if (i%primes.get(j) == 0) {
                    break;
                }
                if (j+1 == primes.size()) {
                    primes.add(i);
                }
            }
        }

        int[] semiprimes = new int[N+1];
        for (int i : primes) {
            for (int j : primes) {
                if (i*j > N) {
                    break;
                }
                semiprimes[i*j] = 1;
            }
        }

        int semiprimesCnt = 0;
        for (int i = 1; i < semiprimes.length ; i++) {
            if (semiprimes[i] > 0) {
                semiprimesCnt++;
            }
            semiprimes[i] = semiprimesCnt;
        }

        int[] answers = new int[P.length];
        for (int i = 0; i <answers.length ; i++) {
            answers[i] += semiprimes[Q[i]] - semiprimes[P[i]-1];
        }

        return answers;
    }

    public static void main(String[] args) {
        int[] P1 = {1};
        int[] Q1 = {1};
        System.out.println(solution(1, P1, Q1));
        int[] P = {1, 4, 16};
        int[] Q = {26, 10, 20};
        System.out.println(solution(26, P, Q));
    }
}
