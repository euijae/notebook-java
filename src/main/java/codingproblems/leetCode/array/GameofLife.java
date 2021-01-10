package codingproblems.leetCode.array;

import java.util.Arrays;

public class GameofLife {

	public static void main(String[] args) {
		GameofLife gol = new GameofLife();
		gol.test();
	}

	public void test() {
		Solution s = new Solution();
		int [][] board = {
				{0,1,0},
				{0,0,1},
				{1,1,1},
				{0,0,0}
		};
		
		for(int [] arr : board)
			System.out.println(Arrays.toString(arr));
		
		s.gameOfLife(board);
		
		System.out.println("-----------");
		
		for(int [] arr : board)
			System.out.println(Arrays.toString(arr));
	}
	
	class Solution {
	    public void gameOfLife(int[][] board) {
	        if(board == null || board.length <= 0)
	        		return ;
	        
	        int ROW = board.length;
	        int COL = board[0].length;
	        
	        int [][] original = new int[ROW][COL];
	        
	        for(int i = 0; i < ROW; i++) 
	        		for(int j = 0 ; j < COL; j++) 
	        			original[i][j] = board[i][j];
	        
	        for(int i = 0; i < ROW; i++) {
	        		for(int j = 0; j < COL; j++) {
	        			int countLiveCell = countLiveCell(original, i, j);
	        			if(original[i][j] == 1 && (countLiveCell < 2 || countLiveCell > 3))
	        				board[i][j] = 0;
	        			else if(original[i][j] == 0 && countLiveCell == 3)
	        				board[i][j] = 1;
	        		}
	        }
	    }
	    
	    public int countLiveCell(int [][] m, int row, int col) {
	    		int countLiveCell = 0;
	    		
	    		for(int rowP = -1; rowP <= 1; rowP++)
	    			for(int colP = -1; colP <= 1; colP++)
	    				if(rowP != 0 || colP != 0)
	    					if(checkValidPoint(m, row+rowP, col+colP) && m[row+rowP][col+colP] == 1)
	    						countLiveCell ++;
	    		
	    		return countLiveCell;
	    }
	    
	    public boolean checkValidPoint(int [][] m, int row, int col) {
	    		return (m != null && row >= 0 && row < m.length && col >= 0 && col < m[row].length);
	    }
	}
}
