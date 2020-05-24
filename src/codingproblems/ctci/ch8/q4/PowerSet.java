package codingproblems.ctci.ch8.q4;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {

	public static void main(String[] args) {
		String s = "aacecaaa";
		System.out.println(s.substring(0, s.length()-1));
		for(List<Integer> list : sol1(new int []{1, 2, 3})) {
			System.out.println(list.toString());
		}
	}
	
	public static List<List<Integer>> sol1(int [] numbers) {
		List<List<Integer>> lists = new ArrayList<>();
		lists.add(new ArrayList<>());
		
		for(int number : numbers) {
			List<List<Integer>> tempLists = new ArrayList<>();
			
			for(List<Integer> list : lists) {
				List<Integer> tempList = new ArrayList<>();
				tempList.addAll(list);
				tempList.add(number);
				tempLists.add(tempList);
			}
			
			lists.addAll(tempLists);
		}
		
		return lists;
	}
}
