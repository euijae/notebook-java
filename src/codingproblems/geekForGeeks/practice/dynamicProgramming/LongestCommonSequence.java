package codingproblems.geekForGeeks.practice.dynamicProgramming;

public class LongestCommonSequence {

	public static void main(String[] args) {
		int ans = lcs("ABCBDAB", "BDCABC");
		System.out.println("ans : " + ans);
	}
	
	public static int lcs(String s1, String s2) {
		int length1 = s1.length(),
			length2 = s2.length();

		int [][] matrix = new int[length1][length2];
		
		for(int i = 0; i < length1; i++) {
			for(int j = 0; j < length2; j++) {
				if(s1.charAt(i) == s2.charAt(j)) {
					matrix[i][j] = getValue(matrix, i-1, j-1) + 1;
				} else {
					matrix[i][j] = max(getValue(matrix, i-1, j), getValue(matrix, i, j-1));
				}
			}
		}
		
		return matrix[length1-1][length2-1];
	}
	
	public static int max(int i1, int i2) {
		return (i1 > i2) ? i1 : i2;
	}
	
	public static int getValue(int [][] matrix, int x, int y) {
		return (x < 0 || y < 0) ? 0 : matrix[x][y];
	}
}
