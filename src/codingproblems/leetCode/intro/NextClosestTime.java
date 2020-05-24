package codingproblems.leetCode.intro;

import java.util.Arrays;

/**
 * @result - accepted. 
 * @lesson - think carefully about conditions. think careful!!!
 * @author euijae_kim
 * @note {
 * 		Given a time represented in the format "HH:MM", 
 * 		form the next closest time by reusing the current 
 * 		digits. There is no limit on how many times a 
 * 		digit can be reused. You may assume the given 
 * 		input string is always valid. 
 * 		For example, "01:34", "12:09" are all valid. 
 * 		"1:34", "12:9" are all invalid.
 * }
 */
public class NextClosestTime {

	public static void main(String[] args) {
		NextClosestTime nct = new NextClosestTime();
		nct.test();
	}
	
	public void test() {
		Solution s = new Solution();
		
		String [] times = {
				"19:34", // 19:39 
				"23:59", // 22:22 
				"13:55",  // 15:11
				"22:37"   // 23:22
			};
		
		String time = times[3];
		System.out.println("next closest time of " 
					+ time + " is " 
					+ s.nextClosestTime(time));
	}
	
	class Solution {
	    public String nextClosestTime(String time) {
	        String [] strings = time.split(":");
	        char [] hh = strings[0].toCharArray();
	        char [] mm = strings[1].toCharArray();
	        
	        int [] numbers = new int[4]; // 19:34 > 1,3,4,9
	        
	        for(int i = 0; i < hh.length; i++)
	        		numbers[i] = Character.getNumericValue(hh[i]);
	        
	        for(int i = 0, j = hh.length; i < mm.length; i++, j++)
        			numbers[j] = Character.getNumericValue(mm[i]);
	        
	        Arrays.sort(numbers);
	        
	        for(int i = mm.length-1; i >= 0; i--) {
	        		int nextSmallest = getNext(numbers, mm[i]);
	        		if(nextSmallest != -1) {
	        			if(i == 1) { // ones digit place 
	        				mm[i] = Character.forDigit(nextSmallest, 10);
	        				return charArrayToString(hh, mm);
	        			} else {
	        				if(nextSmallest <= 5 && nextSmallest >= 0) { // tenth digit place
	        					mm[i] = Character.forDigit(nextSmallest, 10);
	        					fill(mm, 1, numbers[0]);
	        					return charArrayToString(hh, mm);
	        				}
	        			}
	        		}
	        }
	        
	        for(int i = hh.length-1; i >= 0; i--) {
		        	int nextSmallest = getNext(numbers, hh[i]);
	        		if(nextSmallest != -1) {
	        			if(i == 1) { // ones digit place
	        				if((strings[0].compareTo("20") >= 0 && nextSmallest <= 3 && nextSmallest >= 0)
	        					|| (strings[0].compareTo("20") < 0)) { 
		        				hh[i] = Character.forDigit(nextSmallest, 10);
		        				fill(mm, 0, numbers[0]);
		        				return charArrayToString(hh, mm);
	        				}
	        			} else {
	        				if(nextSmallest <= 2 && nextSmallest >=0){ // tenth digit place
	        					hh[i] = Character.forDigit(nextSmallest, 10);
	        					fill(hh, 1, numbers[0]);
	        					return charArrayToString(hh, mm);
	        				} 
	        			}
	        		}
	        }
	        
	        fill(hh, 0, numbers[0]);
	        fill(mm, 0, numbers[0]);
	        
	        return charArrayToString(hh, mm);
	    }
	    
	    public void fill(char [] arr, int start, int smallest) {
	    		for(int i = start; i < arr.length; i++)
	    			arr[i] = Character.forDigit(smallest, 10);
	    }
	    
	    public int getNext(int [] numbers, char ch) {
	    		int next = -1;
	    		int chToInt = Character.getNumericValue(ch);
	    		for(int number : numbers) {
	    			if(chToInt < number)
	    				return number;
	    		}
	    		
	    		return next;
	    }
	    
	    public String charArrayToString(char [] hh, char [] mm) {
	    		return String.valueOf(hh) + ":" + String.valueOf(mm);
	    }
	}
}