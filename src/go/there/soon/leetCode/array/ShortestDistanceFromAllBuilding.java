package go.there.soon.leetCode.array;

import java.util.LinkedList;

public class ShortestDistanceFromAllBuilding {

	public static void main(String[] args) {
		ShortestDistanceFromAllBuilding s = new ShortestDistanceFromAllBuilding();
		s.test();
	}

	public void test() {
		Solution s = new Solution();
		
		int [][] grid = {
				//{1,0}
				//{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}
				{1,1,1,1,1,0},
				{0,0,0,0,0,1},
				{0,1,1,0,0,1},
				{1,0,0,1,0,1},
				{1,0,1,0,0,1},
				{1,0,0,0,0,1},
				{0,1,1,1,1,0}
		};
		
		int shortest = s.shortestDistance(grid);
		System.out.print("shortest is " + shortest);
	}
	
	class Solution {
	    public int shortestDistance(int[][] m) {
	    		if(m == null || m.length <= 0)
	    			return -1;
	    	
	        int shortestDistance = Integer.MAX_VALUE;
	        
	        int totalBuilding = 0;
	        
	        for(int row = 0; row < m.length; row ++) {
	        		for(int col = 0; col < m[row].length; col ++) {
	        			if(m[row][col] == 1)
	        				totalBuilding ++;
	        		}
	        }
	        
	        if(totalBuilding < 1)
	        		return -1;
	        
	        int [][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
	        
	        for(int row = 0; row < m.length; row ++) {
	        		for(int col = 0; col < m[row].length; col++) {
	        			boolean [][] isVisited = new boolean[m.length][m[0].length];
	        			LinkedList<Integer []> q = new LinkedList<>();
	        			
	        			if(m[row][col] == 0) {
        					isVisited[row][col] = true;
	        				q.add(new Integer[] {row, col});
	        				
	        				int tempDistance = 0;
		        			int level = 1;
		        			int buildingCount = 0;
		        			
		        			while(!q.isEmpty()) {
		        				int size = q.size();
		        				for(int i = 0; i < size; i++) {
		        					Integer [] c = q.removeFirst();
		        					
		        					for(int [] dir : dirs) {
		        						int newR = c[0] + dir[0];
		        						int newC = c[1] + dir[1];
		        						
		        						if(isValid(m, newR, newC, isVisited)) {
		        							isVisited[newR][newC] = true;
		        							if(m[newR][newC] == 1) {
		        								tempDistance += level;
		        								buildingCount++;
		        							} else {
		        								q.add(new Integer[] {newR, newC});
		        							}
		        						}
		        					}
		        				}
		        				level++;
		        			}

		        			if(buildingCount != totalBuilding)
		        				shortestDistance = Math.max(shortestDistance, -1);
		        			else if(tempDistance != 0)
		        				shortestDistance = Math.min(shortestDistance, tempDistance);
	        			}
	        		}
	        }
	        
	        return (shortestDistance == 0 || shortestDistance == Integer.MAX_VALUE) ? -1 : shortestDistance;
	    }
	    
	    public boolean isValid(int [][] m, int row, int col, boolean [][] isVisited) {
	    		return (row >= 0 && row < m.length 
	    				&& col >= 0 && col < m[row].length
	    				&& m[row][col] != 2
	    				&& !isVisited[row][col]);
	    }
	}
}
