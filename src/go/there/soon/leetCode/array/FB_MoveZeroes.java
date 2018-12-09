package go.there.soon.leetCode.array;

import java.util.Arrays;

public class FB_MoveZeroes {

	public static void main(String[] args) {
		FB_MoveZeroes mz = new FB_MoveZeroes();
		mz.test();
	}
	
	public void test() {
		Solution s = new Solution();
		int [] arr = {0,1};
		s.moveZeroes(arr);
		System.out.println(Arrays.toString(arr));
	}

	class Solution {
	    public void moveZeroes(int[] nums) {
	        int nnz = 0;
	        for(int num : nums)
	            if(num != 0)
	                nnz++;
	        
	        int p1 = 0, 
	            p2 = findFirstNonzero(nums, 0);
	        
	        while(p1 < nnz && p2 < nums.length && p2 != -1) {
	        		nums[p1] = nums[p2];
	        		p2 = findFirstNonzero(nums, p2+1);
	        		p1++;
	        }
	        
	        for(int i = nnz; i < nums.length; i++) 
	        		nums[i] = 0;
	    }
	    
	    public int findFirstNonzero(int [] nums, int start) {
	    		for(int i = start; i < nums.length; i++)
	    			if(nums[i] != 0)
	    				return i;
	    		
	    		return -1;
	    }
	}
}
