package codingproblems.leetCode.treesAndGraphs;

import java.util.ArrayList;

public class InorderSuccessor {

	public static void main(String[] args) {
		InorderSuccessor is = new InorderSuccessor();
		is.test();
	}
	
	public void test() {
		Solution s = new Solution();
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		
		n4.setBoth(n2, n5);
		n2.setBoth(n1, n3);
		TreeNode successor = s.inorderSuccessor(n4, n1);
		
		System.out.println(n3.val + "'s successor is " + (successor == null ? "null" : successor.val));
	}
	
	class Solution {
	    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
	    		ArrayList<TreeNode> path = new ArrayList<>();
	    		inorder(root, path);
	    		
	    		int index = -1;
	    		for(int i = 0; i < path.size(); i++) {
	    			if(path.get(i) != null && path.get(i).val == p.val) {
	    				index = i;
	    				break;
	    			}
	    		}
	    		
	    		if(index == -1)
	    			return null;
	    		
	        return (index == path.size()-1) ? null : path.get(index+1);
	    }

	    public void inorder(TreeNode root, ArrayList<TreeNode> path) {
	        if(root != null) {
	            inorder(root.left, path);
	            path.add(root);
	            inorder(root.right, path);
	        }
	    }
	}
}
