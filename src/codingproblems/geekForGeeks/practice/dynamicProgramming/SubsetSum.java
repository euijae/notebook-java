package codingproblems.geekForGeeks.practice.dynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubsetSum {

	public static void main(String[] args) {
		System.out.println(subsetSum(new int[]{3, 34, 4, 12, 5, 2},13));
	}

	public static boolean subsetSum(int [] nums, int SUM) {
		Arrays.sort(nums);
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int key : nums)
			map.put(key, map.containsKey(key) ? 1 + map.get(key) : 1);

		Map<Integer, Integer> tempMap = new HashMap<>(map);
		
		int SIZE = map.size();
		
		for(int i = 0; i < SIZE; i++) {
			int tempSum = SUM;
			
			for(int j = i; j < SIZE; j++) {
				int key = nums[j];
				int value = tempMap.get(key);
				
				if(tempMap.containsKey(key) && value == 1)
					tempMap.remove(key);
				else
					tempMap.put(key, value-1);
				
				if(tempMap.containsKey(tempSum - key)) {
					return true;
				} else {
					tempSum -= key;
					if(tempSum < 0) break;
				}
			}
			
			tempMap = new HashMap<>(map);
		}
		
		return false;
	}
}
