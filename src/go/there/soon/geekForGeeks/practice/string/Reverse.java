package go.there.soon.geekForGeeks.practice.string;

/**
 * https://www.geeksforgeeks.org/reverse-an-array-without-affecting-special-characters/
 * @author eugene.kim
 *
 */
public class Reverse {
	private String original;
	private String result;
	
	public Reverse(String original) {
		this.setOriginal(original);
		this.result = this.reverseNotSpecialCharacters(original);
	}
	
	public static void main(String [] args) {
		Reverse r = new Reverse("Ab,c,de!$");
		System.out.print(r.getOriginal() + "\n" + r.getResult());
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
