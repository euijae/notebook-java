package codingproblems.ctci.ch1.q6;

public class StringCompression {

	public static void main(String[] args) {
		String str = "aabccdeeee";
		System.out.println(getCompressed(str));
		System.out.println(getCompressed2(str));
	}

	/**
	 * Wrote this again for Amazon interview on August 2019
	 * @param str
	 * @return
	 */
	public static String getCompressed2(String str) {
		char ch = str.charAt(0);
		int counter = 1;
		StringBuilder sb = new StringBuilder();

		for(int i = 1; i < str.length(); i++) {
			if(ch == str.charAt(i)) {
				counter ++;
			} else {
				sb.append(ch + String.valueOf(counter));
				ch = str.charAt(i);
				counter = 1;
			}

			if(i == str.length() - 1)
				sb.append(ch + String.valueOf(counter));
		}

		return sb.toString();
	}

	public static String getCompressed(String str) {
		if(str.length() < 2)
			return str;
		
		StringBuilder compressed = new StringBuilder();
		char [] chars = str.toCharArray();
		char c1 = chars[0];
		int counter = 1;
		
		for(int i = 1; i < chars.length; i++) {
			char c2 = chars[i];
			
			if(c1 != c2) {
				compressed.append(c1 + counter);
				counter = 1;
				c1 = c2;
			} else {
				counter ++;
			}
		}
		
		compressed.append(c1 + counter);
		
		return (str.length() > compressed.length()) ? compressed.toString() : str;
	}
}
