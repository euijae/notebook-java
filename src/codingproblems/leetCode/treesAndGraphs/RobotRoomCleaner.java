package codingproblems.leetCode.treesAndGraphs;

import java.util.HashSet;
import java.util.Set;

/**
 * unable to solve it. 
 * @author euijae_kim
 *
 */
public class RobotRoomCleaner{

	public static void main(String[] args) {
	}
	
	class Solution {
		final int [][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
		
		public void cleanRoom(Robot robot) {
			moveFrom(0, 0, 0, robot, new HashSet<>());
		}
		
		private void moveFrom(int x, int y, int orientation, Robot robot, Set<String> visited) {
			robot.clean();
			visited.add(x+","+y);
		}
	}
}

interface Robot {
	public boolean move();
	public void turnLeft();
	public void turnRight();
	public void clean();
}