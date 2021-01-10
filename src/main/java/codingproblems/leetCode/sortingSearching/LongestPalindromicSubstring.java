package codingproblems.leetCode.sortingSearching;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
		lps.test();
	}
	
	public void test() {
		Solution sol = new Solution();
		String s = "zysabcddcbaabc";
		System.out.println("longest palindrome is > " + sol.longestPalindrome(s));
	}
	
	class Solution {
	    public String longestPalindrome(String s) {
	        if(s == "" || s == null) {
	            return "";
	        }
	        
	        for(int i = 0; i < s.length(); i++) {
	        		for(int j = 0; j <= i; j++) {
	        			String substr = s.substring(j, s.length()-(i-j));
	        			
	        			if(isPalindrome(substr))
	        				return substr;
	        		}
	        }
	        
	        return "";
	    }
	    
	    public boolean isPalindrome(String s) {
	    		int mid = s.length()/2;
	    		int i = 0;
	    		int end = s.length()-1;
	    		
	    		while(i <= mid) {
	    			if(s.charAt(i) != s.charAt(end-i))
	    				return false;
	    			i++;
	    		}
	    		
	    		return true;
 	    }
	}
}
