package go.there.soon.ctci.ch1.q2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CheckPermutation {

	public static void main(String[] args) {
		String s1 = "aaaaaa";
		String s2 = "aaaaaa";

		System.out.println(sol1(s1, s2));
		System.out.println(sol2(s1, s2));
		System.out.println(sol3(s1, s2));
	}
	
	/**
	 * my solution using maps and takes O(n) where n be the length of string s1.
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static boolean sol1(String s1, String s2) {
		if(s1 == null || s2 == null || s1.length() != s2.length()) 
			return false;
		
		if(s1.equals(s2)) 
			return true;
		
		Map<Character, Integer> map = new HashMap<>();
		
		for(int i = 0; i < s1.length(); i++) {
			char key = s1.charAt(i);
			int value = (map.containsKey(key)) ? map.get(key) + 1 : 1;
			map.put(key, value);
		}
		
		for(int i = 0; i < s2.length(); i++) {
			char key = s2.charAt(i);
			if(!map.containsKey(key)) {
				return false;
			} else {
				int value = map.get(key);
				if(value == 1) {
					map.remove(key);
				} else {
					map.put(key, value - 1);
				}
			}
		}
		
		return (map.size() == 0);
	}
	
	public static boolean sol2(String s1, String s2) {
		if(s1 == null || s2 == null || s1.length() != s2.length())
			return false;
		
		int [] counter = new int[128];
		
		for(int i = 0; i < s1.length(); i++) {
			counter[s1.charAt(i)]++;
		}
		
		for(int i = 0; i < s2.length(); i++) {
			int index = s2.charAt(i);
			if(counter[index] == 0)
				return false;
			counter[index]--;
		}
		
		return true;
	}
	
	public static boolean sol3(String s1, String s2) {
		return sort(s1).equals(sort(s2));
	}
	
	public static String sort(String str) {
		char [] arr = str.toCharArray();
		Arrays.sort(arr);
		return new String(arr);
	}
}
