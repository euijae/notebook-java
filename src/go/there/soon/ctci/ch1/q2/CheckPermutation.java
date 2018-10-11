package go.there.soon.ctci.ch1.q2;

import java.util.HashMap;
import java.util.Map;

public class CheckPermutation {

	public static void main(String[] args) {
		String s1 = "aaaaaa";
		String s2 = "aaaaab";

		System.out.println(sol1(s1, s2));
	}
	
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
}
