package go.there.soon.ctci.ch8.q14;

import java.util.HashMap;
import java.util.Map;

public class BooleanEvaluation {

	public static void main(String[] args) {
		String s = "0&0&0&1^1|0"; 
		boolean result = true;
		Map<String, Integer> map = new HashMap<String, Integer>();
		int countEval = countEval(s, result, map);
		System.out.println("countEval(" + s + ", " + result + ") = " + countEval);
	}
	
	public static int countEval(String s, boolean result, Map<String, Integer> map) {
		if(s.length() == 0) return 0;
		if(s.length() == 1) return stringToBool(s) == result ? 1 : 0;
		
		if(map.containsKey(result + s))
			return map.get(result + s);
		
		int ways = 0;
		
		for(int i = 1; i < s.length(); i+=2) {
			char ch = s.charAt(i);
			String left = s.substring(0, i);
			String right = s.substring(i+1, s.length());
			
			int leftTrue = countEval(left, true, map);
			int leftFalse = countEval(left, false, map);
			int rightTrue = countEval(right, true, map);
			int rightFalse = countEval(right, false, map);
			
			int total = (leftTrue + leftFalse) * (rightTrue + rightFalse);
			int totalTrue = 0;
			
			if(ch == '&') {
				totalTrue = leftTrue * rightTrue;
			} else if(ch == '|') {
				totalTrue = leftTrue * rightFalse + leftFalse * rightTrue + leftTrue * rightTrue; 
			} else if(ch == '^') {
				totalTrue = leftTrue * rightFalse + leftFalse * rightTrue;
			}
			
			ways += (result ? totalTrue : total - totalTrue);
		}
		
		map.put(result + s, ways);
		return ways;
	}
	
	public static boolean stringToBool(String s) {
		return s.equals("1") ? true: false;
	}
}
