package codingproblems.ctci.ch10.q3;

public class SearchInRotatedArray {

	public static void main(String[] args) {
		int [] arr = {1, 1, 1, 20, 25, 1};
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + " is found at "  +finalSol(arr, 0, arr.length-1, arr[i]));
		}
	}

	/**
	 * inefficient way - no reason why we need to use linear search
	 * @param target
	 * @param arr
	 * @return
	 */
	public static int sol1(int target, int [] arr) {
		if(arr == null || arr.length == 0)
			return -1;
		
		int numberOfRotation = 0;
		
		for(int i = 1; i < arr.length; i++) {
			if(arr[i-1] < arr[i]) 
				numberOfRotation ++;
			else
				break;
		}
		
		if(numberOfRotation == arr.length-1)
			numberOfRotation = 0;
		
		for(int i = 0; i < arr.length; i++) {
			int newI = (i + numberOfRotation) % arr.length;
			
			if(arr[newI] == target)
				return newI;
		}
		
		return -1;
	}
	
	public static int sol1_binarySearch(int target, int [] arr, int left, int right, int rotation) {
		if(left > right) {
			return -1;
		}
		
		int mid = (left + right) / 2;
		
		if(arr[mid] == target)
			return mid;
		
		if(arr[mid] < target) {
			return sol1_binarySearch(target, arr, mid+1, right, rotation);
		} else {
			return sol1_binarySearch(target, arr, left, mid-1, rotation);
		}
	}
	
	public static int sol2(int [] arr, int target, int left, int right) {
		if(left > right)
			return -1;
		
		int mid = (left + right) / 2;
		
		if(arr[mid] == target)
			return mid;
		
		if(arr[mid] < target) {
			if(target <= arr[right])
				return sol2(arr, target, mid+1, right);
			else
				return sol2(arr, target, left, mid-1);
		} else {
			if(target >= arr[left])
				return sol2(arr, target, left, mid-1);
			else {
				return sol2(arr, target, mid+1, right);
			}
		}
	}
	
	public static int finalSol(int [] arr, int left, int right, int target) {
		if(left > right) {
			return -1;
		} 
		
		int mid = (left + right) / 2;
		if(arr[mid] == target) 
			return mid;
		
		if(arr[mid] < arr[right]) {
			if(arr[mid] < target && target <= arr[right]) {
				return finalSol(arr, mid+1, right, target);
			} else {
				return finalSol(arr, left, mid-1, target);
			}
		} else if(arr[left] < arr[mid]) {// left is a normally ordered
			if(arr[left] <= target && target < arr[mid])
				return finalSol(arr, left, mid-1, target);
			else
				return finalSol(arr, mid+1, right, target);
		} else if(arr[left] == arr[mid]) {
			if(arr[mid] != arr[right]) {
				return finalSol(arr, mid+1, right, target);
			} else {
				int result = finalSol(arr, left, mid-1, target);
				if(result == -1) {
					return finalSol(arr, mid+1, right, target);
				} else {
					return result;
				}
			}
		}
		
		return -1;
	}
}
