package codingproblems.geekForGeeks.practice.dynamicProgramming;

import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/find-the-longest-path-in-a-matrix-with-given-constraints/
 * @author eugene.kim
 *
 */
public class LongestPathInMatrix {
	
	public static void main(String[] args) {
		int [][] matrix = {{1, 2, 9}, {5, 3, 8}, {4, 6, 7}};
		
		System.out.println(longestPath(matrix));
	}

	public static int longestPath(int [][] matrix) {
		int longest = 0;
		int SIZE = matrix.length * matrix[0].length;
		int [][] record = new int[matrix.length][matrix[0].length];
		
		for(int i = 0; i < matrix.length; i++)
			for(int j = 0; j < matrix[0].length; j++)
				record[i][j] = -1;
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				int x = i;
				int y = j;
				
				int temp = 1;
				boolean loopStopper = false;

				while(temp <= SIZE && !loopStopper) {
					if(isValid(matrix, x, y, 1, 0)) x++; 
					else if(isValid(matrix, x, y, -1, 0)) x--;
					else if(isValid(matrix, x, y, 0, 1))  y++;
					else if(isValid(matrix, x, y, 0, -1)) y--;
					else loopStopper = true;
					
					if(record[x][y] != -1) {
						temp += record[x][y];
						loopStopper = true;
					}
					
					if(!loopStopper) temp ++;
				}
				
				record[i][j] = temp;
				longest = Math.max(longest, temp);
			}
		}
		
		for(int i = 0; i < record.length; i++)
			System.out.println(Arrays.toString(record[i]));
		
		return longest;
	}
	
	public static boolean isValid(int [][] m, int i, int j, int x, int y) {
		return isValidPoint(m, i, j) && isValidPoint(m, i+x, j+y) && isConnected(m, i, j, x, y);
	}
	
	public static boolean isValidPoint(int [][] m, int x, int y) {
		return !(x < 0 || y < 0 || x > m.length -1 || y > m[0].length-1);
	}
	
	public static boolean isConnected(int [][] m, int i, int j, int x, int y) {
		return (m[i+x][j+y] - m[i][j] == 1);
	}
}
