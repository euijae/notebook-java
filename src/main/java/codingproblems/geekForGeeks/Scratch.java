package codingproblems.geekForGeeks;

import java.util.Arrays;

public class Scratch {

	public static void main(String[] args) {
		int [] nums = {0, 1, 2, 7, 11, 12, 23, 31, 52, 61, 69, 70}; //
		int key = 70;
		int index = binarySearch(nums,  0, nums.length-1, key);
		System.out.println(key + " is found at " + index);
		
		int [] nums1 = {10, 9, 8, 7, 6, 5};
		int [] nums2 = {10, 9, 8, 7, 6, 5};
		
		System.out.println("\n[Nums1] - Bubble sort\nBefore: " + Arrays.toString(nums1));
		bubbleSort(nums1);
		System.out.println("After : " + Arrays.toString(nums1));
		System.out.println("\n[Nums2] - Insertion sort\nBefore: " + Arrays.toString(nums2));
		insertionSort(nums2);
		System.out.println("After : " + Arrays.toString(nums2));
	}
	
	public static int binarySearch(int [] nums, int l, int r, int key) {
		int m = (l+r) / 2;
		
		if(l > r)
			return -1;
		
		if(nums[m] == key) {
			return m;
		} else {
			if(nums[m] < key)
				l = m+1;
			else
				r = m-1;
			
			return binarySearch(nums, l, r, key);
		}
	}
	
	public static void mergeSort(int [] nums) {
		
	}
	
	public static void bubbleSort(int [] nums) {
		if(nums == null || nums.length <= 1) return;
		
		for(int i = 0; i < nums.length-1; i++)
			for(int j = 1; j < nums.length - i; j++)
				if(nums[j-1] > nums[j])
					swap(nums, j-1, j);
	}
	
	public static void insertionSort(int [] nums) {
		if(nums == null || nums.length <= 1) return;
		
		for(int i = 0; i < nums.length-1; i++)
			for(int j = i+1; j < nums.length; j++)
				if(nums[i] > nums[j])
					swap(nums, i, j);
	}
	
	public static void swap(int [] nums, int i1, int i2) {
		int temp = nums[i1];
		nums[i1] = nums[i2];
		nums[i2] = temp;
	}
}
