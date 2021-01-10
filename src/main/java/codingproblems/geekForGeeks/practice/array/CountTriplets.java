package codingproblems.geekForGeeks.practice.array;

import java.util.Arrays;
import java.util.LinkedList;

public class CountTriplets {

	public static void main(String[] args) {
		CountTriplets ct = new CountTriplets();
		int [] nums = {5, 1, 3, 4, 7};
		int sum = 12;
		System.out.println("count: " + ct.countTriplets1(nums, sum));
		System.out.println("count: " + ct.countTriplets2(nums, sum));
	}
	
	public int countTriplets2(int [] nums, int sum) {
		Arrays.sort(nums);
		int count = 0;

		for(int l = 0; l < nums.length-2; l++) {
			int m = l+1;
			int r = nums.length-1;
			
			while(m < r) {
				if(getSum(nums, l, m, r) < sum) {
					count += (r-m) ;
					m++;
				} else {
					r--;
				}
			}
		}
		
		return count;
	}
	
	public int countTriplets1(int [] nums, int sum) {
		Arrays.sort(nums);
		
		int count = 0;
		LinkedList<int []> q = new LinkedList<>();
		LinkedList<int []> ans = new LinkedList<>();
		q.add(new int[]{0, (nums.length-1)/2, nums.length-1});
		
		while(!q.isEmpty()) {
			int [] temp = q.remove();
			int l = temp[0];
			int m = temp[1];
			int r = temp[2];

			if(getSum(nums, l, m, r) < sum) {
				if(!isDuplicated(ans, l, m, r)){
					ans.add(new int[]{l, m, r});
					q.add(new int[]{l,m,r});
					count++;
				}
			}
			
			if(Math.abs(l-m) > 1) {
				if(getSum(nums, l+1, m, r) < sum) {
					if(!isDuplicated(ans, l+1, m, r)){
						ans.add(new int[]{l+1, m, r});
						q.add(new int[]{l+1, m, r});
						count++;
					}
				}
				
				if(getSum(nums, l, m-1, r) < sum) {
					if(!isDuplicated(ans, l, m-1, r)){
						ans.add(new int[]{l, m-1, r});
						q.add(new int[]{l, m-1, r});
						count++;
					}
				}
			}
			
			if(Math.abs(m-r) > 1) {
				if(getSum(nums, l, m+1, r) < sum) {
					if(!isDuplicated(ans, l, m+1, r)){
						ans.add(new int[]{l, m+1, r});
						q.add(new int[]{l, m+1, r});
						count++;
					}
				}
				
				if(getSum(nums, l, m, r-1) < sum) {
					if(!isDuplicated(ans, l, m, r-1)){
						ans.add(new int[]{l, m, r-1});
						q.add(new int[]{l, m, r-1});
						count++;
					}
				}
			}
		}
		
		return count;
	}
	
	public int getSum(int [] nums, int l, int m, int r) {
		return nums[l] + nums[m] + nums[r];
	}
	
	public boolean isDuplicated(LinkedList<int []> linkedList, int l, int m, int r) {
		for(int [] arr : linkedList)
			if(arr[0] == l && arr[1] == m && arr[2] == r)
				return true;
		
		return false;
	}
}
