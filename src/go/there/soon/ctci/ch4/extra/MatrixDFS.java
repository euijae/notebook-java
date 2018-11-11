package go.there.soon.ctci.ch4.extra;

import java.util.Stack;

public class MatrixDFS {

	public static void main(String[] args) {
		int [][] m = {
				{1, 1, 0, 0, 1, 1},
				{0, 0, 1, 0, 0, 1, 1, 1, 1},
				{1, 0, 0, 0, 1, 0},
				{0, 0, 0, 0, 1, 1}
		};
		int area = getArea2(m);
		System.out.println(area);
	}
	
	/**
	 * solution with recursive way
	 */
	public static int getArea2(int [][] m) {
		if(m == null) return 0;
		int area = 0;
		
		for(int i = 0; i < m.length; i++) 
			for(int j = 0; j < m[i].length; j++) 
				if(isValid(m, i, j)) 
					area = Math.max(area, dfs(m, i, j));
		
		return area;
	}
	
	public static int dfs(int [][] m, int x, int y) {
		if(isValid(m, x, y)) {
			m[x][y] = -1;
			return 1 + dfs(m, x-1, y) + dfs(m, x+1, y) + dfs(m, x, y-1) + dfs(m, x, y+1);
		} else {
			return 0;
		}
	}
	
	public static boolean isValid(int [][] m, int x, int y) {
		return !(m == null || x < 0 || x >= m.length || y < 0 || y >= m[x].length || m[x][y] != 1);
	}
	
	/**
	 * first trial with stack and non-recursive solution
	 */
	public static int helper(int [][] m, int i, int j) {
		Stack<Integer []> stack = new Stack<>();
		stack.push(new Integer[] {i, j});
		m[i][j] = -1;
		int counter = 1;
		
		while(!stack.isEmpty()) {
			Integer [] points = stack.pop();
			int x = points[0];
			int y = points[1];
			
			for(int i1 = 0; i1 <= 1; i1++) {
				for(int j1 = -1; j1 <= 1; j1 = j1 + 2) {
					int newX = (i1 == 0) ? x + j1 : x;
					int newY = (i1 == 0) ? y : y + j1;
					if(!isInvalid(m, newX, newY)) {
						stack.push(new Integer[] {newX, newY});
						m[newX][newY] = -1;
						counter ++;
					}
				}
			}
		}
		
		return counter;
	}
	
	public static int getArea(int [][] m) {
		if(m == null)
			return 0;
		
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < m.length; i++) {
			for(int j = 0; j < m[i].length; j++) {
				if(!isInvalid(m, i, j)) {
					int counter = helper(m, i, j);
					max = Math.max(max, counter);
				}
			}
		}
		
		return max;
	}
	
	public static boolean isInvalid(int [][] m, int x, int y) {
		return (m == null || x < 0 || y < 0 || x >= m.length || y >= m[x].length || m[x][y] == 0 || m[x][y] == -1);
	}
}
