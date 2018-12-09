package go.there.soon.leetCode.sortingSearching;

import java.util.Arrays;

public class SortTransformedArray {

	public static void main(String[] args) {
		SortTransformedArray sta = new SortTransformedArray();
		sta.test();
	}

	public void test() {
		Solution sol = new Solution();
		int [] nums = {-99,-98,-94,-93,-93,-93,-88,-83,-77,-77,-77,-74,-74,-72,-71,-70,-67,-64,-63,-62,-61,-58,-56,-54,-54,-53,-51,-51,-50,-48,-46,-45,-42,-41,-35,-31,-22,-22,-20,-20,-16,-16,-12,-11,-8,-3,-2,-1,0,1,3,4,6,9,10,11,11,11,12,13,26,27,29,31,32,34,36,42,48,49,54,56,59,62,62,65,65,69,70,72,73,74,75,82,85,86,91,92,92,97,98};
		int a = 13;
		int b = 22;
		int c = -16;
		int [] arr = sol.sortTransformedArray(nums, a, b, c);
		System.out.println(">> ans: " + Arrays.toString(arr));
	}
	
	class Solution {
	    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
	    		if(a == 0)
	    			return transform(a,b,c,nums,(b < 0));
	    		
	        int [] arr = new int[nums.length];
	        
	        double center = Math.floor(100 * -b / (2*a)) / 100;
	        int leftP = -1;
	        
	        for(int i = 1; i < nums.length; i++)
	        		if(nums[i-1] <= center && center <= nums[i])
	        			leftP = i-1;
	        
	        if(leftP == -1) {
	        		if(leftP <= nums[0]) 
	        			return (a > 0) ? nums : reverse(nums);
	        		else 
	        			return (a > 0) ? reverse(nums) : nums;
	        }

	        int rightP  = leftP + 1;
	        int current = (a > 0) ? 0 : nums.length-1;

	        System.out.println("nums[" + leftP + "]: " +  nums[leftP] + ", func: " + func(a,b,c,nums[leftP]));
	        System.out.println("nums[" + rightP + "]: " + nums[rightP] + ", func: " + func(a,b,c,nums[rightP]));
	        System.out.println("arr : " + Arrays.toString(nums));
	        
	        while(leftP >= 0 && rightP < arr.length) {
	        		int leftF  = func(a, b, c, nums[leftP]);
	        		int rightF = func(a, b, c, nums[rightP]);
	        		
	        		if(leftF <= rightF) {
	        			if(a > 0) {
	        				arr[current] = leftF;
	        				leftP--;
	        			} else {
	        				arr[current] = rightF;
	        				rightP++;
	        			}
	        		} else {
	        			if(a > 0) {
	        				arr[current] = rightF;
	        				rightP++;
	        			} else {
	        				arr[current] = leftF;
	        				leftP--;
	        			}
	        		}
	        		
	        		current = current + ((a > 0) ? 1 : - 1);
	        }
	        
	        while(leftP >= 0) {
	        		arr[current] = func(a,b,c,nums[leftP]);
	        		current = (a > 0) ? current + 1 : current - 1;
	        		leftP --;
	        }
	        
	        while(rightP < nums.length) {
		        	arr[current] = func(a,b,c,nums[rightP]);
	        		current = (a > 0) ? current + 1 : current - 1;
	        		rightP ++;
	        }
	        
	        return arr;
	    }
	    
	    public int [] transform(int a, int b, int c, int [] nums, boolean reverse) {
	    		if(reverse)
	    			nums = reverse(nums);
	    		
	    		for(int i = 0; i < nums.length; i++)
    				nums[i] = func(a,b,c,nums[i]);
	    		
	    		System.out.println(Arrays.toString(nums));
	    		
    			return nums;
	    }
	    
	    public int func(int a, int b, int c, int x) {
	    		return a*x*x + b*x + c;
	    }
	    
	    public int [] reverse(int [] nums) {
	    		int left = 0;
	    		int right = nums.length-1;
	    		
	    		while(left < right) 
	    			swap(nums, left++, right--);
	    		
	    		return nums;
	    }
	    
	    public void swap(int [] nums, int i, int j) {
	    		int temp = nums[i];
	    		nums[i] = nums[j];
	    		nums[j] = temp;
	    }
	}
}
