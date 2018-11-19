package go.there.soon.ctci.ch8.q9;

import java.util.ArrayList;

public class Parens {

	public static void main(String[] args) {
		String str = "((()))";
		
		for(String s : parens(str))
			System.out.println(s);
	}

	public static ArrayList<String> parens(String str) {
		ArrayList<String> list = new ArrayList<>();
		
		if(str.length() % 2 == 1)
			return list;
		
		parensHelper(0, "", str, list);
		return list;
	}
	
	public static void parensHelper(int countOpenParen, String before, String after, ArrayList<String> list) {
		if(after.length() == 0) {
			list.add(before);
		} else {
			for(int i = 0; i < after.length(); i++) {
				
				/** this if condition is to avoid duplication. */
				if((i == 0) || (i > 0 && after.charAt(i-1) != after.charAt(i))) {
					String pre = String.valueOf(after.charAt(i));
					String suf = after.substring(0, i) + after.substring(i+1);

					if(pre.equals("("))
						countOpenParen ++;
					
					/** the condition is to avoid return the result starting ')' & ending with '(' */
					if((before.length() == 0 && pre.equals("(")
						|| (before).length() != 0 && (before).startsWith("("))
						&& !(suf.length() == 0 && (before+pre).endsWith("("))
						&& ((before+pre).length() <= countOpenParen*2)) {
						parensHelper(countOpenParen, before + pre, suf, list);
					}
					
					if(pre.equals("("))
						countOpenParen --;
				}
			}
		}
	}
}
