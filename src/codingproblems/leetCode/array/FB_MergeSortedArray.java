package codingproblems.leetCode.array;

import java.util.Arrays;

public class FB_MergeSortedArray {

	public static void main(String[] args) {
		FB_MergeSortedArray o = new FB_MergeSortedArray();
		o.test();
	}
	
	public void test() {
		Solution sol = new Solution();
		int [] nums1 = {1,2,3,0,0,0};
		int m = 3;
		int [] nums2 = {2,5,6};
		int n = 3;
		sol.merge(nums1, m, nums2, n);
		System.out.println(Arrays.toString(nums1));
	}

	class Solution {
	    public void merge(int[] nums1, int m, int[] nums2, int n) {
	        if(nums1.length * nums2.length == 0 || m * n < 0)
	            return ;
	        
	        int end = m + n -1;
	        m = m-1;
	        n = n-1;
	        
	        while(m >= 0 && n >= 0) {
	            if(nums1[m] > nums2[n]) {
	                nums1[end] = nums1[m];
	                m--;
	            } else {
	                nums1[end] = nums2[n];
	                n--;
	            }
	            
	            end--;
	        }
	        
	        while(n >= 0) {
	            nums1[end] = nums2[n];
	            end--;
	            n--;
	        }
	    }
	}
}
