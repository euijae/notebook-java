package codingproblems.ctci.ch4.q12;

import java.util.LinkedList;
import java.util.Queue;

import codingproblems.ctci.ch4.tree.TreeNode;

public class PathSum {

	public static void main(String[] args) {
		String s = "aaabbcc";
		System.out.println(
				s.substring(0,1)
				+ ","
				+ s.substring(1, 6) 
				+ ","
				+ s.substring(6)
				);
		
		TreeNode<Integer> n1 = new TreeNode<Integer>(10);
		TreeNode<Integer> n2 = new TreeNode<Integer>(5);
		TreeNode<Integer> n3 = new TreeNode<Integer>(-3);
		TreeNode<Integer> n4 = new TreeNode<Integer>(3);
		TreeNode<Integer> n5 = new TreeNode<Integer>(2);
		TreeNode<Integer> n6 = new TreeNode<Integer>(11);
		TreeNode<Integer> n7 = new TreeNode<Integer>(3);
		TreeNode<Integer> n8 = new TreeNode<Integer>(-2);
		TreeNode<Integer> n9 = new TreeNode<Integer>(1);
		TreeNode<Integer> n10 = new TreeNode<Integer>(1);
		TreeNode<Integer> n11 = new TreeNode<Integer>(-1);
		
		n1.setBoth(n2, n3);
		n2.setBoth(n4, n5);
		n3.setBoth(null, n6);
		n4.setBoth(n7, n8);
		n5.setBoth(null, n9);
		n6.setBoth(null, n10);
		n10.setBoth(null, n11);
		System.out.println(countPathSum1(n1, 18));
	}

	public static int countPathSum1(TreeNode<Integer> node, int target) {
		int count = 0;
		
		Queue<TreeNode<Integer>> q = new LinkedList<>();
		q.add(node);
		node.sum = node.data;
		
		while(!q.isEmpty()) {
			TreeNode<Integer> first = q.poll();
			
			if(first.left != null) {
				int sum = first.sum + first.left.data;
				first.left.sum = sum;
				q.add(first.left);
				
				if(sum ==  target)
					count ++;
			}
			
			if(first.right != null) {
				int sum = first.sum + first.right.data;
				first.right.sum = sum;
				q.add(first.right);
				
				if(sum == target) 
					count ++;
			}
		}
		
		return count;
	}
	
	public static int countPathSum2(TreeNode<Integer> node, int target) {
		if(node == null)
			return 0;
		
		if(node.data == target)
			return 1;
		
		return countPathSum2(node.left, target - node.data) 
				+ countPathSum2(node.right, target - node.data);
	}
}
