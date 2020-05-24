package codingproblems.leetCode.array;

import java.util.Arrays;

public class FB_MoveZeroes {

	public static void main(String[] args) {
		FB_MoveZeroes mz = new FB_MoveZeroes();
		mz.test();
	}
	
	public void test() {
		Solution s = new Solution();
		int [] arr = {4,2,4,0,0,3,0,5,1,0};
		s.moveZeroes(arr);
		System.out.println(Arrays.toString(arr));
	}

	class Solution {
	    public void moveZeroes(int[] nums) {
	        int p1 = 0;
	        int p2 = 0;
	        int len = nums.length;
	        System.out.println(Arrays.toString(nums));
	        while(p2 < nums.length) {
	            while(p1 < len && nums[p1] != 0) p1++;
	            if(p1 >= len) break;
	            p2 = p1 + 1;
	            while(p2 < len && nums[p2] == 0) p2++;
	            if(p2 >= len) break;
	            
	            swap(nums, p1, p2);
	            p1 ++;
	            p2 = p1 + 1;
	            System.out.println(Arrays.toString(nums));
	        }
	    }
	    
	    public void swap(int [] nums, int left, int right) {
	        int tmp = nums[left];
	        nums[left] = nums[right];
	        nums[right] = tmp;
	    }
	}
}
