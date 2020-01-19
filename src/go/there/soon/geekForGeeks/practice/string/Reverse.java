package go.there.soon.geekForGeeks.practice.string;

/**
 * https://www.geeksforgeeks.org/reverse-an-array-without-affecting-special-characters/
 * @author euijaekim
 *
 */
public class Reverse {
	private String original;
	private String result;
	
	public Reverse() {}
	
	public Reverse(String original) {
		this.setOriginal(original);
		this.result = this.reverseNotSpecialCharacters(original);
	}
	
	public static void main(String [] args) {
		String s = "a,b$c";
		Reverse r = new Reverse(s);
		System.out.print(r.getOriginal() + "\n" + r.getResult());
		
		Reverse r2 = new Reverse();
		System.out.printf("orig: %s\n revs: %s\n", s, r2.reverseNotSpecialCharacters2(s));
	}
	
	public String reverseNotSpecialCharacters2(String str) {
		char [] arr = str.toCharArray();
		int p1 = 0;
		int p2 = arr.length-1;
		
		while(p1 < p2) {
			while(p1 < p2 && !isAlphabet(arr[p1])) p1++;
			if(p1 >= p2) return String.valueOf(arr);
			while(p1 < p2 && !isAlphabet(arr[p2])) p2--;
			if(p1 >= p2) return String.valueOf(arr);
			swap(arr, p1, p2);
		}
		
		return String.valueOf(arr);
	}
	
	public boolean isAlphabet(char ch) {
		int val1 = ch - 'a';
		int val2 = ch - 'A';
		return (val1 >= 0 && val1 < 26) || (val2 >= 0 && val2 < 26);
	}	
	
	
	
	
	
	
	public String reverseNotSpecialCharacters(String str) {
		char [] chars = str.toCharArray();
		int l = 0;
		int r = chars.length-1;
		
		while(l < r) {
			if(isCharacter(chars[l]) && isCharacter(chars[r])) {
				swap(chars, l++, r--);
			} else {
				if(!isCharacter(chars[l])) l++;
				if(!isCharacter(chars[r])) r--;
			}
		}
		
		return String.valueOf(chars);
	}
	
	/*********************
	 * UTILITY FUNCTIONS *
	 *********************/
	public void swap(char [] chars, int l, int r) {
		char temp = chars[l];
		chars[l] = chars[r];
		chars[r] = temp;
	}
	
	public boolean isCharacter(char ch) {
		int val = (int) ch;
		
		return ((val >= 48 && val <= 57) 
				|| (val >= 65 && val <= 90) 
				|| (val >= 97 && val <= 122));
	}
	
	/*********************
	 * GETTER AND SETTER *
	 *********************/
	public String getOriginal() {
		return original;
	}

	public void setOriginal(String original) {
		this.original = original;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
