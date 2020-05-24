package codingproblems.geekForGeeks.practice.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionTwoSubsets {
	public static void main(String[] args) {
		int arr[] = {3, 1, 4, 2}; // {3, 1, 4, 2, 2, 1}
//		System.out.println("The result: " + partitionSubsets1(arr));
		System.out.println("The result: " + partitionSubsets2(arr));
	}

	/**
	 * Implement using Brute force
	 * @param nums
	 * @return
	 */
	public static int partitionSubsets1(int [] nums) {
		System.out.println("[Brute Force]");
		int SUM = getSum(nums);
		int smallest = Integer.MAX_VALUE;
		
		List<List<Integer>> partition = new ArrayList<>();
		partition.add(new ArrayList<>());
		
		for(int i = 0; i < nums.length; i++) {
			int size = partition.size();
			int element = nums[i];
			
			for(int j = 0; j < size; j++) {
				List<Integer> temp = new ArrayList<>(partition.get(j));
				temp.add(element);
				partition.add(temp);
				
				int listSum = getSum(temp);
				int diff = Math.abs((SUM - listSum) - (listSum));
				smallest = Math.min(smallest, diff);
			}
		}
		
		return smallest;
	}
	
	/**
	 * Return the minimum value of the diff of the two sets
	 * @param arr
	 * @param n
	 * @return
	 */
    public static int partitionSubsets2(int arr[]) {
    	System.out.println("[Dynamic Programming]");
        int sum = getSum(arr);
        int n = arr.length;
     
        int dp[][] = new int[n + 1][sum + 1];
     
        // Initialize first column as true. 
        // 0 sum is possible  with all elements.
        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;
     
        // Set top row, except dp[0][0], to 0. 
        for (int i = 1; i <= sum; i++)
            dp[0][i] = 0;
     
        // Fill the partition table in bottom up manner
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                // If i'th element is excluded
                dp[i][j] = dp[i - 1][j];
     
                // If i'th element is included
                if (arr[i - 1] <= j)
                    dp[i][j] |= dp[i - 1][j - arr[i - 1]];
            }
        }
     
        // Initialize difference of two sums. 
        int diff = Integer.MAX_VALUE;
         
        for(int i = 0; i < dp.length; i++)
        	System.out.println(Arrays.toString(dp[i]));
        
        // Find the largest j such that dp[n][j]
        // is true where j loops from sum/2 t0 0
        for (int j = sum / 2; j >= 0; j--)
            if (dp[n][j] == 1)
                return sum - 2 * j;

        return diff;
    }
	
	public static int getSum(int [] nums) {
		int sum = 0;
		
		for(int num : nums) 
			sum += num;
		
		return sum;
	}
	
	public static int getSum(List<Integer> nums) {
		int sum = 0;
		
		for(int num : nums)
			sum += num;
		
		return sum;
	}
}
