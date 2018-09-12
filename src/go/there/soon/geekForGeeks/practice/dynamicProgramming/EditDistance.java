package go.there.soon.geekForGeeks.practice.dynamicProgramming;

/**
 * https://www.geeksforgeeks.org/edit-distance-dp-5/
 * @author eugene.kim
 *
 */
public class EditDistance {

	public static void main(String[] args) {
		String s1 = "lrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmcoq";
		String s2 = "hnwnkuewhsqmgbbuqcljjivswmdkqtbxixmvtrrbljptnsnfwzqfjmafadrrwsofsbcnuvqhffbsaqxwpqcaceh";
		System.out.println(editDistance1(s1, s2));
		System.out.println(editDistance2(s1, s2));
	}

	/**
	 * 
	 * @param str1
	 * @param str1
	 * @return
	 */
	public static int editDistance2(String str1,String str2) {
		int len1 = str1.length();
		int len2 = str2.length();
		int [][] m = new int[len1+1][len2+1];
		
		for(int i = 0; i <= len1; i++) {
			for(int j = 0; j <= len2; j++) {
				if(i * j == 0) {
					m[i][j] = i + j;
				} else {
					if(str1.charAt(i-1) == str2.charAt(j-1)) {
						m[i][j] = m[i-1][j-1];
					} else {
						m[i][j] = 1 + Math.min(m[i][j-1], Math.min(m[i-1][j], m[i-1][j-1]));
					}
				}
			}
		}
		
		return m[len1][len2];
	}
	
	public static int editDistance1(String str1, String str2) {
		int count  = 0;
		int length = str2.length();
		
		for(int i = 0; i < length; i++) {
			if(str1.charAt(i) != str2.charAt(i)) {
				if(str1.length() == str2.length()) {
					str1 = replace(str1, str2, i);
				} else if(str1.length() > str2.length()) {
					str1 = remove(str1, i);
				} else {
					str1 = insert(str1, str2, i);
				}
				
				count++;
			}
		}
		
		return count;
	}
	
	public static String remove(String s1, int at) {
		return s1.substring(0, at) 
				+ s1.substring(at+1);
	}
	
	public static String insert(String s1, String s2, int at) {
		return s1.substring(0, at) 
				+ Character.toString(s2.charAt(at)) 
				+ s1.substring(at);
	}
	
	public static String replace(String s1, String s2, int at) {
		char [] chars = s1.toCharArray();
		chars[at] = s2.charAt(at);
		
		return new String(chars);
	}
}
