package go.there.soon.ctci.ch1.q1;

import java.util.HashSet;
import java.util.Set;

public class IsUnique {

	public static void main(String[] args) {
		String str = "abccdef";
		System.out.println(sol1(str));
		System.out.println(sol2(str));
		System.out.println(sol3_2(str));
		System.out.println(sol4(str));
	}
	
	/**
	 * Brute-force
	 * @param str
	 * @return
	 */
	public static boolean sol1(String str) {
		char [] arr = str.toCharArray();
		for(int i = 0; i < arr.length-1; i++) {
			for(int j = i+1; j < arr.length; j++) {
				if(arr[i] == arr[j]) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	/**
	 * O(n) time consumption while O(n) space is required at the same time
	 * @param str
	 * @return
	 */
	public static boolean sol2(String str) {
		Set<Character> set = new HashSet<>();

		for(int i = 0; i < str.length(); i++) {
			if(set.contains(str.charAt(i)))
				return false;

			set.add(str.charAt(i));
		}
		
		return true;
	}
	
	/**
	 * Use XOR operator but time O(n^2) not good option
	 * @param str
	 * @return
	 */
	public static boolean sol3(String str) {
		int xor = (int) str.charAt(0);
		for(int i = 1; i < str.length(); i++) {
			int charToInt = (int) str.charAt(i);
			int result = xor ^ charToInt;
			if(result == 0) {
				return false;
			} else {
				xor = result;
			}
		}
		
		return true;
	}
	
	/**
	 * this is what CTCI suggested and it is improved version of sol3
	 * @param str
	 * @return
	 */
	public static boolean sol3_2(String str) {
		int checker = 0;
		
		for(int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if((checker & (1 << val)) > 0)
				return false;
			System.out.println("val: " + val);
			checker = checker | (1 << val);
		}
		return true;
	}
	
	/**
	 * this is what CTCI suggested
	 * @param str
	 * @return
	 */
	public static boolean sol4(String str) {
		if(str.length() > 128)
			return false;
		
		boolean [] checker = new boolean[128];
		
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(checker[ch] == true)
				return false;
			checker[ch] = true;
		}
		
		return true;
	}
}
