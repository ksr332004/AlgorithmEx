package algorithm.codility;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Lesson07_01 {
    public static int solution(String S) {
        int answer = 1;

        if (S.length() == 1) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        map.put('{', 1);
        map.put('[', 2);
        map.put('(', 3);
        map.put(')', -3);
        map.put(']', -2);
        map.put('}', -1);


        Stack<Character> temp = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if ('{' == S.charAt(i)
                || '[' == S.charAt(i)
                || '(' == S.charAt(i)) {
                temp.push(S.charAt(i));
            } else {
                if (temp.size() == 0 || map.get(S.charAt(i)) + map.get(temp.peek()) != 0) {
                    answer = 0;
                    break;
                } else {
                    temp.pop();
                }
            }
        }

        if (temp.size() > 0) {
            return 0;
        }

        return answer;
    }

    public static void main(String[] args) {

        System.out.println(solution("()()()()()("));
        System.out.println(solution("((((("));
        System.out.println(solution("{[()]}"));
        System.out.println(solution("{[()()]}"));
        System.out.println(solution("([)()]"));

    }

}
