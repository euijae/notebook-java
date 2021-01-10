package codingproblems.geekForGeeks.practice.array;

import java.util.ArrayList;
import java.util.List;

public class SmallestSubarray {

	public static void main(String[] args) {
		int [] nums = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250}; //{- 8, 1, 4, 2, -6}; //{1, 4, 45, 6, 0, 19};
		int target = 280; //6; //51;
		
		SmallestSubarray ss = new SmallestSubarray();
		List<Integer> ans = new ArrayList<>(ss.smallestSubarrayWithSum1(nums, target));
		System.out.println(ans.toString() + " and its size is " + ans.size());
	}
	
	public List<Integer> smallestSubarrayWithSum1(int [] nums, int target) {
		int smallestValue = Integer.MAX_VALUE;
		
		List<List<Integer>> lists = new ArrayList<>();
		List<Integer> ans = new ArrayList<>();
		lists.add(new ArrayList<>());
		
		for(int num : nums) {
			List<List<Integer>> tempLists = lists;
			int size = tempLists.size();
			int i = 0;
			
			while(i < size) {
				List<Integer> tempList = new ArrayList<>(tempLists.get(i));
				tempList.add(num);
				
				int sum = getSum(tempList);
				if(sum > target && smallestValue > sum) {
					ans = new ArrayList<>(tempList);
					smallestValue = sum;
				}
				
				lists.add(tempList);
				i++;
			}
		}
		
		return ans;
	}
	
	public int getSum(List<Integer> list) {
		int sum = 0;
		
		for(int val : list) 
			sum += val;
		
		return sum;
	}
}
