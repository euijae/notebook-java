package codingproblems.leetCode.array;

public class FB_isPalindrome {

	public static void main(String[] args) {
		FB_isPalindrome o = new FB_isPalindrome();
		o.test();
	}

	public void test() {
		Solution sol = new Solution();
		String s = "0P";//"race a car";
		System.out.println(">> " + Character.isLetterOrDigit(s.charAt(0)));
		System.out.println(s + " is palindrome? " + sol.isPalindrome2(s));
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
	    
	    public boolean isPalindrome2(String s) {
	        if(s.isEmpty()) return true;
	        
	        s = s.toLowerCase();
	        
	        int p1 = 0;
	        int p2 = s.length()-1;
	        
	        while(p1 < p2) {
	            char c1 = s.charAt(p1);
	            char c2 = s.charAt(p2);
	            System.out.printf("c1: %c, c2: %c\n", c1, c2);
	            if(isAlphaNum(c1) && isAlphaNum(c2)) {
	                if(c1 != c2) return false;
	                
	                p1 ++;
	                p2 --;
	            } else {
	                if(!isAlphaNum(c1)) p1 ++;
	                if(!isAlphaNum(c2)) p2 --;
	            }
	        }
	        
	        return true;
	    }
	    
	    public boolean isAlphaNum(char ch) {
	        int val1 = ch - 'a';
	        int val2 = ch - '0';
	        System.out.printf("val1: %d, val2: %d\n", val1, val2);
	        return (val1 >= 0 && val1 < 26) || (val2 >= 0 && val2 < 10);
	    }
	}
}
