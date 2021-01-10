package codingproblems.geekForGeeks.problem.sortSearch;

import codingproblems.geekForGeeks.problem.heap.Heap;

public class Sort {

	/**
	 * {@link Heap}
	 * @param a
	 */
	public void heapSort(int [] a) {
	}
	
	public void quickSort(int [] a) {
		quickSort(a, 0, a.length-1);
	}
	
	public void quickSort(int [] a, int left, int right) {
		if(left < right) {
			int partitionIndex = partition(a, left, right);
			quickSort(a, left, partitionIndex-1);
			quickSort(a,  partitionIndex + 1, right);
		}
	}
	
	public int partition(int [] a, int left, int right) {
		int i = left - 1;
		int pivot = a[right];
		System.out.println("------------------------");
		System.out.println("left: " + left + ", right:" + right + ", pivot: " + pivot);
		for(int j = left; j < right; j++) {
			if(a[j] <= pivot) {
				i++;
				System.out.println("a[" + i + "] = " + a[i] + ", a[" + j + "] = " + a[j]);
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				print(a);
			}
		}

		int temp = a[i+1];
		a[i+1] = a[right];
		a[right] = temp;
		print(a);
		System.out.println("i+1: " + (i+1));
		return i+1;
	}
	
	/**
	 * 
	 * @param a
	 */
	public void mergeSort(int [] a) {
		int [] temp = new int[a.length];
		mergeSort(a, temp, 0, a.length-1);
	}
	
	public void mergeSort(int [] a, int [] temp, int left, int right) {
		int center = (left + right) / 2;
		
		if(left < right) {
			mergeSort(a, temp, left, center);
			mergeSort(a, temp, center+1, right);
			merge(a, temp, left, center+1, right);
		}
	}
	
	public void merge(int [] a, int [] temp, int left, int right, int rightEnd) {
		int k = left; // index
		int leftEnd = right - 1;
		int num = rightEnd - left + 1;
		
		while(left <= leftEnd && right <= rightEnd) {
			if(a[left] <= a[right]) {
				temp[k++] = a[left++];
			} else {
				temp[k++] = a[right++];
			}
		}
		
		while(left <= leftEnd) {
			temp[k++] = a[left++];
		}
		while(right <= rightEnd) {
			temp[k++] = a[right++];
		}
		
		// TODO indexing
		for(int i = 0; i < num; i++, rightEnd--) {
			a[rightEnd] = temp[rightEnd];
		}
	}
	
	/**
	 * 
	 * @param arr
	 */
	public void selectionSort(int [] arr) {
		for(int i = 0; i < arr.length-1; i++) {
			for(int j = i+1; j < arr.length; j++) {
				if(arr[i] > arr[j]) {
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
	}
	
	/**
	 * 
	 * @param arr
	 */
	public void insertionSort(int [] arr) {
		
	}
	
	/**
	 * https://www.geeksforgeeks.org/bubble-sort/
	 * @param arr
	 */
	public void bubbleSort(int [] arr) {
		for(int i = arr.length-1; i > 0; i--) {
			for(int j = 1; j <= i; j++) {
				if(arr[j-1] > arr[j]) {
					int temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j]	 = temp;
				}
			}
		}
	}
	
	/**
	 * 
	 * @param arr
	 */
	public void print(int [] arr) {
		StringBuilder sb = new StringBuilder();
		if(arr == null) {
			sb.append("null");
		} else {
			int iMax = arr.length - 1;
			
			if(iMax == -1) {
				sb.append("[]");
			} else {
				sb.append("[");
				for(int i = 0; i < arr.length; i++) {
					if(i == arr.length - 1) {
						sb.append(arr[i] + "]");
					} else {
						sb.append(arr[i] + ", ");
					}
				}
			}
		}
		
		System.out.println(sb.toString());
	}
}
