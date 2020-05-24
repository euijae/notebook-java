package codingproblems.geekForGeeks.practice.dynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int [] nums = { 1, 12, 7, 0, 23, 11, 52, 31, 61, 69, 70, 2 };
		//{10,29471,5242,21175,28931,2889,7275,19159,21773,1325,6901}; 
		//{10, 22, 9, 33, 21, 50, 41, 60, 80};
		System.out.println(lis0(nums));
	}
	
//	[1, 2, 2, 1, 3, 3, 4, 4, 5, 6, 7, 2]
//	1 7 11 31 61 69 70 
//	7
	
	public static int lis0(int [] nums) {
		
		int [] lis = new int[nums.length];
		int max = -1;
				
		for(int i = 0; i < nums.length; i++) {
			max = -1;
			
			for(int j = 0; j < i; j++)
				if((nums[i] > nums[j]) && (max == -1 || max < lis[j] + 1))
					max = lis[j] + 1;
			
			lis[i] = (max == -1) ? 1: max;
		}
		
		for(int num : lis) {
			max = Math.max(max, num);
		}
		
		int res = max;
		String path = "";
		for(int i = lis.length-1; i >= 0; i--) {
			if(lis[i] == res) {
				path = nums[i] + " " + path;
				res--;
			}
		}
		
		System.out.println(Arrays.toString(lis));
		System.out.println(path);
		
		return max;
	}
	
	public static int lis1(int [] nums) {
		int longestSubsequence = 1;
		
		for(int i = 0; i < nums.length-1; i++) {
			int val1 = nums[i];
			int val2 = nums[i];
			int tempLongestSubsequence = 1;
			for(int j = i+1; j < nums.length; j++) {
				if(val2 > nums[j] && val1 < nums[j]) {
					val2 = nums[j];
				} else if(nums[j] > val1) {
					val1 = val2;
					val2 = nums[j];
					tempLongestSubsequence++;
				}
			}
			
			longestSubsequence = Math.max(longestSubsequence, tempLongestSubsequence);
		}
		
		return longestSubsequence == 1 ? 0 : longestSubsequence;
	}
	
    public static int lis2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = 1;
        int prev1, prev2, count;   // always keep prev1 <= prev2
        for (int i = 0; i < nums.length; i++) {
            prev1 = nums[i];
            prev2 = prev1;
            count = 1;
            for (int j = i+1; j < nums.length; j++) {
                if (prev2 > nums[j] && nums[j] > prev1) {
                    prev2 = nums[j];
                } else if (prev2 < nums[j]) {
                    count++;
                    prev1 = prev2;
                    prev2 = nums[j];
                }
            }
            max = Math.max(max, count);
        }

        return max;
    }
}
