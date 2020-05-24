package codingproblems.ctci.ch1.q8;

public class ZeroMatrix {

	public static void main(String[] args) {
		int [][] m = {
				{1, 4, 7, 10},
				{2, 5, 0, 11},
				{3, 6, 9, 12}
		};
		System.out.println("");
		sol2(m);
		print(m);
	}
	
	public static boolean sol1(int [][] m) {
		if(m == null || m.length == 0 || m[0].length == 0)
			return false;
		
		int M = m.length;
		int N = m[0].length;
		
		int [] zeroes = new int[N];
		for(int i = 0; i < N; i++)
			zeroes[i] = 0;
		
		int [][] temp = new int[M][N];
		
		for(int i = 0; i < M; i++)
			for(int j = 0; j < N; j++)
				temp[i][j] = m[i][j];
		
		for(int i = 0; i < M; i++)
			for(int j = 0; j < N; j++)
				if(temp[i][j] == 0) {
					m[i] = zeroes;
					
					for(int k = 0; k < M; k++)
						if(k != i)
							m[k][j] = 0;
					
					break;
				}
		
		return true;
	}
	
	public static void sol2(int [][] m) {
		int M = m.length;
		int N = m[0].length;
		boolean rowHasZero = false;
		boolean colHasZero = false;
		
		for(int j = 0; j < N; j++) {
			if(m[0][j] == 0) {
				rowHasZero = true;
				break;
			}
		}
		
		for(int i = 0; i < M; i++) {
			if(m[i][0] == 0) {
				colHasZero = true;
				break;
			}
		}
		
		for(int i = 1; i < M; i++) {
			for(int j = 1; j < N; j++) {
				if(m[i][j] == 0) {
					m[i][0] = 0;
					m[0][j] = 0;
				}
			}
		}
		
		for(int j = 1; j < N; j++) 
			for(int i = 1; i < M; i++) 
				if(m[0][j] == 0 || m[i][0] == 0) 
					m[i][j] = 0;
		
		if(colHasZero) 
			for(int i = 0; i < M; i++)
				m[i][0] = 0;
		
		if(rowHasZero) 
			for(int j = 0; j < N; j++)
				m[0][j] = 0;
	}
	
	public static void print(int [][] m) {
		int M = m.length;
		int N = m[0].length;
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++)
				System.out.print(m[i][j] + " ");
			System.out.println("");
		}
	}
}
