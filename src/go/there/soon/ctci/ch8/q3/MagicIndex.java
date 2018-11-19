package go.there.soon.ctci.ch8.q3;

public class MagicIndex {

	public static void main(String[] args) {
		int [] arr = {-40, -20, 2, 2, 2, 3, 5, 7, 9, 12, 13}; 
		//{-1, 0, 1, 2, 4, 6};
		System.out.println(sol2(arr, 0, arr.length-1));
	}

	public static int sol1(int [] arr, int start, int end) {
		if(start > end)
			return Integer.MIN_VALUE; 
		
		int mid = (start + end) / 2;
		
		if(arr[mid] == mid) {
			return mid;
		} else if(arr[mid] < mid) {
			return sol1(arr, mid+1, end);
		} else {
			return sol1(arr, start, mid-1);
		}
	}
	
	public static int sol2(int [] arr, int start, int end) {
		if(start > end)
			return Integer.MIN_VALUE; 
		
		int mid = (start + end) / 2;
		
		if(arr[mid] == mid)
			return mid;
		
		int left = sol2(arr, start, Math.min(mid-1, arr[mid]));
		if(left >= 0)
			return left;
		
		int right = sol2(arr, Math.max(mid+1, arr[mid]), end);
		
		if(right >= 0)
			return right;
		
		return Integer.MIN_VALUE;
	}
}
