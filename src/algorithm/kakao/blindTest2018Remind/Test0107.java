package algorithm.kakao.blindTest2018Remind;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * [1차] 다트 게임
 * @author Seran
 *
 */

public class Test0107 {
	
	public static int solution(String dartResult) {
		int answer = 0;
		
		Matcher matcher = Pattern.compile("([0-9]+[SDT][*#]*)").matcher(dartResult);

		int preScore = 0;
		while (matcher.find()) {
			int nowScore = 0;
			
			String str = matcher.group();
			
			Matcher matcher1 = Pattern.compile("([0-9]+)").matcher(str);
			if (matcher1.find()) {
				nowScore = Integer.parseInt(matcher1.group());
			}

			Matcher matcher2 = Pattern.compile("([SDT])").matcher(str);
			if (matcher2.find()) {
				String s1 = matcher2.group();
				if (s1.equals("D")) {
					nowScore = nowScore * nowScore;
				} else if (s1.equals("T")) {
					nowScore = nowScore * nowScore * nowScore;
				}
			}
			
			Matcher matcher3 = Pattern.compile("([*#])").matcher(str);
			if (matcher3.find()) {
				if (matcher3.group().equals("*")) {
					preScore = preScore * 2;
					nowScore = nowScore * 2;
				} else {
					nowScore = nowScore*(-1);
				}
			}
			
			answer += preScore;
			preScore = nowScore;
		}
		
		answer += preScore;
		
		return answer;
	}

	public static void main(String[] args) {
		
		System.out.println(solution("1D2S#10S"));
		
	}

}
