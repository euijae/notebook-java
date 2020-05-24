package codingproblems.leetCode.treesAndGraphs;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
	
	public void setBoth(TreeNode l, TreeNode r) {
		left = l;
		right = r;
	}
}
