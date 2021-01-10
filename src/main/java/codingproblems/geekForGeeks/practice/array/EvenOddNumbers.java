package codingproblems.geekForGeeks.practice.array;

import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/even-numbers-even-index-odd-numbers-odd-index/
 * Even numbers at even index and odd numbers at odd index
 * Given an array of size n containing equal number of odd and even numbers. The problem is to arrange the numbers in such a way that all the even numbers get the even index and odd numbers get the odd index. Required auxiliary space is O(1).
 * @author euijaekim
 *
 */
public class EvenOddNumbers {

	public static void main(String[] args) {
		int [] arr = {10,9,7,18,13,19,4,20,21,14};
		sort2(arr);
	}
	
	public static void sort2(int [] arr) {
		int p1 = 0;
		int p2 = 1;
		int n = arr.length;
		
		while(p1 < n && p2 < n) {
			while(p1 < n && arr[p1] % 2 == 0) p1 += 2;
			while(p2 < n && arr[p2] % 2 == 1) p2 += 2;
			
			if(p1 < n && p2 < n) {
				int temp = arr[p1];
				arr[p1] = arr[p2];
				arr[p2] = temp;
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}
	
	/**
	 * quadratic time complexity 
	 * @param arr
	 */
	public static void sort1(int [] arr) {
		int p1 = 0;
		int p2 = 1;
		
		while(p1 < arr.length && p2 < arr.length) {
			boolean even = arr[p1] % 2 == 0;
			boolean odd  = arr[p2] % 2 == 1;
			
			if(even && odd) {
			} else if(even) {
				for(int i = p2 + 1; i < arr.length; i++) {
					if(arr[i] % 2 == 1) {
						int temp = arr[p2];
						arr[p2] = arr[i];
						arr[i] = temp;
						break;
					}
				}
			} else if(odd) {
				for(int i = p1 + 1; i < arr.length; i++) {
					if(arr[i] % 2 == 0) {
						int temp = arr[p1];
						arr[p1] = arr[i];
						arr[i] = temp;
						break;
					}
				}
			} else {
				int temp = arr[p1];
				arr[p1] = arr[p2];
				arr[p2] = temp;
			}
			
			p1 += 2;
			p2 += 2;
		}
		
		System.out.println(Arrays.toString(arr));
	}
}
