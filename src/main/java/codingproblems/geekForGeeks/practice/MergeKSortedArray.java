package codingproblems.geekForGeeks.practice;

import java.util.Arrays;

import codingproblems.geekForGeeks.problem.heap.MinHeap;

public class MergeKSortedArray {

	public MergeKSortedArray() {
		// TODO Auto-generated constructor stub
	}

	public void merge(int [][] m) {
		MinHeap [] mh = new MinHeap[m.length];
		int totalLength = 0; 
		
		// n
		for(int i = 0; i < m.length; i++) {
			mh[i] = new MinHeap(m[i].length);
			mh[i].setArr(m[i]);
			
			totalLength += m[i].length;
			
			// k*log(k)
			for(int j = 0; j < m[i].length; j++)
				mh[i].insertKey(m[i][j]);
		}
		
		int [] result = new int[totalLength];
		
		for(int i = 0; i < totalLength; i++) {
			int arrayIndex = -1;
			int smallest = Integer.MAX_VALUE;
			
			// n
			for(int j = 0; j < m.length; j++) {
				if(mh[j].getSize() > 0 && mh[j].getRoot() < smallest) {
					smallest = mh[j].getRoot();
					arrayIndex = j;
				}
			}
			
			// log(k)
			if(arrayIndex != -1)
				result[i] = mh[arrayIndex].extract();
		}
		// >> nk(n+log(k)) > nk*log(n) + nnk > nk(n + log(k))
		
		System.out.println(Arrays.toString(result));
	}
}
