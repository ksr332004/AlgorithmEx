package algorithm.kakao.blindTest2018Remind;

import java.util.LinkedList;
import java.util.Queue;

/**
 * [1차] 캐시
 * @author Seran
 *
 */

public class Test0105 {
	
	public static int solution(int cacheSize, String[] cities) {
	    int answer = 0;
	    
	    Queue<String> queue = new LinkedList<>();
	    for (int i = 0; i < cities.length; i++) {
	    	String taget = cities[i].toUpperCase();
	    	
	    	if (queue.contains(taget)) {
	    		answer += 1;
	    		queue.remove(taget);
	    	} else {
	    		answer += 5;
	    	}
	    	
	    	if (queue.size() >= cacheSize && !queue.isEmpty()) {
	    		queue.poll();
	    	}
	    	
	    	if (cacheSize > 0) {
	    		queue.add(taget);
	    	}
		}
	    
		return answer;
	}

	public static void main(String[] args) {
//		String[] A = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
		String[] A = {"Jeju", "Jeju", "Jeju"};
		System.out.println(solution(0, A));
	}

}
