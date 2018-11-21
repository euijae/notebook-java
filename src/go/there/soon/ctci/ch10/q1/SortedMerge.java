package go.there.soon.ctci.ch10.q1;

import java.util.Arrays;

public class SortedMerge {

	public static void main(String[] args) {
		int [] arrA = new int[12];
		Arrays.fill(arrA, Integer.MIN_VALUE);
		
		arrA[0] = 1;
		arrA[1] = 2;
		arrA[2] = 4;
		arrA[3] = 5;
		arrA[4] = 8;
		arrA[5] = 9;
		arrA[6] = 12;
		arrA[7] = 15;
		
		int [] arrB = {6, 10, 13, 17};
		merge(arrA, arrB, 7, 3);
		System.out.println(Arrays.toString(arrA));
	}

	public static void merge(int [] a, int [] b, int lastA, int lastB) {
		int indexA = lastA;
		int indexB = lastB;
		
		int indexMerged = lastA + lastB + 1;
		
		while(indexB >= 0) {
			if(indexA >= 0 && a[indexA] > b[indexB]) {
				a[indexMerged] = a[indexA];
				indexA--;
			} else {
				a[indexMerged] = b[indexB];
				indexB--;
			}
			
			indexMerged --;
		}
	}
	
	/**
	 * below is my solution and it is not efficient
	 * because it requires extra buffers and unnecessary time
	 */
	public static void merge1(int [] arrA, int [] arrB) {
		int leftIndex = -1;
		int endA = -1;
		
		for(int i = 0; i < arrA.length; i++) {
			if(arrB[0] < arrA[i] && leftIndex == -1) {
				leftIndex = i;
			}
			
			if(arrA[i] == Integer.MIN_VALUE && i != 0) {
				endA = i-1;
				break;
			}
		}
		
		merge1Helper(arrA, arrB, leftIndex, endA);
	}
	
	public static void merge1Helper(int [] arrA, int [] arrB, int start, int endA) {
		int leftIndex = start;
		int rightIndex = 0;
		int endB = arrB.length-1;
		
		int SIZE = (endA - leftIndex + 1) + arrB.length;
		int [] helper = new int[SIZE];
		int current = 0;
		
		while(leftIndex <= endA && rightIndex <= endB) {
			if(arrA[leftIndex] <= arrB[rightIndex]) {
				helper[current] = arrA[leftIndex];
				leftIndex++;
			} else {
				helper[current] = arrB[rightIndex];
				rightIndex++;
			}
			
			current ++;
		}
		
		while(leftIndex <= endA) {
			helper[current] = arrA[leftIndex];
			leftIndex++;
			current ++;
		}
		
		while(rightIndex <= endB) {
			helper[current] = arrB[rightIndex];
			rightIndex++;
			current ++;
		}
		
		current = 0;
		for(int i = start; i < arrA.length; i++, current++) {
			arrA[i] = helper[current];
		}
	}
}
