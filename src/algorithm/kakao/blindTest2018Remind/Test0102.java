package algorithm.kakao.blindTest2018Remind;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * [1차] 뉴스 클러스터링
 * @author Seran
 * (정규표현식 URL)http://highcode.tistory.com/6
 */

public class Test0102 {
	
	public static int solution(String str1, String str2) {
	    int answer = 0;
	    
	    str1 = str1.toUpperCase();
	    str2 = str2.toUpperCase();
	    
	    ArrayList<String> A = new ArrayList<>();
	    ArrayList<String> B = new ArrayList<>();
	    
	    Matcher matcher;
	    
	    for (int i = 0; i < str1.length()-1; i++) {
			String a = str1.substring(i, i+2);
			matcher = Pattern.compile("(^[a-zA-Z]*$)").matcher(a);
			if (matcher.find()) {
				A.add(a);
			}
		}
	    
	    for (int i = 0; i < str2.length()-1; i++) {
	    	String b = str2.substring(i, i+2);
	    	matcher = Pattern.compile("(^[a-zA-Z]*$)").matcher(b);
			if (matcher.find()) {
				B.add(b);
			}
		}
	    
	    if (A.isEmpty() && B.isEmpty()) {
	    	return 1 * 65536;
	    }
	    
	    ArrayList<String> AND = new ArrayList<>();
	    ArrayList<String> OR = new ArrayList<>();
	    
	    while(!B.isEmpty()) {
	    	if (A.contains(B.get(0))) {
	    		AND.add(B.get(0));
	    		A.remove(B.get(0));
	    	}
	    	
	    	OR.add(B.get(0));
	    	B.remove(0);
	    }
	    
	    OR.addAll(A);
	    
	    answer = AND.size() * 65536 / OR.size();
	    
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution("EMC", "ase"));
	}

}
