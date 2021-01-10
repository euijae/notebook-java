package codingproblems.ctci.ch4.q8;

import codingproblems.ctci.ch4.tree.TreeNode;

public class FirstCommonAncestor2 {

	public static void main(String[] args) {

	}

	public static boolean isFound(TreeNode<Integer> root, TreeNode<Integer> target) {
		if(root == null)
			return false;
		
		if(root.data.compareTo(target.data) == 0 && isMatch(root, target))
			return true;
		
		return isFound(root.left, target) || isFound(root.right, target);
	}
	
	public static boolean isMatch(TreeNode<Integer> root, TreeNode<Integer> target) {
		if(root == null && target == null) {
			return true;
		} else if(root == null || target == null) {
			return false;
		} else if(root.data.compareTo(target.data) != 0) {
			return false;
		}
		
		return isMatch(root.left, target) && isMatch(root.right, target);
	}
}
