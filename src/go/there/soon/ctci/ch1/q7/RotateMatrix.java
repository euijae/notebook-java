package go.there.soon.ctci.ch1.q7;

/**
 * @TODO indexing. offset = i - first ...
 */
public class RotateMatrix {

	public static void main(String[] args) {
		int [][] m = {{1,2,3},
				{4, 5, 6},
				{7, 8, 9}};
		sol1(m);
	}

	public static void sol1(int [][] m) {
		if(m.length != m[0].length)
			return;
		int N = m.length;

		int [][] temp = new int[N][N];

		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
				temp[i][j] = m[i][j];

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++)
				m[j][N-1-i] = temp[i][j];
		}
	}

	public static void print(int [][] m) {
		for(int i = 0; i < m.length; i++) {
			for(int j = 0; j < m[0].length; j++)
				System.out.print(m[i][j] + " ");
			System.out.println("");
		}
	}
}
