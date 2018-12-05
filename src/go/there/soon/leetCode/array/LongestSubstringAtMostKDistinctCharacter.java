package go.there.soon.leetCode.array;

public class LongestSubstringAtMostKDistinctCharacter {

	public static void main(String[] args) {
		LongestSubstringAtMostKDistinctCharacter
		l = new LongestSubstringAtMostKDistinctCharacter();
		l.test();
	}
	
	public void test() {
		Solution sol = new Solution();
		String s = "eceba";
		int k = 2;
		int length = sol.lengthOfLongestSubstringKDistinct(s, k);
		System.out.println("length is " + length);
	}
	
	class Solution {
	    public int lengthOfLongestSubstringKDistinct(String s, int k) {
	        if(s.length() <= 0 || k <= 0)
	        		return 0;
	        
	        char [] windows = new char[256];
	        int maxLen = 0,
	        		distinct = 0,
	        		left = 0;
	        
	        for(int right = 0; right < s.length(); right++) {
	        		windows[s.charAt(right)]++;
	        		if(windows[s.charAt(right)] == 1)
	        			distinct ++;
	        		
	        		if(distinct <= k) {
	        			maxLen = Math.max(maxLen, right - left + 1);
	        		} else {
	        			while(distinct > k) {
	        				windows[s.charAt(left)]--;
	        				if(windows[s.charAt(left)] == 0)
	        					distinct --;
	        				left ++;
	        			}
	        		}
	        }
	        
	        return maxLen;
	    }
	}
}
