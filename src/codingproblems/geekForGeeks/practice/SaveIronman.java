package codingproblems.geekForGeeks.practice;

/**
 * https://practice.geeksforgeeks.org/problems/save-ironman/0
 * @author eugene.kim
 *
 */
public class SaveIronman {

	public String saveHim(String str) {
		str = str.toLowerCase();
		char [] arr = str.toCharArray();

		int i1 = 0;
		int i2 = arr.length-1;
		
		while(i1 < i2) {
			if(isValid(arr[i1]) && isValid(arr[i2])) {
				if(arr[i1] != arr[i2]) 
					return "NO";
				i1++;
				i2--;
			} else if(!isValid(arr[i1]) && !isValid(arr[i2])) {
				i1++;
				i2--;
			} else {
				if(!isValid(arr[i1])) {
					i1++;
				} else {
					i2--;
				}
			}
		}
		
		return "YES";
	}
	
	public static boolean isValid(char ch) {
		int num = (int) ch;
		return ((num >= 48 && num <= 57) 
				|| (num >= 97 && num <= 122) || (num >= 65 && num <= 90));
	}
}
