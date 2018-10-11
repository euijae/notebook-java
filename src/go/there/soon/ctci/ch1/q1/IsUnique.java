package go.there.soon.ctci.ch1.q1;

import java.util.HashMap;
import java.util.Map;

public class IsUnique {

	public static void main(String[] args) {
		String str = "abcdefggg";
		System.out.println(sol1(str));
		System.out.println(sol2(str));
		System.out.println(sol3(str));
	}
	
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
	
	public static boolean sol2(String str) {
		char [] arr = str.toCharArray();
		Map<Character, Integer> dict = new HashMap<>();
		
		for(int i = 0; i < arr.length; i++) {
			if(dict.containsKey(arr[i])) {
				return false;
			} else {
				dict.put(arr[i], 1);
			}
		}
		
		return true;
	}
	
	public static boolean sol3(String str) {
		for(int i = 0; i < str.length()-1; i++) {
			for(int j = i+1; j < str.length(); j++) {
				if((str.charAt(i) ^ str.charAt(j)) == 0)
					return false;
			}
		}
		
		return true;
	}
}
