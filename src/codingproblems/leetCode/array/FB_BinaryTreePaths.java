package codingproblems.leetCode.array;

import java.util.ArrayList;
import java.util.List;

public class FB_BinaryTreePaths {

	public static void main(String[] args) {
		FB_BinaryTreePaths o = new FB_BinaryTreePaths();
		o.test();
	}

	public void test() {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n5 = new TreeNode(5);
		
		n1.left = n2;
		n1.right = n3;
		n2.right = n5;
		
		Solution sol = new Solution();
		List<String> paths = sol.binaryTreePaths(n1);
		for(String path : paths) {
			System.out.println(path);
		}
	}
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	 
	class Solution {
	    public List<String> binaryTreePaths(TreeNode root) {
	        List<String> paths = new ArrayList<>();
	        findPaths(paths, root, new StringBuilder());
	        return paths;
	    }
	    
	    public void findPaths(List<String> paths, TreeNode current, StringBuilder pathSoFar) {
	    		if(current != null) {
    				pathSoFar.append((pathSoFar.length() == 0 ? "" : "->") + current.val);
	    			
	    			if(current.left == null && current.right == null) {
	    				paths.add(pathSoFar.toString());
	    			} else {
	    				findPaths(paths, current.left, pathSoFar);
	    				findPaths(paths, current.right, pathSoFar);
	    			}
	    		}
	    }
	}
}
