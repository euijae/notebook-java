package go.there.soon.leetCode.mock;

import java.util.*;

public class LoudAndRich {

	public static void main(String[] args) {
		LoudAndRich lar = new LoudAndRich();
		lar.test();
	}

	public void test() {
		Solution sol = new Solution();
		
		int [][] richer = {
			{1,0},{2,1},{3,1},{3,7},{4,3},{5,3},{6,3}
		};
		int [] quiet = {3,2,5,4,6,1,7,0};
		int [] nums = sol.loudAndRich(richer, quiet);
		for(int num : nums)
			System.out.print(num + ", ");
	}
	
	class Solution {
	    public int[] loudAndRich(int[][] richer, int[] quiet) {
	        
	        if(richer.length == 0)
	            return new int[]{};
	        
	        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
	        for(int [] r : richer) {
	            int key = r[1];
	            List<Integer> value = map.getOrDefault(key, new ArrayList<>());
	            value.add(r[0]);
	            map.put(key, value);
	        }
	        
	        int N = quiet.length;
	        int [] answer      = new int[N];
	        Arrays.fill(answer, -1);
	        int [] quietSorted = new int[N];
	        
	        for(int i = 0; i < N; i++) {
	            quietSorted[quiet[i]] = i;
	        }
	        
	        for(int p = 0; p < N; p++) {
	            if(!map.containsKey(p)) {
	                answer[p] = p;
	            	} else {
	            		List<Integer> possibilities = new ArrayList<>();
	            		getPossibilities(map, possibilities, p);
	            		
	                int indexInQuietSorted = quiet[p];
	                
	                for(int i = 0; i < indexInQuietSorted; i++) {
		                	if(possibilities.contains(quietSorted[i])) {
	                    		answer[p] = quietSorted[i];
	                    		break;
	                    }
	                }
	                    
	                if(answer[p] == -1)
	                		answer[p] = p;
	            }
	        }
	        
	        return answer;
	    }
	    
	    public void getPossibilities(TreeMap<Integer, List<Integer>> map, List<Integer> ans, int key) {
	        if(map.containsKey(key)) { 
	        		for(int element : map.get(key)) {
	        			if(!ans.contains(element)) {
	        				ans.add(element);
	        				getPossibilities(map, ans, element);
	        			} 
	        		}
	        }
	    }
	}
}
