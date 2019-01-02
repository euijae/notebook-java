package go.there.soon.scratch.onsite;

import java.util.*;

public class Uber {

	public static void main(String[] args) {
		Uber o = new Uber();
		o.test();
	}

	public void test() {
		int [] nums = {-5,3,2,-6,1,0,10};
		int target = 5;
		List<List<Integer>> results = findSubArray(nums, target);
		for(List<Integer> result : results) 
			System.out.println(result.toString());
	}
	
	public List<List<Integer>> findSubArray(int [] nums, int target) {
		List<List<Integer>> results = new ArrayList<>();
		helper(results, new ArrayList<>(), nums, target, 0, 0);
		return results;
	}
	
	public void helper(List<List<Integer>> results, 
					List<Integer> result,
					int [] nums, 
					int target,
					int sum,
					int index) {
		//if(target == sum)
			results.add(new ArrayList<>(result));
		
		for(int i = index; i < nums.length; i++) {
			result.add(nums[i]);
			helper(results, result, nums, target, sum + nums[i], i+1);
			result.remove(result.size()-1);
		}
	}
}
