package go.there.soon.scratch;

import java.util.Arrays;

public class StringCompression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringCompression sc = new StringCompression();
		sc.test();
	}
	
	public void test() {
		//					 0   1   2   3   4   5   6   7   8   9      11
		Character [] arr = {'a','a','a','b','b','c','c','c','d','f','f','a','a',null};
		stringCompression(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public void stringCompression(Character [] arr) {
		int p1 = 0;
		int wIndex = 0;
		
		while(p1 < arr.length) {
			if(arr[p1] != null) {
				char ch = arr[p1];
				int counter = 0;
				
				while(p1 < arr.length && arr[p1] != null && arr[p1] == ch) {
					p1 ++;
					counter ++;
				}
				
				if(p1 < arr.length) {
					arr[wIndex++] = ch;
					
					if(counter > 1) {
						arr[wIndex++] = (char) ('0' + counter);
					}
				}
			} else {
				p1++;
			}
		}
		
		while(wIndex < arr.length) arr[wIndex++] = null;
	}

}
