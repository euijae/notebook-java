package go.there.soon.leetCode.treesAndGraphs;

public class ValidateBinarySearchTree {

	public static void main(String[] args) {
		(new ValidateBinarySearchTree()).test();
	}
	
	@SuppressWarnings("unused")
	public void test() {
		Solution s = new Solution();
		
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		TreeNode n10 = new TreeNode(5);
		TreeNode n15 = new TreeNode(6);
		TreeNode n20 = new TreeNode(7);
		
		n10.setBoth(n5, n15);
		n15.setBoth(n6, n20);
		
		TreeNode min = new TreeNode(Integer.MIN_VALUE);
		TreeNode max = new TreeNode(Integer.MAX_VALUE);
		min.setBoth(null, max);
		
		boolean isBST = s.isValidBST(min);
		System.out.println("Is this a bst? " + isBST);
	}
	
	class Solution {
	    public boolean isValidBST(TreeNode root) {
	        return isValidBST(root, null, null);
	    }
	    
	    public boolean isValidBST(TreeNode node, Integer max, Integer min) {
	    		if(node == null)
	    			return true;
	    		
	    		if((min != null && node.val <= min) || (max != null && node.val >= max))
	    			return false;
	    		
	    		return isValidBST(node.left, node.val, min)
    					&& isValidBST(node.right, max, node.val);
	    }
	}
}
