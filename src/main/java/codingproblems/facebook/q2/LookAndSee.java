package codingproblems.facebook.q2;

public class LookAndSee {

	public static void main(String[] args) {
		for(String str : sol1(10)) {
			System.out.println(str);
		}
		
	}
	
	public static String [] sol1(int n) {
		String [] sequences = new String[n];
		sequences[0] = "1";
		sequences[1] = "11";
		
		for(int k = 2; k < n; k++) {
			StringBuilder sb = new StringBuilder();
			String str = sequences[k-1];
			int counter = 1;
			for(int i = 1; i < str.length(); i++) {
				if(str.charAt(i-1) != str.charAt(i)) {
					sb.append("" + counter + str.charAt(i-1));
					counter = 1;
				} else {
					counter ++;
				}
			}
			
			sb.append("" + counter + str.charAt(str.length()-1));
			sequences[k] = sb.toString();
		}
		
		return sequences;
	}
}
