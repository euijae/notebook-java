package codingproblems.leetCode.array;

import java.util.*;

public class FB_ThreeSum {

	public static void main(String[] args) {
		FB_ThreeSum fts = new FB_ThreeSum();
		fts.test();
	}
	
	public void test() {
		Solution s = new Solution();
		List<List<Integer>> lists = s.threeSum(new int[]{-1, 0, 1, 0});
		
		for(List<Integer> list : lists) {
			System.out.println(list.toString());
		}
	}

	class Solution {
	    public List<List<Integer>> threeSum(int[] nums) {
	        if(nums == null || nums.length <= 2)
	            return new ArrayList<>();
	        
	        Arrays.sort(nums); // {-4, -1, -1, 0, 1, 2}

	        Map<Integer, Integer> map = new HashMap<>();
	        Map<Integer, List<Integer>> abMap = new HashMap<>();
	        List<List<Integer>> lists = new ArrayList<>();
	        
	        for(int num : nums)
	            map.put(num, map.getOrDefault(num, 0)+1);
	        
	        for(int i = 0; i < nums.length-1; i++) {
	            for(int j = i+1; j < nums.length; j++) {
	            		List<Integer> list = new ArrayList<>();
	            		
	                int a = nums[i];
	                int b = nums[j];
	                
	                if(map.containsKey(-a-b) && a <= b && b <= -a-b) {
	                    if((a == b && b == -a-b && map.get(a) < 3)
	                    		|| (a == -a-b && map.get(a) < 2) 
	                       || (b == -a-b && map.get(b) < 2))
	                        continue;
	                    
	                    boolean isFound = false;
	                    
	                    if(abMap.containsKey(a)) {
	                    		for(Integer value : abMap.get(a)) {
	                    			if(value == b) {
	                    				isFound = true;
	                    				break;
	                    			}
	                    		}
	                    }
	                    
	                    if(!isFound) {
	                    		List<Integer> tempList = abMap.getOrDefault(a, new ArrayList<>());
	                    		tempList.add(b);
	                    		abMap.put(a, tempList);
	                    		list.add(a);
		                    list.add(b);
		                    list.add(-a-b);
		                    lists.add(list);
	                    }
	                }
	            }
	        }

	        return lists;
	    }
	}
}
