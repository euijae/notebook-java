package codingproblems.ctci.ch8.q8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermutationWithDups {

	public static void main(String[] args) {
		String str = "abcd";
		for(String s : permutation(str)) {
			System.out.println(s);
		}
	}
	
	public static List<String> permutation(String str) {
		Map<Integer, List<String>> map = new HashMap<>();
		for(int i = 0; i < str.length(); i++) {
			String ch = String.valueOf(str.charAt(i));
			if(i == 0) {
				List<String> value = new ArrayList<>();
				value.add(ch);
				map.put(i+1, value);
			} else {
				List<String> prevValue = new ArrayList<>(map.get(i));
				List<String> currValue = new ArrayList<>();
				
				for(String s : prevValue) {
					for(int j = 0; j <= s.length(); j++) {
						currValue.add(s.substring(0, j) + ch + s.substring(j));
					}
				}
				
				map.put(i+1, currValue);
			}
		}
		
		return map.get(str.length());
	}
}
