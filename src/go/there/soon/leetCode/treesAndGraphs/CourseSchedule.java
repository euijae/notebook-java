package go.there.soon.leetCode.treesAndGraphs;

import java.util.*;

public class CourseSchedule {

	public static void main(String[] args) {
		(new CourseSchedule()).test();
	}

	public void test() {
		Solution s = new Solution();
		int n = 5;
		int [][] arr = {
				{1,0},{4,2},{2,4}
//				{2,0},{2,1}
//				{2,1}, {1,0}
//				{1,0}, {0,1}
//				{1,0}, {1,2}, {0,1}
		};
		
		System.out.println(s.canFinish(n, arr));
	}
	
	class Solution {
	    public boolean canFinish(int n, int[][] arr) {
	    		List<List<Integer>> graph = new ArrayList<>(n);
	    		
	    		for(int i = 0; i < n; i++)
	    			graph.add(new ArrayList<>());
	    		
	    		for(int i = 0; i < arr.length; i++) {
	    			int first = arr[i][1];
	    			int second = arr[i][0];
	    			
	    			if(first == second)
	    				return false;
	    			
	    			graph.get(first).add(second);
	    		}
	    		
	    		boolean [] v = new boolean[n];
	    		boolean [] s = new boolean[n];
	    		
	    		for(int i = 0; i < n; i++) {
	    			if(isCyclic(i, v, s, graph))
	    				return false;
	    		}
	    		
	    		return true;
	    }
	    
	    public boolean isCyclic(int i, boolean [] v, boolean [] s, List<List<Integer>> g) {
	    		if(s[i])
	    			return true;
	    		
	    		if(v[i])
	    			return false;
	    		
	    		s[i] = true;
	    		v[i] = true;
	    		
	    		for(Integer a : g.get(i))
	    			if(isCyclic(a, v, s, g)) 
	    				return true;
	    	
	    		s[i] = false;
	    		return false;
	    }
	}
}
