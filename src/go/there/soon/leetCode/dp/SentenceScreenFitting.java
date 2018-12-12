package go.there.soon.leetCode.dp;

public class SentenceScreenFitting {

	public static void main(String[] args) {
		SentenceScreenFitting o = new SentenceScreenFitting();
		o.test();
	}

	public void test() {
		Solution sol = new Solution();
		String [] sentence = {"f"};
		int rows   = 2000;
		int cols   = 2000;
		int cycles = sol.wordsTyping(sentence, rows, cols);
		System.out.println("There are " + cycles);
	}
	
	class Solution {
	    public int wordsTyping(String[] sentence, int rows, int cols) {
	        if(sentence.length == 0 || rows == 0 || cols == 0)
	            return 0;
	        
	        int cycle = 0;
	        int pIndex = 0;
	        int length = 0;
	        
	        for(int i = 0; i < rows; i++) {
	        		while(length + sentence[pIndex].length() <= cols) {
	        			length += sentence[pIndex].length();
	        			if(length < cols)
	        				length++;

	        			if(pIndex == sentence.length-1) {
	        				cycle++;
	        			}

	        			pIndex = (pIndex + 1) % sentence.length;
	        		}
	        		
	        		length = 0;
	        }
	        
	        return cycle;
	    }
	}
}
