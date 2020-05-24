package codingproblems.ctci.ch10.q2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GroupAnagrams {

	public static void main(String[] args) {
		String [] strings = {
			"acre", "restful", "considerate", "acer", "fluster",
			"race", "careisnoted"
		};
		
		groupAnagrams(strings);
		
		for(String string : strings) {
			System.out.println(string);
		}
	}

	public static String sort(String str) {
		char [] ch = str.toCharArray();
		Arrays.sort(ch);
		return String.valueOf(ch);
	}
	
	public static void groupAnagrams(String [] strs) {
		HashMap<String, ArrayList<String>> map = new HashMap<>();
		
		for(int i = 0; i < strs.length; i++) {
			String sorted = sort(strs[i]);
			ArrayList<String> anagrams = (map.containsKey(sorted)) ? map.get(sorted) : new ArrayList<>();
			anagrams.add(strs[i]);
			map.put(sorted, anagrams);
		}
		
		int i = 0;
		
		for(Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
			ArrayList<String> strings = entry.getValue();
			
			for(String string : strings) {
				strs[i] = string;
				i++;
			}
		}
	}
}
