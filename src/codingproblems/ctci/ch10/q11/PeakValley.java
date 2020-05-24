package codingproblems.ctci.ch10.q11;

import java.util.Arrays;

public class PeakValley {

	public static void main(String[] args) {
		int [] arr = {9,1,0,4,8,7};
		sortPV(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void sortPV(int [] arr) {
		if(arr == null || arr.length < 3)
			return;
		
		for(int i = 1; i < arr.length-1; i++)
			if(isAbsoluteIncOrDesc(arr, i)) {
				int largestIndex = (arr[i-1] >= arr[i+1]) ? i-1 : i+1;
				swap(arr, i, largestIndex);
			}
	}
	
	public static boolean isAbsoluteIncOrDesc(int [] arr, int center) {
		if(center == 0 || center == arr.length-1)
			return false;
		
		return ((arr[center-1] <= arr[center] && arr[center] <= arr[center+1])
			|| (arr[center-1] >= arr[center] && arr[center] >= arr[center+1]));
	}
	
	public static void swap(int [] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
