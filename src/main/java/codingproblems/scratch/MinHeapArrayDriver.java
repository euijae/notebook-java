package codingproblems.scratch;

import java.util.Arrays;

public class MinHeapArrayDriver {
	public static void main(String[] args) {
		int [] arr = {6, 17, 7, 10, 15, 12, 5};
		MinHeapArray mha = new MinHeapArray(arr.length);
		for(int number : arr)
			mha.insert(number);
		
		System.out.println(Arrays.toString(mha.heap));
		System.out.println(mha.extractMin());
		System.out.println(Arrays.toString(mha.heap));
	}
}
