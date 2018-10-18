package go.there.soon.ctci.ch1.q9;

import java.util.ArrayList;
import java.util.List;

public class StringRotation {

	public static void main(String[] args) {
		String s1 = "wawawabcdef";
		String s2 = "abcdefwawaw";
		System.out.println(sol1(s1, s2));
	}
	
	public static boolean sol1(String s1, String s2) {
		if(s1.length() * s2.length() == 0 || s1.length() != s2.length())
			return false;

		if(s1.equals(s2))
			return true;
		
		char comparator = s1.charAt(0);
		int SIZE = s1.length();
		List<Integer> indices = new ArrayList<>();
		
		for(int i = 1; i < SIZE; i++) {
			if(comparator == s2.charAt(i))
				indices.add(i);
		}
		
		boolean isFound = true;
		
		for(int j = 0; j < indices.size(); j++, isFound = true) {
			for(int i = 0; i < SIZE; i++) {
				int newIndex = (i + indices.get(j)) % SIZE;
				
				if(s1.charAt(i) != s2.charAt(newIndex)) {
					isFound = false;
					break;
				}
			}
			
			if(isFound) 
				return true;
		}
		
		return false;
	}
}
