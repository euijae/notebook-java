package go.there.soon.ctci.ch8.q7;

import java.util.ArrayList;

public class PermutationWithoutDups {

	public static void main(String[] args) {
		boolean isDuplicated = true;
		ArrayList<String> pList = permutation("abc", !isDuplicated);
		
		for(String str : pList) {
			System.out.println(str);
		}
	}

	public static ArrayList<String> permutation(String str, boolean isDuplicated) {
		ArrayList<String> list = new ArrayList<>();
		
		if(isDuplicated) {
			permutationHelper2("", str, list);
		} else {
			permutationHelper1("", str, list);
		}
		
		return list;
	}
	
	public static void permutationHelper1(String prefix, String suffix, ArrayList<String> list) {
		if(suffix.length() == 0) {
			list.add(prefix);
		} else {
			for(int i = 0; i < suffix.length(); i++) {
				String pre = String.valueOf(suffix.charAt(i));
				String suf = suffix.substring(0, i) + suffix.substring(i+1);
				permutationHelper1(prefix + pre, suf, list);
			}
		}
	}
	
	public static void permutationHelper2(String prefix, String suffix, ArrayList<String> list) {
		if(suffix.length() == 0) {
			list.add(prefix);
		} else {
			for(int i = 0; i < suffix.length(); i++) {
				if(i == 0 || (i > 0 && suffix.charAt(i-1) != suffix.charAt(i))) {
					String pre = String.valueOf(suffix.charAt(i));
					String suf = suffix.substring(0, i) + suffix.substring(i+1);
					permutationHelper2(prefix + pre, suf, list);
				}
			}
		}
	}
}
