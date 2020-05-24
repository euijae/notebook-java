package codingproblems.leetCode.array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public static void main(String[] args) {
		SpiralMatrix sm = new SpiralMatrix();
		sm.test();
	}
	
	public void test() {
		Solution s = new Solution();
//		int [][] matrix = {
//				{1,2,3}
//				,{4,5,6}
//				,{7,8,9}
//		};
		
		int [][] matrix = {
				{1,2,3,4}
				,{5,6,7,8}
				,{9,10,11,12}
				,{13,14,15,16}
		};
		
		System.out.println(s.spiralOrder(matrix).toString());
	}
	
	class Solution {
	    public List<Integer> spiralOrder(int[][] matrix) {
	        List<Integer> list = new ArrayList<>();
	        
	        if(matrix == null || matrix.length == 0)
    				return list;
	        
	        int m = matrix.length;
	        int n = matrix[0].length;
	        int rotations = Math.min(m, n);
	        rotations /= 2;
	        
	        boolean [][] visited = new boolean[m][n];
	        
	        for(int rotation = 0; rotation <= rotations; rotation++) {
	        		for(int c = rotation; c <= n-1-rotation; c++) {
	        			if(!visited[rotation][c]) {
	        				visited[rotation][c] = true;
		        			list.add(matrix[rotation][c]);
	        			}
	        		}
	        		
	        		for(int r = 1 + rotation; r <= m-2-rotation; r++) {
	        			if(!visited[r][n-1-rotation]) {
	        				visited[r][n-1-rotation] = true;
		        			list.add(matrix[r][n-1-rotation]);
	        			}
	        		}
        		
	        		for(int c = n-1-rotation; c >= rotation; c--) {
	        			if(!visited[m-1-rotation][c]) {
	        				visited[m-1-rotation][c] = true;
		        			list.add(matrix[m-1-rotation][c]);
	        			}
	        		}
        		
	        		for(int r = m-2-rotation; r >= 1 + rotation; r--) {
	        			if(!visited[r][rotation]) {
	        				visited[r][rotation] = true;
		        			list.add(matrix[r][rotation]);
	        			}
	        		}
	        }
	        
	        return list;
	    }
	}
	
}
