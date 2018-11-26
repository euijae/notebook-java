package go.there.soon.scratch;

import java.util.ArrayList;

public class AmazonOnSite {

	public static void main(String[] args) {
		String str = "Our approach for quarters "
				+ "applies to dimes as well, "
				+ "but we apply this for each "
				+ "of the four of five parts of the " 
				+ "above statement. So, for the first part, "
				+ "we get the following statements:";
		
		ArrayList<String> lines = getLines(str, 30);
		System.out.println("---------------");
		for(String line : lines) {
			System.out.println(line);
		}
	}
	
	public static ArrayList<String> getLines(String str, int limit) {
		ArrayList<String> lines = new ArrayList<>();
		
		String [] strings = str.split(" ");
		String line = "";

		for(int i = 0; i < strings.length; i++) {
			if((line + " " + strings[i]).trim().length() > limit) {
				lines.add(line);
				line = strings[i];
			} else {
				line = (line + " " + strings[i]).trim();
			}
		}
		
		if(!line.isEmpty())
			lines.add(line);
		
		return lines;
	}
}
