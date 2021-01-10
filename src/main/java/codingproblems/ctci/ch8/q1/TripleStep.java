package codingproblems.ctci.ch8.q1;

public class TripleStep {

	public static void main(String[] args) {
		System.out.println(tripleStep(4));
		System.out.println(sol1(4));
		System.out.println(sol2(4));
	}

	/**
	 * optimized solution
	 * @param n
	 * @return
	 */
	public static int tripleStep(int n) {
		int [] D = new int[n+1];
		
		D[0] = D[1] = 1;
		D[2] = 2;
		D[3] = 4;
		
		for(int i = 3; i <= n; i++) 
			D[i] = D[i-1] + D[i-2] + D[i-3];
		
		return D[n];
	}
	
	public static int sol1(int n) {
		if(n < 0) return 0;
		if(n == 0) return 1;
		
		return sol1(n-1) + sol1(n-2) + sol1(n-3);
	}
	
	public static int sol2(int n) {
		return sol2_helper(n, new int[n+1]);
	}
	
	public static int sol2_helper(int n, int [] memo) {
		if(n < 0) 
			return 0;
		if(n == 0)
			return 1;
		
		if(memo[n] == 0) {
			memo[n] = sol2_helper(n-3, memo) 
					+ sol2_helper(n-2, memo)
					+ sol2_helper(n-1, memo);
		}
		
		return memo[n];
	}
}
