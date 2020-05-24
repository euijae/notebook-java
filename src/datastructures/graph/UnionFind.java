package datastructures.graph;

import java.util.Arrays;

public class UnionFind {
	private int [] data;
	private int [] size;
	
	public UnionFind(int SIZE) {
		this.data = new int[SIZE];
		this.size = new int[SIZE];
		
		for(int i = 0; i < SIZE; i++) {
			data[i]  = i;
			size[i] = 1;
		}
			
	}
	
	public int root(int i) {
		while(data[i] != i) {
			data[i] = data[data[i]];
			i = data[i];
		}
		
		return i;
	}
	
	public void union(int A, int B) {
		int rootA = root(A);
		int rootB = root(B);
		
		data[rootA] = rootB;
		size[rootB] += size[rootA];
	}
	
	public void weightedUnion(int A, int B) {
		int rootA = root(A);
		int rootB = root(B);
		
		if(size[rootA] < size[rootB]) {
			data[rootA] = data[rootB];
			size[rootB] += size[rootA];
		} else {
			data[rootB] = data[rootA];
			size[rootA] += size[rootB];
		}
	}
	
	public boolean find(int A, int B) {
		int rootA = root(A);
		int rootB = root(B);
		
		return (rootA == rootB);
	}
	
	public void print() {
		System.out.println(Arrays.toString(data));
	}
	
	/*********************
	 * GETTER AND SETTER *
	 *********************/
	public int[] getData() {
		return data;
	}

	public void setData(int[] arr) {
		this.data = arr;
	}
}
