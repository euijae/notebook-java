package go.there.soon.lecture.heap;

import java.util.NoSuchElementException;

public class MinHeap extends Heap{
	
	private int capacity;
	private int size;
	private int [] heap;
	
	public int getSize() {
		return size;
	}
	
	public MinHeap(int capacity) {
		this.capacity = capacity;
		this.size = 0;
		heap = new int[capacity];
	}
	
	@Override
	public void insert(int key) {
		
		if(size == capacity) 
			doubleSize();
		
		heap[size] = key;
		int i = size;
		size++;
		
		while(i > 0 && heap[getParent(i)] > heap[i]) {
			swap(heap, i, getParent(i));
			i = getParent(i);
		}
	}

	@Override
	public int removeMin() { // get minimum
		if(size == 0)
			throw new NoSuchElementException("No element available");
		
		int min = heap[0];
		heap[0] = heap[--size];
		heap[size] = 0;
		heapify(0);
		
		return min;
	}

	@Override
	public void heapify(int index) {
		int l = getLeft(index);
		int r = getRight(index);
		int smallest = index;
		
		if(l < size && heap[l] < heap[index]) 
			smallest = l;
		if(r < size && heap[r] < heap[smallest])
			smallest = r;
		
		if(smallest != index) {
			swap(heap, smallest, index);
			heapify(getParent(smallest));
		}
	}

	@Override
	public int getRoot() {
		if(size == 0) throw new NoSuchElementException();
		return heap[0];
	}

	@Override
	public void print() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < heap.length; i++) 
			sb.append((heap[i] != 0) ? heap[i] + " " : "");
		System.out.println(sb.toString());
	}
	
	@Override
	public void doubleSize() {
		int [] temp = new int[capacity * 2];
		
		for(int i = 0; i < capacity; i++)
			temp[i] = heap[i];
		
		heap = temp;
		capacity *= 2;
	}
	
	public static void main(String [] args) {
		MinHeap heap = new MinHeap(4);
		heap.insert(6);
		heap.insert(17);
		heap.insert(7);
		heap.insert(10);
		heap.insert(15);
		heap.insert(12);
		heap.insert(5);
		heap.print();
		
		int size = heap.getSize();
		System.out.println("size: " + size);
		while(size > 0) {
			System.out.print(heap.removeMin() + " ");
			size--;
		}
	}
}
