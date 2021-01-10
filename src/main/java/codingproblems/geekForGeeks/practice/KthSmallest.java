package codingproblems.geekForGeeks.practice;

import java.util.Arrays;

import codingproblems.geekForGeeks.problem.heap.MaxHeap;
import codingproblems.geekForGeeks.problem.heap.MinHeap;
import codingproblems.geekForGeeks.problem.sortSearch.Sort;

public class KthSmallest {
	
	/** Using bubble sort and stop at kth. O(nk) complexities. */
	public void findKthLargest1(int [] nums, int k) {
		for(int i = nums.length; i > 0; i--) {
			for(int j = 1; j < i; j++) {
				if(nums[j-1] > nums[j]) {
					int temp = nums[j-1];
					nums[j-1] = nums[j];
					nums[j]   = temp;
				}
			}
			
			if(--k == 0)
				return;
		}
	}
	
	/** Implement by selection sort */
	public void findKthLargest2(int [] nums, int k) {
		for(int i = 0; i < nums.length-1; i++) {
			for(int j = i+1; j < nums.length; j++) {
				if(nums[i] > nums[j]) {
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				}
			}
			
			if(-k == 0)
				return ;
		}
	}
	
	/** Implement using max heap */
	public void findKthLargest3(int [] nums, int k) {
		MaxHeap mh = new MaxHeap(nums.length);
		
		for(int num : nums)
			mh.insertKey(num);
		
		int [] temp = new int[k];
		
		for(int i = 0; i < k; i++)
			temp[i] = mh.extract();

		System.out.println("First k elemetns are: " + Arrays.toString(temp));
	}
	
	public void findKthLargest4(int [] nums, int k) {
		MinHeap mh = new MinHeap(nums.length);
		
		for(int num : nums)
			mh.insertKey(num);
		
		int [] init = mh.getArr();
		int [] temp1 = new int[k];
		int [] temp2 = new int[nums.length-k];
		
		int counter = k;
		
		for(int i = 0; i < init.length; i++) {
			if(counter == 0) {
				temp2[i-k] = init[i];
			} else {
				temp1[i] = init[i];
				counter--;
			}
		}
		
		mh.setArr(temp1);
		mh.setSize(temp1.length);
		mh.setCapacity(temp1.length);
		
		for(int i = 0; i < temp1.length; i++) {
			int largestIndex = -1;
			
			for(int j = 0; j < temp2.length; j++)
				if(temp1[0] < temp2[j])
					largestIndex = j;
			
			if(largestIndex != -1) {
				int temp = temp1[0];
				temp1[0] = temp2[largestIndex];
				temp2[largestIndex] = temp;
				mh.heapify(0);
			}
		}
		
		mh.print();
	}
	
	public int findSmallest(int [] a, int k) {
		Sort sort = new Sort();
		sort.print(a);
		sort.mergeSort(a);
		sort.print(a);
		
		return a[k-1];
	}
	
	public int findSecondLargest(int [] a) {
		int large1 = Integer.MIN_VALUE;
		int large2 = a[0];
		
		System.out.println("i\tArray\tLarge1\tLarge2");
		for(int i = 0 ; i < a.length; i++) {
			if(a[i] > large1) {
				large2 = large1;
				large1 = a[i];
			} else if(a[i] > large2){
				if(a[i] != large1)
					large2 = a[i];
			}
			System.out.println(i + "\t" + a[i] + "\t" + large1 + "\t" + large2);
		}
		
		return large2;
	}
}
