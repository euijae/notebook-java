package go.there.soon.geekForGeeks.problem.heap;

public abstract class Heap {
	
	public abstract void insertKey(int k);
	public abstract int extract();
	public abstract void deleteKey(int i);
	public abstract void heapify(int i);
	public abstract void print();
	public abstract int getRoot();
	
	public int parent(int i) {
		return (i-1) / 2;
	}
	
	public int left(int i) {
		return 2*i+1;
	}
	
	public int right(int i) {
		return 2*i+2;
	}
	
	public void swap(int [] arr, int i1, int i2) {
		int temp = arr[i1];
		arr[i1] = arr[i2];
		arr[i2] = temp;
	}
}
