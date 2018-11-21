package go.there.soon.ctci.ch10;

import java.util.Arrays;


/**
 *original: [4, 7, 10, 1, 2, 3, 15, 9]
	pivot: 1, l:1, r: 0, arr: [1, 7, 10, 4, 2, 3, 15, 9]
	pivot: 2, l:2, r: 1, arr: [1, 2, 10, 4, 7, 3, 15, 9]
	pivot: 7, l:5, r: 3, arr: [1, 2, 3, 4, 7, 10, 15, 9]
	pivot: 4, l:4, r: 2, arr: [1, 2, 3, 4, 7, 10, 15, 9]
	pivot: 3, l:3, r: 1, arr: [1, 2, 3, 4, 7, 10, 15, 9]
	pivot: 15, l:7, r: 6, arr: [1, 2, 3, 4, 7, 10, 9, 15]
	pivot: 10, l:6, r: 5, arr: [1, 2, 3, 4, 7, 9, 10, 15]
 
 *
 */

public class Concepts {

	public static void main(String[] args) {
		int [] arr = {4, 7, 10, 1, 2, 3, 15, 9};
		System.out.println("original: " + Arrays.toString(arr));
		quicksort(arr);
	}
	
	public static void quicksort(int [] arr) {
		quicksort(arr, 0, arr.length-1);
	}
	
	public static void quicksort(int [] arr, int left, int right) {
		int index = partition(arr, left, right); 
		
		if(left < index - 1) 
			quicksort(arr, left, index-1);
		
		if(index <  right)
			quicksort(arr, index, right);
	}
	
	public static int partition(int [] arr, int left, int right) {
		int pivot = arr[(left + right) / 2];
		
		while(left <= right) {
			while(arr[left] < pivot)  left ++;
			while(arr[right] > pivot) right--;
			
			if(left <= right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				
				left ++;
				right --;
			}
		}
		
		System.out.println("pivot: " + pivot + ", l:" + left + ", r: " + right + ", arr: " + Arrays.toString(arr));
		return left;
	}
 	
	public static void mergesort(int [] arr) {
		int [] helper = new int[arr.length];
		mergesort(arr, helper, 0, arr.length-1);
	}
	
	public static void mergesort(int [] arr, int [] helper, int left, int right) {
		if(left < right) {
			int mid = (left + right) / 2;
			
			mergesort(arr, helper, left, mid);
			mergesort(arr, helper, mid+1, right);
			merge(arr, helper, left, mid, right);
		}
	}
	
	public static void merge(int [] arr, int [] helper, int left, int mid, int right) {
		for(int i = left; i <= right; i++) {
			helper[i] = arr[i];
		}
		
		int helperLeft = left;
		int helperRight = mid+1;
		int current = left;
		
		while(helperLeft <= mid && helperRight <= right) {
			if(helper[helperLeft] <= helper[helperRight]) {
				arr[current] = helper[helperLeft];
				helperLeft++;
			} else {
				arr[current] = helper[helperRight];
				helperRight++;
			}
			
			current ++;
		}
		
		int remaining = mid - helperLeft;
		
		for(int i = 0; i <= remaining; i++) {
			arr[current + i] = helper[helperLeft + i];
		}
	}
}
