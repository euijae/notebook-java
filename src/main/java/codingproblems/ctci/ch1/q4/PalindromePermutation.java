package codingproblems.ctci.ch1.q4;

public class PalindromePermutation {

	public static void main(String[] args) {
		String str = "Tact Coaa";
		System.out.println(sol1(str));
		System.out.println(sol2(str));
	}
	
	public static boolean sol1(String str1) {
		String str = str1.toLowerCase();
		int countOdd = 0;
		int [] countChars = new int[26];
		for(int i = 0; i < str.length(); i++) {
			char key = str.charAt(i);
			
			if(getCharacterValue(key) != -1) {
				countChars[key - 'a'] ++;
				
				if(countChars[key - 'a'] % 2 == 1)
					countOdd ++;
				else
					countOdd --;
			}
		}
		
		return countOdd <= 1;
	}
	
	public static boolean sol2(String str) {
		int countOdd = 0;
		
		int [] arr = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
		
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if(getCharacterValue(ch) != -1) {
				int index = getCharacterValue(ch); 
				arr[index] ++;
				if(arr[index] % 2 == 1)
					countOdd++;
				else
					countOdd--;
			}
		}
		
		return countOdd <= 1;
	}
	
	public static int getCharacterValue(char ch) {
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int c = Character.getNumericValue(ch);
		
		if(c >= a && c <= z) 
			return c-a;

		return -1;
	}
}
