package go.there.soon.geekForGeeks.problem.heap;

public class Driver {

	private static int [] nums = {1, 23, 12, 9, 30, 2, 50}; //{12, 11, 13, 5, 6, 7, 100, -100};
	private static MinHeap minh = new MinHeap(nums.length);
	private static MaxHeap maxh = new MaxHeap(nums.length);

	public Driver () {
		for(int num : nums)
			minh.insertKey(num);
		
		for(int num : nums) 
			maxh.insertKey(num);
	}
	
	public static void main(String[] args) {
		Driver d = new Driver();
		d.testMinHeap();
		d.testMaxHeap();
		d.testKthSmallest(3);
	}
	
	public void testKthSmallest(int i) {
		if(i >= nums.length) {
			System.out.println("Overflow: please try less than " + i);
		} else {
			
		}
	}
	
	public void testMinHeap() {
		minh.print();
	}
	
	public void testMaxHeap() {
		maxh.print();
	}
}
 