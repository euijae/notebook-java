package codingproblems.ctci.ch8.q12;

import java.util.ArrayList;

public class EightQueens {

	final static int GRID_SIZE = 8; 
	
	public static void main(String[] args) {
		int [] columns = new int[GRID_SIZE];
		ArrayList<int []> results = new ArrayList<>();
		placeQueens(0, columns, results);
		System.out.println(results.size());
	}
	
	public static void placeQueens(int row, int [] columns, ArrayList<int []> results) {
		if(row == GRID_SIZE) {
			results.add(columns.clone());
		} else {
			for(int col = 0; col < GRID_SIZE; col++) {
				if(checkValid(columns, row, col)) {
					columns[row] = col;
					placeQueens(row+1, columns, results);
				}
			}
		}
	}
	
	public static boolean checkValid(int [] columns, int ROW, int COL) {
		for(int row = 0; row < ROW; row++) {
			int column = columns[row];
			if(column == COL)
				return false;
			
			int colDistance = Math.abs(column - COL);
			int rowDistance = ROW-row;
			
			if(colDistance == rowDistance)
				return false;
		}
		
		return true;
	}
}
