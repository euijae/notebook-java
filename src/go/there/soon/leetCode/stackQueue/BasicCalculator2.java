package go.there.soon.leetCode.stackQueue;

import java.util.Stack;

public class BasicCalculator2 {

	public static void main(String[] args) {
		BasicCalculator2 o = new BasicCalculator2();
		o.test();
	}

	public void test() {
		Solution sol = new Solution();
		String s = "3/0";//0-2147483647";
		int result = sol.calculate(s);
		System.out.println(s + " = " + result);
	}
	
	class Solution {
	    public int calculate(String s) {
	        if(s == null || s.isEmpty())
	            return 0;
	        
	        Stack<Integer> numbers = new Stack<>();
	        numbers.push(getNum(s,0));
	        
	        char [] equations = s.toCharArray();
	        
	        for(int i = 0; i < equations.length; i++) {
	        		if(equations[i] == '+') {
	        			numbers.push(getNum(s, i+1));
	        		} else if(equations[i] == '-') {
	        			numbers.push((-1) * getNum(s, i+1));
	        		} else if(equations[i] == '*' || equations[i] == '/') {
	        			int first  = numbers.pop();
	        			int second = getNum(s, i+1);
	        			
	        			if(equations[i] == '*') {
	        				numbers.push(first*second);
	        			} else {
        					numbers.push((second == 0) ? 0 : first / second);
	        			}
	        		}
	        }

	        int result = 0;
	        
	        while(!numbers.isEmpty()) {
	        		result += numbers.pop();
	        }
	        
	        return result;
	    }
	    
	    public int getNum(String s, int i) {
	    		int num = 0;
	    		
	    		while(i < s.length() && s.charAt(i) == ' ') i++;
	    		while(i < s.length() && Character.isDigit(s.charAt(i))) num = 10 * num + (s.charAt(i++) - '0');
	    		while(i < s.length() && s.charAt(i) == ' ') i++;
	    		
	    		return num;
	    }
	}
}
