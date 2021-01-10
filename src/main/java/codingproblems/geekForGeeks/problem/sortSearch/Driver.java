package codingproblems.geekForGeeks.problem.sortSearch;

public class Driver {

	private static Search s = new Search();
	private static Sort sort = new Sort();
	
	public static void main(String[] args) {
		testQuickSort();
//		testMergeSort();
//		testSelectionSort();
//		testBubbleSort();
//		testRotatedArraySearch();
//		testSearch();
	}
	
	public static void testQuickSort() {
		System.out.println("> Quick Sort");
		int [] arr = {1, 8, 3, 9, 4, 5, 7};
		sort.print(arr);
		sort.quickSort(arr);
		sort.print(arr);
	}
	
	public static void testMergeSort() {
		System.out.println("> Merge Sort");
		int [] arr = {6, 5, 9, 1, 10, 51};
		sort.mergeSort(arr);
		sort.print(arr);
	}
	
	public static void testBubbleSort() {
		int [] arr = {9, 7, 5, 4, 3, 2, 1};
		sort.bubbleSort(arr);
		sort.print(arr);
	}
	
	public static void testSelectionSort() {
		int [] arr = {9, 7, 5, 4, 3, 2, 1};
		sort.selectionSort(arr);
		sort.print(arr);
	}
	
	public static void testRotatedArraySearch() {
		int [] arr = {3, 4, 5, 6, 1, 2};
		int key = 1;
		System.out.println("key(" + key + ") is found at " + s.rotatedArraySearch(arr,0,arr.length-1,key));
	}
	
	public static void testSearch() {
		int [] arr = new int[1000];
		for(int i = 0; i < arr.length; i++) arr[i] = i;
		int key = 100;
		System.out.println("key(" + key + ") is found at " + s.binarySearch(arr,0,arr.length-1,key));
	}
}
