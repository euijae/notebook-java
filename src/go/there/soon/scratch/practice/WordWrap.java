package go.there.soon.scratch.practice;

import java.util.*;

public class WordWrap {

	public static void main(String[] args) {
		String [] str = {"Our approach for quarters"
				,"applies to dimes as well,"
				,"but we apply this for each"
				,"of the four of five parts of the" 
				,"above statement. So, for the first part"
				,"we get the following statements:"};
		
		List<String> lines = getLines(str, 30);
		drawHorizontalLine(30);

		for(String line : lines) {
			System.out.println(line);
		}
	}

	public static void drawHorizontalLine(int length) {
		while(length > 0) {
			System.out.print("-" + (length == 1 ? "\n" : ""));
			length--;
		}
	}

	public static ArrayList<String> getLines(String [] strings, int limit) {
		ArrayList<String> lines = new ArrayList<>();
		
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
