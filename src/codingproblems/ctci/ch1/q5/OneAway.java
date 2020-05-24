package codingproblems.ctci.ch1.q5;

public class OneAway {

	public static void main(String[] args) {
		String s1 = "ctat";
		String s2 = "caat";
		System.out.println(sol1(s1, s2));
	}
	
	/**
	 * have to analyze correctly. What's the point and 
	 * what restrictions are given. keep moving on !!!
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static boolean sol1(String s1, String s2) {
		if(Math.abs(s1.length() - s2.length()) > 1)
			return false;
		
		boolean editFound = false;
		int i1 = 0;
		int i2 = 0;
		
		for(; i2 < s2.length();) {
			if(s1.charAt(i1) != s2.charAt(i2)) {
				if(editFound) return false;
				editFound = true;
				
				if(s1.length() == s2.length()) {
					i1++;
					i2++;
				} else {
					i1++;
				}
			} else {
				i1 ++;
				i2 ++;
			}
		}
		
		return true;
	}
}
