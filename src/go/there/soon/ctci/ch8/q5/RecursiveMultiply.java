package go.there.soon.ctci.ch8.q5;

public class RecursiveMultiply {

	public static void main(String[] args) {
		System.out.println(0^0);
		System.out.println(sol1(0, 4, 10));
		System.out.println(sol2(5, 7));
	}

	/**
	 * only use addition 
	 */
	public static int sol1(int product, int multiplier, int multiplicand) {
		if(multiplicand >= 1) {
			return sol1(product + multiplier, multiplier, multiplicand-1);
		} else {
			return product;
		}
	}
	
	public static int sol2(int multiplier, int multiplicand) {
		if(multiplier < 0 || multiplicand < 0)
			return -1;
		else if(multiplier == 0 || multiplicand == 0)
			return 0;
		
		int small = Math.min(multiplier, multiplicand);
		int bigger = Math.max(multiplier, multiplicand);
		
		return sol2_helper(bigger, small, 0, 0);
	}
	
	/**
	 * use shift
	 */
	private static int sol2_helper(int multiplier, int multiplicand, int div, int power) {
		div /= 2;
		
		if(div > 0) {
			return sol2_helper(multiplier, multiplicand, div, ++power);
		} else {
			multiplicand -= (1 << power);
			
			if(multiplicand <= 1) {
				return (multiplier << power) + (multiplicand == 1 ? multiplier : 0);
			} else {
				return (multiplier << power) + sol2_helper(multiplier, multiplicand, multiplicand, 0); 
			}
		}
	}
}
