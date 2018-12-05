package go.there.soon.ctci.ch10.q1;

import java.util.Arrays;

public class SortedMerge2 {

	public static void main(String[] args) {
		int [] a = {5,6,7,8,9,10,11,12};
		int [] A = new int [20];
		for(int i = 0; i < a.length; i++)A[i] = a[i];
		int [] B = {1,2,3,4};
		
		System.out.println(Arrays.toString(A));
		System.out.println(Arrays.toString(B));
		sortedMerge(A, B, a.length-1, B.length-1);
		System.out.println(Arrays.toString(A));
	}
	
	public static void sortedMerge(int [] A, int [] B, int lenA, int lenB) {
		int current = lenA + lenB + 1;
		
		while(lenA >= 0 && lenB >= 0)
			A[current--] = (A[lenA] > B[lenB]) ? A[lenA--] : B[lenB--];
		
		while(lenB >= 0)
			A[current--] = B[lenB--];
	}
}
