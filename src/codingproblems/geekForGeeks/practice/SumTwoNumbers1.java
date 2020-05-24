package codingproblems.geekForGeeks.practice;

/**
 * https://practice.geeksforgeeks.org/problems/sum-of-two-numbers-represented-as-arrays/0
 * @author eugene.kim
 *
 */
public class SumTwoNumbers1 {

	public static int addTwoNumbers(int [] arr1, int [] arr2) {
		int L = arr1.length;
		int S = arr2.length;
		int sum = 0;
		
		for(int i = L-1, j = 0; i >= 0; i--, j++) {
			int k = i - (L-S);
			sum += ((k >= 0) ? arr1[i] + arr2[k] : arr1[i]) * Math.pow(10, j);
		}
		
		return sum;
	}
}
