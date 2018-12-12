package go.there.soon.leetCode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class FB_Subsets {

	public static void main(String[] args) {
		FB_Subsets o = new FB_Subsets();
		o.test();
	}

	public void test() {
		Solution sol = new Solution();
		int [] nums = {-5,3,2,-6,1,0,10};
		for(List<Integer> list : sol.subsets(nums))
			System.out.println(list.toString());
	}
	
	class Solution {
	    public List<List<Integer>> subsets(int[] nums) {
	        List<List<Integer>> results = new ArrayList<>();
	        helper(nums, results, new ArrayList<>(), 0);
	        return results;
	    }
	    
	    private void helper(int[] nums, List<List<Integer>> results, List<Integer> result, int index) {
    			results.add(new ArrayList<>(result));
	        
	        for (int i = index; i < nums.length; i++) {
	            result.add(nums[i]);
	            helper(nums, results, result, i + 1);
	            result.remove(result.size() - 1);
	        }
	    }
	}
}
