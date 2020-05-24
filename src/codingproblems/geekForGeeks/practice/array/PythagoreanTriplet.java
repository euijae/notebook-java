package codingproblems.geekForGeeks.practice.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PythagoreanTriplet {

	public static void main(String[] args) {
		int [] nums = {10, 4, 6, 12, 5, 13};
		
		if(isPythagoreanExist(nums)) {
			System.out.println("Yes, it does exist");
		} else {
			System.out.println("Yes, it does not exist");
		}
	}
	
	public static boolean isPythagoreanExist(int [] nums) {
		
		if(nums.length < 3) 
			return false;
		
		Arrays.sort(nums);

		Set<Integer> set = new HashSet<>();
		for(int num : nums) {
			set.add(num*num);
		}
		
		for(int r = nums.length-1; r >= 2; r--) {
			int m = r-1;
			int l = 0;
			
			while(l < m) {
				int [] temp = getNums(nums, l, m, r);

				if(temp[0] + temp[1] == temp[2]) {
					return true;
				} else {
						if(set.contains(temp[0] + temp[1]))
							return true;
						
						if(temp[0] + temp[1] < temp[2]) {
							l++;
						} else {
							m--;
					}
				}
			}
		}
		
		return false;
	}
	
	public static int [] getNums(int [] nums, int l, int m, int r) {
		return new int[] {
				nums[l] * nums[l],
				nums[m] * nums[m],
				nums[r] * nums[r]
		};
	}
}
