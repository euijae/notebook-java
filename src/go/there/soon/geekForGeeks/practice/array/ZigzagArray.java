package go.there.soon.geekForGeeks.practice.array;

import java.util.*;

/**
 * https://www.geeksforgeeks.org/generate-all-possible-sorted-arrays-from-alternate-elements-of-two-given-arrays/
 * @author eugene.kim
 *
 */
public class ZigzagArray {

	public static void main(String[] args) {
		int [] nums1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int [] nums2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		List<List<Integer>> lists = new ArrayList<>();
		
		for(int i = 0; i < nums1.length; i++)
			generateArray(lists, new ArrayList<>(), nums1, nums2, false, nums1[i]);
		
		System.out.println(lists.toString());
	}
	
	public static void generateArray(
			List<List<Integer>> lists,
			List<Integer> list, 
			int [] nums1, 
			int [] nums2,
			boolean isNavigateFirstArray,
			int key) {
		if(key == -1) {
			if(list.size() % 2 == 1)
				list.remove(list.size()-1);
			if(list.size() != 0)
				lists.add(list);
		} else {
			list.add(key);
			key = (isNavigateFirstArray) ? getElement(nums1, key) : getElement(nums2, key);
			generateArray(lists, list, nums1, nums2, !isNavigateFirstArray, key);
		}
	}
	
	public static int getElement(int [] nums, int key) {
		int element = -1;
		
		for(int num : nums)
			if(num > key) 
				return num;
		
		return element;
	}
}
