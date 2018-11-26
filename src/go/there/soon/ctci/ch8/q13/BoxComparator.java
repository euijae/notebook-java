package go.there.soon.ctci.ch8.q13;

import java.util.Comparator;

public class BoxComparator implements Comparator<Box> {

	@Override
	public int compare(Box o1, Box o2) {
		return o2.height - o1.height;
	}
}
