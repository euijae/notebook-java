package go.there.soon.leetCode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FB_LetterCombinationPhoneNumber {

	public static void main(String[] args) {
		FB_LetterCombinationPhoneNumber o = new FB_LetterCombinationPhoneNumber();
		o.test();
	}

	public void test() {
		Solution sol = new Solution();
		String digit = "234";
		List<String> list = sol.letterCombinations(digit);
		for(String s: list) {
			System.out.print(s + ", ");
		}
	}
	
	class Solution {
		private Map<String, List<String>> ref = new HashMap<>();
		private String [] map  = {"", "", "abc", 
				"def", "ghi", "jkl", 
				"mno", "pqrs", "tuv", 
				"wxyz"};
		
		public Solution() {
			setRef(map);
		}
		
		public void setRef(String [] map) {
			for(int i = 0; i < map.length; i++) {
				ref.put(String.valueOf(i), Arrays.asList(map[i].split("")));
			}
		}
		
	    public List<String> letterCombinations(String digit) {
	        if(digit == null || digit.length() < 1)
	            return new ArrayList<>();
	        
	        String [] digits = digit.split("");
	        String digitCurr = "";
	        
	        List<String> list = new ArrayList<>();
	        
	        for(int i = 0; i < digits.length; i++) {
	        		if(digitCurr.isEmpty())
	        			digitCurr += digits[i];
	        		else {
	        			List<String> prev = ref.get(digitCurr);
	        			List<String> curr = ref.get(digits[i]);
	        			
	        			list = new ArrayList<>();
	        			
	        			for(String s1 : prev)
	        				for(String s2 : curr)
	        					list.add(s1 + s2);
	        			
	        			digitCurr += digits[i];
	        			ref.put(digitCurr, list);
	        		}
	        }
	        
	        return ref.get(digit);
	    }
	}
}
