package codingproblems.leetCode.array;

import java.util.*;

public class FirstMissingPositive {

	public static void main(String[] args) {
		FirstMissingPositive o = new FirstMissingPositive();
		o.test();
	}

	public void test() {
		Solution sol = new Solution();
		int [] nums = {3,4,-1,1};
		int firstPos = sol.firstMissingPositive(nums);
		System.out.println(firstPos);
	}
	
	class Solution {
	    public int firstMissingPositive(int[] nums) {
	        Set<Integer> set = new HashSet<>();
	        
	        int min = Integer.MAX_VALUE;
	        int max = Integer.MIN_VALUE;
	        
	        for(int i = 0; i < nums.length; i++) {
	        		if(nums[i] > 0) {
	        			max = (nums[i] >= max) ? nums[i] : max;
	        			min = (nums[i] <= min) ? nums[i] : min;
	        		}
        			
	        		if(!set.contains(nums[i]))
	        			set.add(nums[i]);
	        }
	        
	        if(min > 1)
	        		return 1;
	        else {
	        		for(int i =  min; i <= max; i++) {
	        			if(!set.contains(i))
	        				return i;
	        		}
	        		
	        		return max+1;
	        }
 	    }
	}
}
