package codingproblems.geekForGeeks.problem.sortSearch;

public class Search {
	
	/**
	 * https://www.geeksforgeeks.org/binary-search/
	 * @param arr
	 * @param low
	 * @param hi
	 * @param key
	 * @return
	 */
	public int binarySearch(int [] arr, int low, int hi, int key) {
		if(hi < low)
			return -1;
		
		int mid = (hi + low) / 2;
		
		if(arr[mid] == key) {
			return mid;
		}else if(arr[mid] > key) {
			return binarySearch(arr, low, mid-1, key);
		} else {
			return binarySearch(arr, mid+1, hi, key);
		}
	}
	
	/**
	 * https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
	 * @param arr
	 * @param low
	 * @param hi
	 * @param key
	 * @return
	 */
	public int rotatedArraySearch(int [] arr, int low, int hi, int key) {
		int pivot = findPivot(arr, low, hi);
		
		if(arr[pivot] == key) {
			return pivot;
		} else if(pivot == -1) {
			return binarySearch(arr, low, hi, key);
		} else {
			int index = binarySearch(arr, low, pivot, key);
			return (index == -1) ? binarySearch(arr, pivot+1, hi, key) : index;
		}
	}
	
	/**
	 * https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
	 * @param arr
	 * @param low
	 * @param hi
	 * @return
	 * 
	 * TODO Find the way to implement it in Log N time complexity.
	 */
	public int findPivot(int [] arr, int low, int hi) {	
		for(int i = 0; i < arr.length-1; i++)
			if(arr[i] > arr[i+1]) 
				return i;
		
		return -1;
	}
}
