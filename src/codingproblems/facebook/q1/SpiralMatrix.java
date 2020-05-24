package codingproblems.facebook.q1;

public class SpiralMatrix {

	public static void main(String[] args) {
		int [][] m = sol1(4);
		
		for(int i = 0; i < m.length; i++) {
			for(int j = 0; j < m[0].length; j++) {
				print(m[i][j]);
			}
			System.out.println("");
		}
	}
	
	public static int [][] sol1(int n) {
		if(n <= 0) {
			throw new IllegalArgumentException("n must be > 0");
		}
		
		int [][] m = new int[n][n];
		int i = 0, 
			j = 0,
			length = n,
			val = 1;
		
		for(int layer = 0; layer <= length/2; layer++) {
			for(int direction = 1; direction <= 4; direction++) {
				if(direction == 1) {
					i = layer;
					for(j = layer; j < length - layer; j++) {
						m[i][j] = val++;
					}
				} else if(direction == 2) {
					j = length - 1 - layer;
					for(i = 1 + layer;  i < length - layer; i++) {
						m[i][j] = val++;
					}
				} else if(direction == 3) {
					i = length - 1 - layer;
					for(j = length - 2 - layer; j >= layer; j--) {
						m[i][j] = val++;
					}
				} else {
					j = layer;
					for(i = length - 2 - layer; i > layer; i--) {
						m[i][j] = val++;
					}
				}
			}
		}
		
		return m;
	}
	
	public static void print(int value) {
		System.out.print(value + " ");
	}
}
