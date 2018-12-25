package go.there.soon.leetCode.array;

public class ShortestPalindrome {

	public static void main(String[] args) {
		ShortestPalindrome o = new ShortestPalindrome();
		o.test();
	}

	public void test() {
		Solution s = new Solution();
		String str = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		String shortest = s.shortestPalindrome(str);
		if(str.equals(shortest))
			System.out.println("identical");
		System.out.println(shortest);
	}
	
	class Solution {
	    public String shortestPalindrome(String s) {
	        if(s == null || s.isEmpty())
	            return "";

	        if(isPalindrome(s))
	        		return s;
	        
	        StringBuilder reverse = new StringBuilder();
	        
	        for(int end = s.length()-1; end >= 0; end--) {
	        		reverse.append(s.charAt(end));
	        		
	        		if(isPalindrome(s.substring(0, end))) {
	        			break;
	        		}
	        }
	        
	        return reverse.append(s).toString();
	    }
	    
	    public boolean isPalindrome(String s) {
	        int left = 0;
	        int right = s.length()-1;
	        
	        while(left <= right) {
	            if(s.charAt(left) != s.charAt(right)) {
	                return false;
	            }
	            
	            left ++;
	            right--;
	        }
	        
	        return true;
	    }
	}
}
