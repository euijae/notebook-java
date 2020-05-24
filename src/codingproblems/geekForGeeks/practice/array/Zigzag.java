package codingproblems.geekForGeeks.practice.array;

import java.util.Arrays;

public class Zigzag {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = {4, 3, 7, 8, 6, 2, 1};
		Zigzag zz = new Zigzag();
		System.out.println(Arrays.toString(nums));
		System.out.println(Arrays.toString(zz.zigzag(nums)));
	}
	
	public int [] zigzag(int [] nums) {
		for(int i = 0; i < nums.length-1; i++) {
			if(i % 2 == 0) {
				if(nums[i] >= nums[i+1]) {
					swap(nums, i, i+1);
				}
			} else {
				if(nums[i] <= nums[i+1]) {
					swap(nums, i, i+1);
				}
			}
		}
		
		return nums;
	}
	
	public void swap(int [] nums, int l, int r) {
		int temp = nums[l];
		nums[l] = nums[r];
		nums[r] = temp;
	}
}
