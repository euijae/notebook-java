package codingproblems.leetCode.intro;

/**
 * Given two strings A and B, find the minimum number of times 
 * A has to be repeated such that B is a substring of it. 
 * If no such solution, return -1. For example, with A = "abcd" and B = "cdabcdab".
 * Return 3, because by repeating A three times (“abcdabcdabcd”), 
 * B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").
 * Note:
 * The length of A and B will be between 1 and 10000.
 * @author euijae_kim
 *
 */
public class RepeatedStringMatch {
	
	public static void main(String[] args) {
		Solution s = new Solution();
		String A = "abc"; //"abcd";
		String B = "cabcabca"; //"cdabcdab";
		int repeated = s.repeatedStringMatch(A, B);
		System.out.println("repeated: " + repeated);
	}
}

class Solution {
    public int repeatedStringMatch(String A, String B) {
    		if(!B.contains(A)) {
			return -1;
    		}
    	
        int repeated = 1;
        String original = A;
        while(!A.contains(B) && A.length() <= 10000) {
        		A += original;
        		repeated++;
        		
        		System.out.println(">> r: " + repeated + ", contains? " + A.contains(B) + ", A: " + A);
        }
        
        if(A.length() > 10000)
        		return -1;

        if(!A.contains(B)) {
			return -1;
        }
        
        return repeated;
    }
}