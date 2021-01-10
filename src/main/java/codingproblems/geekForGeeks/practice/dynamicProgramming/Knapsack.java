package codingproblems.geekForGeeks.practice.dynamicProgramming;

public class Knapsack {

	public static void main(String[] args) {
		int W = 11;
		int [] weights = {1, 2, 5, 6, 7};
		int [] values  = {1, 6, 18, 22, 28};
		int X = values.length + 1;
		int Y = W + 1;
		System.out.println(knapsack(weights, values, X, Y));
	}

	public static int knapsack(int [] w, int [] v, int X, int Y) {
		int [][] dp = new int[X][Y];
		
		for(int i = 1; i < X; i++)
			for(int wi = 1; wi < Y; wi++) {
				dp[i][wi] = (wi < w[i-1]) ? dp[i-1][wi] : Math.max(dp[i-1][wi-w[i-1]] + v[i-1], dp[i-1][wi]);
			}
		
		return dp[X-1][Y-1];
	}
}
