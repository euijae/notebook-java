package go.there.soon.ctci.ch1.q6;

public class StringCompression {

	public static void main(String[] args) {
		String str = "aabccdeeaa";
		System.out.println(getCompressed(str));
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
