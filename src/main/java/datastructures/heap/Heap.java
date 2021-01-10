package datastructures.heap;

public abstract class Heap {
	public abstract void insert(int key);
	public abstract int removeMin(); // get min or max
	public abstract void heapify(int index);
	public abstract void print();
	public abstract int getRoot();
	public abstract void doubleSize();
	
	public int getParent(int index) {
		return (index - 1) / 2;
	}
	
	public int getLeft(int index) {
		return 2*index + 1;
	}
	
	public int getRight(int index) {
		return 2*index + 2;
	}
	
	public void swap(int [] arr, int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
}
