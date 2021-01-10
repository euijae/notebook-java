package codingproblems.ctci.ch8.q3;

public class MagicIndex2 {

	public static void main(String[] args) {
		MagicIndex2 o = new MagicIndex2();
		int [] arr = {-10,-5,2,2,2,3,4,8,9,12,13};
		int index = o.findMagicIndex(arr);
		System.out.println("magic index is found at " + index);
	}

	public int findMagicIndex(int [] arr) {
		return findMagicIndex(arr, 0, arr.length-1);
	}
	
	private int findMagicIndex(int [] arr, int start, int end) {
		if(start > end) 
			return -1;
		
		int mid = (start + end) / 2;
		
		if(arr[mid] == mid)
			return mid;
		
		int left = findMagicIndex(arr, start, Math.min(arr[mid], mid-1));
		
		if(left != -1) 
			return left;
		
		int right = findMagicIndex(arr, Math.max(arr[mid], mid+1), end);
		
		if(right != -1)
			return right;
		
		return -1;
	}
}
