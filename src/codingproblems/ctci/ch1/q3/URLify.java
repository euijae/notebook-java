package codingproblems.ctci.ch1.q3;

public class URLify {

	public static void main(String[] args) {
		String str = "Mr John Smith     ";
		int length = 13;
		System.out.println("<"+sol1(str, length)+">");
		System.out.println("<"+sol2(str, length)+">");
	}
	
	/**
	 * one thing that I have missed is that I understood that the more than one
	 * spaces can be allowed at not only the end but also anywhere in the string.
	 * BUT problem wants to restrict that the extra spaces are only at the end.
	 * @param str
	 * @param length
	 * @return
	 */
	public static String sol1(String str, int length) {
		int i  = 0;
		int countableIndex = 0;
		StringBuilder sb = new StringBuilder();
		
		while(countableIndex < length) {
			char ch = str.charAt(i);
			if(!Character.isWhitespace(ch)) {
				sb.append(ch);
				countableIndex++;
				i++;
			} else {
				if(i != 0) {
					sb.append("%20");
					countableIndex++;
				}
					
				while(Character.isWhitespace(str.charAt(i))) i++;
			}
		}
		
		return sb.toString();
	}
	
	public static String sol2(String str, int length) {
		char [] chars = str.toCharArray();
		
		int spaceCounter = 0;
		
		for(int i = 0; i < length; i++) {
			char ch = chars[i];
			if(Character.isWhitespace(ch))
				spaceCounter++;
		}
		
		int at = length + spaceCounter * 2;
		
		for(int i = length-1; i >= 0; i--) {
			char ch = chars[i];
			
			if(Character.isWhitespace(ch)) {
				chars[at-1] = '0';
				chars[at-2] = '2';
				chars[at-3] = '%';
				at = at-3;
			} else {
				chars[at-1] = chars[i];
				at--;
			}
		}
		
		
		return new String(chars);
	}
}
