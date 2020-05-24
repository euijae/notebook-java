package codingproblems.ctci.ch8.q5;

public class RecursiveMultiply2 {

	public static void main(String[] args) {
		int small = 30;
		while(small >= 1) {
			System.out.println("s: " + small);
			small = small >> 1;
		}
		
		System.out.println(mult(41, 35));
	}

	public static int mult(int num1, int num2) {
		int large = (num1 > num2) ? num1 : num2;
		int small = (num1 > num2) ? num2 : num1;
		
		return helper(small, large);
	}
	
	public static int helper(int small, int large) {
		if(small == 0) {
			return 0;
		} else if(small == 1) {
			return large;
		} 

		return helper(small/2, large) + helper(small/2, large) + (small % 2 == 0 ? 0 : large);
	}
}
