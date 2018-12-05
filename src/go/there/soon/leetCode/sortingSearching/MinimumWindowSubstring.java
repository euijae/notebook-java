package go.there.soon.leetCode.sortingSearching;

import java.util.HashMap;

public class MinimumWindowSubstring {

	public static void main(String[] args) {
		String s = "babad";
		System.out.println(s.substring(0, s.length()-4));
		System.out.println(s.substring(1, s.length()-0));
		MinimumWindowSubstring mws = new MinimumWindowSubstring();
		mws.test();
	}
	
	public void test() {
		System.out.println("start ... ");
		Solution sol = new Solution();
		String s = "bbaa"; //"ADOBECODEBANC";
		String t = "aba"; // "ABC";
		
		String ans = sol.minWindow(s, t);
		System.out.println(ans);
	}
	
	public class Solution {
		public String minWindow(String s, String t) {
		    if(s == null || t == null || s.length() * t.length() <= 0)
		    		return "";
		    
		    HashMap<Character, Integer> map = new HashMap<>();
		    for(char c : t.toCharArray()) {
		    		map.put(c, map.getOrDefault(c, 0) + 1);
		    }
		    
		    int minLen = Integer.MAX_VALUE;
		    int minLeft = 0,
		    		left 	= 0,
		    		right 	= 0,
		    		count 	= 0;
		    
		    while(right < s.length()) {
		    		if(map.containsKey(s.charAt(right))) {
		    			map.put(s.charAt(right), map.get(s.charAt(right))-1);
		    			if(map.get(s.charAt(right)) >= 0)
		    				count ++;
		    		}
		    		
		    		while(count == t.length()) {
		    			if(right - left + 1 < minLen) {
		    				minLen = right - left + 1;
		    				minLeft = left;
		    			}
		    			
		    			if(map.containsKey(s.charAt(left))) {
		    				map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
		    				if(map.get(s.charAt(left)) > 0) 
		    					count ++;
		    			}
		    			
		    			left++;
		    		}
		    		
		    		right ++;
		    }
		    
		    return (minLen == Integer.MAX_VALUE) ? "" : s.substring(minLeft, minLeft + minLen);
		}
	}
}
