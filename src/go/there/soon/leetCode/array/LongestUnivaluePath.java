package go.there.soon.leetCode.array;

import java.util.LinkedList;

public class LongestUnivaluePath {

	public static void main(String[] args) {
		LongestUnivaluePath o = new LongestUnivaluePath();
		o.test();
	}
	
	public void test() {
		Solution sol = new Solution();
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(4);
		TreeNode n3 = new TreeNode(5);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(4);
		TreeNode n6 = new TreeNode(5);
		
		n1.setBoth(n2, n3);
		n2.setBoth(n4, n5);
		n3.setBoth(null, n6);
		
		sol.longestUnivaluePath(n1);
		int value = 5;
		System.out.println(sol.findLength(n3, value));
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
		void setBoth(TreeNode n1, TreeNode n2) {
			left = n1;
			right = n2;
		}
	}

	class Solution {
	    public int longestUnivaluePath(TreeNode root) {
	        if(root == null)
	            return 0;
	        
	        LinkedList<TreeNode> q = new LinkedList<>();
	        q.add(root);
	        
	        int longest = -1;
	        
	        while(!q.isEmpty()) {
	            TreeNode top = q.removeFirst();
	            
	            if(top.left != null)
	                q.add(top.left);
	            
	            if(top.right != null)
	                q.add(top.right);
	            
	            int leftLen = (top.left != null && top.left.val == top.val) ? 1 + findLength(top.left, top.left.val) : 0;
	            int rightLen = (top.right != null && top.right.val == top.val) ? 1 + findLength(top.right, top.right.val) : 0;
	            int len = Math.max(leftLen + rightLen, findLength(top, top.val));
	            longest = Math.max(longest, len);
	        }
	        
	        return longest;
	    }
	    
	    public int findLength(TreeNode node, int value) {
	        if(node == null || node.val != value)
	            return 0;
	        
	        return 1 + Math.max(findLength(node.left , value), 
	                            findLength(node.right, value));
	    }
	}
}