package go.there.soon.leetCode.sortingSearching;

import java.util.Arrays;

public class FindKthLargest {

	public static void main(String[] args) {
		int [] arr = {3,2,3,1,2,4,5,5,6};
		int [] helper = new int[arr.length];
		mergeSort(arr, helper, 0, arr.length-1);
		
		int k = 4;
		System.out.println(Arrays.toString(arr));
		System.out.println(k + "th largest value is " + findKthLargest(arr, k));
	}

	public static int findKthLargest(int [] arr, int k) {
		int [] helper = new int[arr.length];
		mergeSort(arr, helper, 0, arr.length-1);
		
		return arr[arr.length-k];
	}
	
	public static void mergeSort(int [] arr, int [] helper, int left, int right) {
		if(left < right) {
			int mid = (left + right) / 2;

			mergeSort(arr, helper, left, mid);
			mergeSort(arr, helper, mid+1, right);
			merge(arr, helper, left, right, mid);
		}
	}
	
	public static void merge(int [] arr, int [] helper, int left, int right, int mid) {
		if(left > right) 
			return;
		
		for(int i = left; i <= right; i++) 
			helper[i] = arr[i];
		
		int countLeft = left;
		int countRight = mid+1;
		int countIndex = left;
		
		while(countLeft <= mid && countRight <= right) {
			if(helper[countLeft] <= helper[countRight]) {
				arr[countIndex] = helper[countLeft];
				countLeft++;
			} else {
				arr[countIndex] = helper[countRight];
				countRight++;
			}
			
			countIndex++;
		}
		
		while(countLeft <= mid) {
			arr[countIndex++] = helper[countLeft++];
		}
	}
}
