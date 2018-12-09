package go.there.soon.leetCode.treesAndGraphs;

public class FB_NumberOfIslands {

	public static void main(String[] args) {
		FB_NumberOfIslands f = new FB_NumberOfIslands();
		f.test();
	}

	public void test() {
		Solution s = new Solution();
		
		char [][] grid = {
				{'1','1','1','1','0'},
				{'1','1','0','1','0'},
				{'1','1','0','0','1'},
				{'0','0','1','0','0'}
		};
		
		int n = s.numIslands(grid);
		System.out.println(n);
	}
	
	class Solution {
	    public int numIslands(char[][] grid) {
	        int count = 0;
	        
	        for(int i = 0; i < grid.length; i++) {
	        		for(int j = 0; j < grid[i].length; j++) {
	        			if(isValid(grid, i, j)) {
	        				count++;
	        				dfs(grid, i, j);
	        			}
	        		}
	        }
	        
	        return count;
	    }
	    
	    public void dfs(char [][] grid, int row , int col) {
	    		if(isValid(grid, row, col)) {
	    			grid[row][col] = 'x';
	    			dfs(grid, row+1, col);
	    			dfs(grid, row-1, col);
	    			dfs(grid, row, col+1);
	    			dfs(grid, row, col-1);
	    		}
	    }
	    
	    public boolean isValid(char [][] grid, int row, int col) {
	    		return (row >= 0 && col >= 0 
	    				&& row < grid.length 
	    				&& col < grid[row].length
	    				&& grid[row][col] == '1');
	    }
	}
}

