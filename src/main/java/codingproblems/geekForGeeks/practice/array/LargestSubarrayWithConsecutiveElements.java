package codingproblems.geekForGeeks.practice.array;

/**
 * https://www.geeksforgeeks.org/length-largest-subarray-contiguous-elements-set-1/
 * @author eugene.kim
 *
 */
public class LargestSubarrayWithConsecutiveElements {

	public static void main(String[] args) {
		int [] nums = {10, 12, 11};
		int longest = longestSubarray(nums);
		System.out.println("longest: " + longest);
	}	

	public static int longestSubarray(int [] nums) {
		int longest = 0;
		
		for(int i = 0; i < nums.length-1; i++) {
			int max = nums[i];
			int min = nums[i];
			
			for(int j = i+1; j < nums.length; j++) {
				max = max(max, nums[j]);
				min = min(min, nums[j]);
				
				if((max-min) == (j-i) && longest < (j-i)) longest = j - i;
			}
		}
		
		return longest;
	}
	
	public static int min(int value1, int value2) {
		return (value1 > value2) ? value2 : value1;
	}
	
	public static int max(int value1, int value2) {
		return (value1 > value2) ? value1 : value2;
	}
}
