package go.there.soon.geekForGeeks.practice;

public class ClosestSum {
	public int [] closestSum1(int [] nums, int key) {
		int [] ans = new int[2];

		int diff = Integer.MAX_VALUE;

		for(int i = 0; i < nums.length-1; i++)
			for(int j = i+1; j < nums.length; j++)
				if(Math.abs(nums[i] + nums[j] - key) < diff) {
					ans[0] = i;
					ans[1] = j;
					diff = Math.abs(nums[i] + nums[j] - key);
				}

		return ans;
	}

	public int [] closestSum2(int [] nums, int key) {
		int [] ans = new int[2];
		int diff = Integer.MAX_VALUE;

		int l = 0;
		int r = nums.length-1;

		while(l < r) {
			if(Math.abs(nums[l]+nums[r] - key) < diff) {
				ans[0] = l;
				ans[1] = r;
				diff = Math.abs(nums[l]+nums[r] - key);
			} else if(nums[l] + nums[r] < key) {
				l++;
			} else {
				r--;
			}
		}

		return ans;
	}
}
