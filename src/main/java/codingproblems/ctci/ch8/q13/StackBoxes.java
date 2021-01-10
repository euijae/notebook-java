package codingproblems.ctci.ch8.q13;

import java.util.ArrayList;
import java.util.Collections;

public class StackBoxes {

	
	/**
	 * Box(7, 8, 3)
		Box(9, 7, 3)
		Box(8, 6, 2)
		Box(6, 4, 4)
		Box(5, 3, 3)
		Box(4, 2, 2)
	 * @param args
	 */
	public static void main(String[] args) {
		Box[] boxList = { 
				new Box(6, 4, 1), 
				new Box(8, 6, 2), 
				new Box(5, 3, 3), 
				new Box(7, 8, 3), 
				new Box(4, 2, 2), 
				new Box(9, 7, 3)};
		
		ArrayList<Box> boxes = new ArrayList<Box>();
		
		for (Box b : boxList) {
			boxes.add(b);
		}
		
		int height = createStack(boxes);
		System.out.println(height);
	}

	public static int createStack(ArrayList<Box> boxes) {
		Collections.sort(boxes, new BoxComparator());
		
		int maxHeight = 0;
		int [] dictionary = new int[boxes.size()];
		for(int i = 0; i < boxes.size(); i++) {
			int height = createStack(boxes, i, dictionary);
			maxHeight = Math.max(height, maxHeight);
		}
		
		return maxHeight;
	}
	
	public static int createStack(
			ArrayList<Box> boxes, 
			int bottomIndex,
			int [] dictionary) {
		
		if(bottomIndex < boxes.size() && dictionary[bottomIndex] > 0)
			return dictionary[bottomIndex];
		
		Box bottom = boxes.get(bottomIndex);
		int maxHeight = 0;
		
		for(int i = bottomIndex + 1; i < boxes.size(); i++) {
			if(boxes.get(i).canBeAbove(bottom)) {
				int height = createStack(boxes, i, dictionary);
				maxHeight = Math.max(height, maxHeight);
			}
		}
		dictionary[bottomIndex] = maxHeight + bottom.height;
		return dictionary[bottomIndex];
	}
}
