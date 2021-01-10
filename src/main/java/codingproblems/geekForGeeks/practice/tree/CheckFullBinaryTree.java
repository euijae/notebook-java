package codingproblems.geekForGeeks.practice.tree;

import java.util.LinkedList;
import java.util.Queue;

public class CheckFullBinaryTree {
	public boolean isFullTreeByRecursion(Node p) {
		if(p == null) 
			return true;
		
		if(p.left == null && p.right == null) 
			return true;
		
		if(p.left != null && p.right != null) 
			return isFullTreeByRecursion(p.left) && isFullTreeByRecursion(p.right); 
		
		return false;
	}
	
	public boolean isFullTreeByLevelOrder(Node p) {
		if(p == null) return true;
		
		Queue<Node> q = new LinkedList<>();
		q.add(p);
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			for(int i = 0; i < size; i++) {
				Node tempNode = q.poll();
				
				if((tempNode.left == null && tempNode.right != null)
					|| ((tempNode.left != null && tempNode.right == null))){
					return false;
				} else {
					if(tempNode.left  != null) q.add(tempNode.left);
					if(tempNode.right != null) q.add(tempNode.right);
				}
			}
		}
		
		return true;
	}
}
