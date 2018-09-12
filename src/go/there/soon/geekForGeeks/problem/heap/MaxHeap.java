package go.there.soon.geekForGeeks.problem.heap;

import java.util.Arrays;

public class MaxHeap extends Heap {

	private int size;
	private int capacity;
	private int [] arr;
	
	public MaxHeap(int capacity) {
		this.setSize(0);
		this.setCapacity(capacity);
		this.setArr(new int[capacity]);
	}

	@Override
	public void insertKey(int k) {
		if(size == capacity) {
			int [] temp = new int[capacity*2];
			
			for(int i = 0; i < size; i++)
				temp[i] = arr[i];
			
			arr = temp;
			setCapacity(capacity*2);
		}
		
		int i = size;
		arr[i] = k;
		
		setSize(size + 1);
		
		while(i > 0 && arr[i] > arr[parent(i)]) {
			swap(arr, i, parent(i));
			i = parent(i);
		}
	}

	@Override
	public int extract() {
		if(size <= 0) {
			return Integer.MAX_VALUE;
		} else if(size == 1) {
			this.setSize(0);
			return arr[0];
		} else {
			int max = arr[0];
			arr[0] = arr[size-1];
			setSize(size-1);
			heapify(0);
			return max;
		}
	}

	@Override
	public int getRoot() {
		return arr[0];
	}
	
	@Override
	public void deleteKey(int i) {
		swap(arr, i, 0);
		extract();
	}

	@Override
	public void heapify(int i) {
		int l = left(i);
		int r = right(i);
		int largest = i;
		
		if(l < size && arr[l] > arr[i]) {
			largest = l;
		}
		
		if(r < size && arr[r] > arr[largest]) {
			largest = r;
		}
		
		if(largest != i) {
			swap(arr, largest, i);
			heapify(largest);
		}
	}

	/*********************
	 * UTILITY FUNCTIONS *
	 *********************/
	@Override
	public void print() {
		System.out.println(Arrays.toString(arr));
	}

	/***********************
	 * SETTERS AND GETTERS *
	 ***********************/
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int[] getArr() {
		return arr;
	}
	public void setArr(int[] arr) {
		this.arr = arr;
	}
}
