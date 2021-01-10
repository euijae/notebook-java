package codingproblems.geekForGeeks.practice.dynamicProgramming;

/**
 * https://www.geeksforgeeks.org/count-number-of-ways-to-cover-a-distance/
 * @author eugene.kim
 *
 */
public class CoverDistance {
	public static void main(String[] args) {
		System.out.println(getDistance(4));
	}

	public static int getDistance(int stair) {
		int [] ways = new int[stair+1];

		ways[0] = 1;
		ways[1] = 1;
		ways[2] = 2;

		if(stair < 3)
			return ways[stair];

		for(int i = 3; i <= stair; i++)
			ways[i] = ways[i-3] + ways[i-2] + ways[i-1];

		return ways[stair];
	}
}
