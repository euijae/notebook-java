package main.java.datastructures.sorting;

import java.util.Arrays;

public class Merge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer [] a = {2, 6, 3, 5, 1};
		mergeSort(a);
		System.out.println(Arrays.toString(a));
	}

	@SuppressWarnings("rawtypes")
	public static void mergeSort(Comparable [] a) {
		Comparable [] temp = new Comparable[a.length];
		mergeSort(a, temp, 0, a.length-1);
	}

	@SuppressWarnings("rawtypes")
	public static void mergeSort(Comparable [] a, Comparable [] tmp, int left, int right) {
		if(left < right) {
			int center = (left + right) / 2;
			mergeSort(a, tmp, left, center);
			mergeSort(a, tmp, center+1, right);
			merge(a, tmp, left, center + 1, right);
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void merge(Comparable [] a, Comparable [] tmp, int left, int right, int rightEnd) {
		int leftEnd = right - 1;
		int k = left;
		int num = rightEnd - left + 1;

		while(left <= leftEnd && right <= rightEnd) {
			if(a[left].compareTo(a[right]) <= 0) {
				tmp[k++] = a[left++];
			} else {
				tmp[k++] = a[right++];
			}
		}

		while(left <= leftEnd) {
			tmp[k++] = a[left++];
		}

		while(right <= rightEnd) {
			tmp[k++] = a[right++];
		}

		for(int i = 0; i < num; i++, rightEnd--) {
			a[rightEnd] = tmp[rightEnd];
		}
	}
}
