package go.there.soon.ctci.ch1.q3;

public class URLify {

	public static void main(String[] args) {
		String str = "    Mr     John Smith      ";
		int length = 12;
		System.out.println("<"+sol(str, length)+">");
	}
	
	public static String sol(String str, int length) {
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
}
