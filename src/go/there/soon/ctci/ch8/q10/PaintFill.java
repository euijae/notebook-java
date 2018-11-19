package go.there.soon.ctci.ch8.q10;

public class PaintFill {

	public static void main(String[] args) {
		int [][] m = {
				{1, 1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 0, 0},
				{1, 0, 0, 1, 1, 0, 1, 1},
				{1, 2, 2, 2, 2, 0, 1, 0},
				{1, 1, 1, 2, 2, 0, 1, 0},
				{1, 1, 1, 2, 2, 2, 2, 0},
				{1, 1, 1, 1, 1, 2, 1, 1},
				{1, 1, 1, 1, 1, 2, 2, 1}
		};
		
		paintFill(m, 7, 7, 9);
		
		for(int i = 0; i < m.length; i++) {
			for(int j = 0; j < m[i].length; j++)
				System.out.print(m[i][j] + " ");
			
			System.out.println();
		}
	}

	public static void paintFill(int [][] m, int row, int col, int newColor) {
		if(m[row][col] == newColor) return;
		paintFillHelper(m, row, col, m[row][col], newColor);
	}
	
	public static void paintFillHelper(int [][] m, int row, int col, int oldColor, int newColor) {
		if(isValid(m, row, col, oldColor)) {
			m[row][col] = newColor;
			paintFillHelper(m, row-1, col  , oldColor, newColor);
			paintFillHelper(m, row+1, col  , oldColor, newColor);
			paintFillHelper(m, row  , col-1, oldColor, newColor);
			paintFillHelper(m, row  , col+1, oldColor, newColor);
		}
	}
	
	public static boolean isValid(int [][] m, int row, int col, int color) {
		return (m != null && row >= 0 && row < m.length 
						  && col >= 0 && col < m[row].length 
						  && m[row][col] == color);
	}
}