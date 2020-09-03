package algorithm.codility;

public class Lesson09_01 {

    public static int solution(int[] A) {
        int answer = 0;

        if (A.length == 0) {
            return 0;
        }

        if (A.length == 1) {
            return 0;
        }

        int[] sumArray = new int[A.length-1];
        sumArray[0] = A[1] - A[0];
        int totalSum = sumArray[0];
        for (int i = 2; i < A.length ; i++) {
            sumArray[i-1] = A[i] - A[i-1];
            if (totalSum + sumArray[i-1] <= 0) {
                answer = Math.max(answer, totalSum);
                totalSum = sumArray[i-1];
            } else {
                totalSum += sumArray[i-1];
            }
        }

        answer = Math.max(answer, totalSum);

        return answer;
    }

    public static void main(String[] args) {
        int[] A = {23171, 21011, 21123, 21366, 21013, 21367};
        System.out.println(solution(A));
        int[] B = {4, 3, 2, 1, 2, 3, 4};
        System.out.println(solution(B));
        int[] C = {1,0};
        System.out.println(solution(C));
        int[] D = {0,1};
        System.out.println(solution(D));
        int[] F = {0,1,2,3,4,5,6};
        System.out.println(solution(F));
    }

}
