package codingproblems.geekForGeeks.problem.heap;

import java.util.Arrays;

public class MinHeap extends Heap{
	
	private int [] arr;
	private int capacity;
	private int size;
	
	public MinHeap(int capacity) {
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

		setSize(size+1);
		
		while(i > 0 && arr[parent(i)] > arr[i]) {
			swap(arr, i, parent(i));
			i = parent(i);
		}
	}
	
	@Override
	public int extract() {
		if(size <= 0) {
			return Integer.MAX_VALUE;
		} else if(size == 1) {
			size -- ;
			return arr[0];
		} else {
			int min = arr[0];
			arr[0] = arr[size-1];
			setSize(size-1);
			heapify(0);
			return min;
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
		int smallest = i;
		
		if(l < size && arr[l] < arr[i]) {
			smallest = l;
		}
		
		if(r < size && arr[r] < arr[smallest]) {
			smallest = r;
		}
		
		if(smallest != i) {
			swap(arr, i, smallest);
			heapify(smallest);
		}
	}
	
	/*********************
	 * UTILITY FUNCTIONS *
	 *********************/
	@Override
	public void print() {
		System.out.println(Arrays.toString(this.arr));
	}
	
	/***********************
	 * GETTERS and SETTERS *
	 ***********************/
	public int[] getArr() {
		return arr;
	}
	public void setArr(int[] arr) {
		this.arr = arr;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
}
