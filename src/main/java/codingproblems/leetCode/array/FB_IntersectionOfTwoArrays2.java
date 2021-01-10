package codingproblems.leetCode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FB_IntersectionOfTwoArrays2 {

	public static void main(String [] args) {
		FB_IntersectionOfTwoArrays2 o = new FB_IntersectionOfTwoArrays2();
		o.test();
	}
	
	public void test() {
		Solution sol = new Solution();
		int [] nums1 = {1,2,2,1};
		int [] nums2 = {2,2};
		int [] ans = sol.intersect(nums1, nums2);
		System.out.println(Arrays.toString(ans));
	}
	
	class Solution {
	    public int[] intersect(int[] nums1, int[] nums2) {
			if(nums1.length == 0 || nums2.length == 0)
				return new int[] {};
			
			int [] result = new int[Math.min(nums1.length, nums2.length)];
			int p1 = 0;
			int p2 = 0;
			int curr = 0;
			
			while(p1 < nums1.length && p2 < nums2.length) {
				if(nums1[p1] == nums2[p2]) {
					result[curr] = nums1[p1];
					p1++;
					p2++;
					curr++;
				} else  if(nums1[p1] < nums2[p2]) {
					p1++;
				} else {
					p2++;
				}
			}
		
			return Arrays.copyOf(result, curr);
	    }
	    
	    public int[] intersect2(int[] nums1, int[] nums2) {
			Set<Integer> set = new HashSet<>();
			Set<Integer> intersection = new HashSet<>();
			
			for(int num : nums1) 
				set.add(num);
			
			for(int i = 0; i < nums2.length; i++) {
				if(set.contains(nums2[i])) {
					intersection.add(nums2[i]);
				}
			}
			
			int [] ans = new int[intersection.size()];
			
			int idx = 0;
			
			for(int n : intersection) {
				ans[idx++] = n;
			}
			
			return ans;
	    }
	}
}
