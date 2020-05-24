package codingproblems.ctci.ch10.q9;

public class SortedMatrixSearch {

	public static void main(String[] args) {
		int [][] m = {
				{5, 35, 45, 65},
				{10, 50, 80, 90},
				{15, 60, 100, 150},
				{20, 70, 120, 170}
		};

		System.out.println(isFound(m, 120));
	}
	
	public static boolean isFound(int [][] m, int target) {
		int M = m.length;
		int N = m[0].length;
		int index = -1;
		
		for(int i = 0; i < M; i++) {
			int [] arr = m[i];
			
			if(arr[0] <= target && target <= arr[N-1])
				index = binarySearch(arr, target, 0, N-1);
			
			if(index != -1) {
				System.out.println(target + " is found at (" + i + ", " + index + ")");
				return true;
			}
		}
		
		System.out.println(target + " is not found.");
		return false;
	}
	
	public static int binarySearch(int [] arr, int target, int left, int right) {
		if(left > right) 
			return -1;
		
		int mid = (left + right) / 2;
		
		if(arr[mid] < target) {
			return binarySearch(arr, target, mid+1, right);
		} else if(arr[mid] > target) {
			return binarySearch(arr, target, left, mid-1);
		} else {
			return mid;
		}
	}
}
