package codingproblems.geekForGeeks.practice.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.geeksforgeeks.org/find-minimum-depth-of-a-binary-tree/
 * @author eugene.kim
 *
 */
public class FindMinimumPath {

	public int findMinimumPath(Node root) {
		int level = 1;
		
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		
		int max = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			System.out.println(level + ". size: " + size);
			max = Math.max(size, max);
			for(int i = 0; i < size; i++) {
				Node node = q.poll();

				if(node.left != null && node.right != null) {
					if(node.left  != null) q.add(node.left);
					if(node.right != null) q.add(node.right);
				}
			}
			level ++;
		}
		
		System.out.println("width: " + max);
		
		return level;
	}
}
