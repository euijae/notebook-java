package go.there.soon.scratch;

import java.util.NoSuchElementException;

public class MinHeapArray {
	public int [] heap;
	public int size;
	public int capacity;
	
	public MinHeapArray(int capacity) {
		this.capacity = capacity;
		this.heap = new int[capacity];
		this.size = 0;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void insert(int key) {
		if(size == capacity) 
			doubleSize();
		
		heap[size] = key;
		int i = size;
		size++;
		
		while(i > 0 && heap[i] < heap[getParent(i)]) {
			swap(heap, i, getParent(i));
			i = getParent(i);
		}
	}
	
	public int extractMin() {
		if(isEmpty())
			throw new NoSuchElementException("No elements is found.");
		
		int min = heap[0];
		heap[0] = heap[--size];
		heap[size] = 0;
		heapify(0);
		
		return min;
	}
	
	public void heapify(int i) {
		int l = getLeft(i);
		int r = getRight(i);
		int smallest = i;
		
		if(l < size && heap[l] < heap[i]) {
			smallest = l;
		}
		
		if(r < size && heap[r] < heap[smallest]) {
			smallest = r;
		}
		
		if(smallest != i) {
			swap(heap, i, smallest);
			heapify(smallest);
		}
	}
	
	public void doubleSize() {
		capacity *= 2;
		int [] temp = new int[capacity];
		for(int i = 0; i < heap.length; i++)
			temp[i] = heap[i];
		
		heap = temp;
	}
	
	public void swap(int [] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public int getParent(int i) {
		return (i-1) / 2;
	}
	
	public int getLeft(int i) {
		return 2*i+1;
	}
	
	public int getRight(int i) {
		return 2*i+2;
	}
}
