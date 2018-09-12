package go.there.soon.geekForGeeks.practice.array;

import java.util.ArrayList;
import java.util.List;

public class MaxProfit {
	public static void main(String[] args) {
		int [] nums = {100, 180, 260, 310, 40, 535, 695};
		maxProfit(nums);
	}
	
	public static void maxProfit(int [] nums) {
		int start = 0;
		List<Integer []> lists = new ArrayList<>();
		
		for(int i = 0; i < nums.length; i = start + 1) {
			start = i;
			
			while(start < nums.length-1 && nums[start] < nums[start+1]) start ++;
			if(start != i) {
				lists.add(new Integer[]{i, start});
			}
		}
		
		for(Integer [] ins : lists) {
			int i0 = ins[0];
			int i1 = ins[1];
			System.out.println("max: " + (nums[i1] - nums[i0]) + ", at " + i0 + " and " + i1);
		}
	}
}
