package codingproblems.ctci.ch10.q5;

public class SpareSearch {

	public static void main(String[] args) {
		String [] arr = {
				"at", "", "",
				"", "ball", "",
				"", "car", "",
				"", "dad", "", ""
		};
		
		String target = "ball";
		
		System.out.println(target + " is found at " + binarySearch2(arr, target));
	}

	public static int binarySearch2(String [] strings, String target) {
		return binarySearch(strings, target, 0, strings.length-1);
	}
	
	public static int binarySearch2(String [] arr, String target, int first, int last) {
		if(first > last) 
			return -1;
		int mid = (first + last) / 2;
		
		if(arr[mid].isEmpty()) {
			int left = mid-1;
			int right = mid+1;
			
			while(true) {
				if(left < first || right > last)
					return -1;
				else if(left >= first && !arr[left].isEmpty()) {
					mid = left;
					break;
				} else if(right <= last && !arr[right].isEmpty()) {
					mid = right;
					break;
				} 
				
				right ++;
				left --;
			}
		}
		
		if(arr[mid].compareTo(target) > 0) {
			return binarySearch(arr, target, first, mid-1);
		} else if(arr[mid].compareTo(target) < 0) {
			return binarySearch(arr, target, mid+1, last);
		} else {
			return mid;
		}
	}
	
	public static int binarySearch(String [] strings, String target) {
		return binarySearch(strings, target, 0, strings.length-1);
	}
	
	public static int binarySearch(String [] arr, String target, int left, int right) {
		if(left > right) 
			return -1;
		
		int mid = (left + right) / 2;
		
		if(arr[mid].isEmpty()) {
			if(arr[mid].equals(target))
				return mid;
			
			int leftPointer = 0;
			int rightPointer = 0;
			
			while(mid-leftPointer >= left && arr[mid-leftPointer].isEmpty())  leftPointer++;
			while(mid+rightPointer <= right && arr[mid+rightPointer].isEmpty()) rightPointer++;
			
			if(mid - leftPointer < left) {
				if(mid + rightPointer < arr.length) {
					if(arr[mid+rightPointer].compareTo(target) < 0)
						return -1;
					else if(arr[mid+rightPointer].compareTo(target) > 0) {
						left = mid + rightPointer;
						mid = (left + right) / 2;
					} else {
						return mid+rightPointer;
					}
				}
			} else if(mid + rightPointer > right) {
				if(mid - leftPointer >= 0) {
					if(arr[mid-leftPointer].compareTo(target) < 0)
						return -1;
					else if(arr[mid-leftPointer].compareTo(target) > 0) {
						right = mid-leftPointer;
						mid = (left + right) / 2;
					} else {
						return mid-leftPointer;
					}
				}
					
			} else {
				mid += rightPointer;
			}
		}
		
		if(arr[mid].compareTo(target) > 0) {
			System.out.println("left: " + left + ", mid: " + mid);
			return binarySearch(arr, target, left, mid-1);
		} else if(arr[mid].compareTo(target) < 0) {
			return binarySearch(arr, target, mid+1, right);
		} else {
			return mid;
		}
		
	}
}
