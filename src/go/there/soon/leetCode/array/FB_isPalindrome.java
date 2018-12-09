package go.there.soon.leetCode.array;

public class FB_isPalindrome {

	public static void main(String[] args) {
		FB_isPalindrome o = new FB_isPalindrome();
		o.test();
	}

	public void test() {
		Solution sol = new Solution();
		String s = "0P";//"race a car";
		System.out.println(">> " + Character.isLetterOrDigit(s.charAt(0)));
		System.out.println(s + " is palindrome? " + sol.isPalindrome(s));
	}
	
	class Solution {
	    public boolean isPalindrome(String s) {
	        if(s == null || s.length() <= 1)
	            return true;
	        
	        s = s.toLowerCase();
	        int left = 0;
	        int right = s.length()-1;
	        
	        while(left <= right) {
	            while(left <= s.length()-1 && !Character.isLetterOrDigit(s.charAt(left)))
	                left++;
	            
	            while(right >= 0 && !Character.isLetterOrDigit(s.charAt(right)))
	                right--;
	            
	            if(left > right)
	            		return true;
	            
	            	if(s.charAt(left) != s.charAt(right))
	                return false;
	            
	            left++;
	            right--;
	        }
	        
	        return true;
	    }
	}
}
