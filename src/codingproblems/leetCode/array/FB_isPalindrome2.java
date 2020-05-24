package codingproblems.leetCode.array;

public class FB_isPalindrome2 {

	public static void main(String[] args) {
		FB_isPalindrome2 o = new FB_isPalindrome2();
		o.test();
	}
	
	public void test() {
		Solution sol = new Solution();
		String s = "abbbbbbbbbbbbbbbca";
		System.out.println(s + " is a palindrome? : " + sol.validPalindrome(s));
	}
	
	class Solution {
	    public boolean validPalindrome(String s) {
	        if(s == null || s.length() <= 1)
	        		return false;
	        
	        return checker(s, 0, s.length()-1, 0);
	    }
	    
	    public boolean checker(String s, int left, int right, int count) {
	    		if(left > right)
	    			return true;
	    		
	    		if(s.charAt(left) != s.charAt(right)) {
	    			if(count > 0) {
	    				return false;
	    			} else {
	    				return checker(s, left+1, right, count+1)
	    					|| checker(s, left, right-1, count+1);
	    			}
	    		} 
	    		
	    		return checker(s, left+1, right-1, count);
	    }
	}
}
