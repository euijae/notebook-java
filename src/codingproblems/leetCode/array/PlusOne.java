package codingproblems.leetCode.array;

import java.util.Arrays;

public class PlusOne {

	public static void main(String[] args) {
		PlusOne po = new PlusOne();
		int [] nums = {1, 9, 9, 9};
		String result = Arrays.toString(po.plusOne(nums));
		System.out.println(result);
	}
	
    public int[] plusOne(int[] digits) {
    	int length = digits.length;
    	int lastIndex = digits.length-1;
    	int add = (digits[lastIndex] == 9) ? 1 : 0;
    	
    	if(add == 1) {
    		int i = lastIndex;
    		
    		while(add == 1 && i >= 0) {
    			digits[i] = (digits[i] + 1) % 10;
    			add = (digits[i] == 0) ? 1 : 0;
    			i--;
    		}
    		
    		if(add == 1) {
    			int [] ans = new int[length+1];
    			ans[0] = 1;
    			for(int j = 1; j < length+1; j++) {
    				ans[j] = digits[j-1];
    			}
    			
    			return ans;
    		}
    	} else {
    		digits[lastIndex] += 1;
    	}
	    	
        return digits;
    }
}
