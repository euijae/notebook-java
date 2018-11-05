package go.there.soon.ctci.ch4.q4;

import java.util.LinkedList;
import java.util.Queue;

import go.there.soon.ctci.ch4.tree.TreeNode;

public class CheckBalanced {

	public static void main(String[] args) {
		TreeNode<Integer> n1 = new TreeNode<>(20);
		TreeNode<Integer> n2 = new TreeNode<>(10);
		TreeNode<Integer> n3 = new TreeNode<>(30);
		TreeNode<Integer> n4 = new TreeNode<>(8);
		TreeNode<Integer> n5 = new TreeNode<>(12);
		TreeNode<Integer> n6 = new TreeNode<>(24);
		TreeNode<Integer> n7 = new TreeNode<>(35);
		TreeNode<Integer> n8 = new TreeNode<>(24);
		TreeNode<Integer> n9 = new TreeNode<>(35);
		
		n1.setBoth(n2, n3);
		n2.setBoth(n4, n5);
		n3.setBoth(n6, n7);
		n4.setBoth(null, n8);
		n8.setBoth(null, n9);
		
		System.out.println(checkBalanced (n1));
		System.out.println(checkBalanced2(n1));
	}
	
	public static boolean checkBalanced2(TreeNode<Integer> root) {
		if(root == null)
			return true;
		
		int h1 = getHeight2(root.left);
		int h2 = getHeight2(root.right);
		
		System.out.println("[checkBalanced2] h1: " + h1 + ", h2: " + h2);
		
		if(Math.abs(h1 - h2) > 1)
			return false;
		
		return checkBalanced2(root.left) && checkBalanced2(root.right);
	}
	
	public static int getHeight2(TreeNode<Integer> node) {
		if(node == null)
			return 0;
		
		Queue<TreeNode<Integer>> q = new LinkedList<>();
		q.add(node);
		int height = 0;
		while(!q.isEmpty()) {
			int level = q.size();
			for(int i = 0; i < level; i++) {
				TreeNode<Integer> first = q.poll();
				if(first.left != null) 
					q.add(first.left);
				if(first.right != null)
					q.add(first.right);
			}
			height++;
		}
		
		return height;
	}
	
	public static boolean checkBalanced(TreeNode<Integer> root) {
		if(root == null)
			return true;
		
		int h1 = getHeight(root.left);
		int h2 = getHeight(root.right);

		System.out.println("[checkBalanced ] h1: " + h1 + ", h2: " + h2);
		
		if(Math.abs(h1-h2) > 1)
			return false;
		
		return checkBalanced(root.left) && checkBalanced(root.right);
	}
	
	public static int getHeight(TreeNode<Integer> node) {
		if(node == null)
			return -1;
		
		return 1 + Math.max(getHeight(node.left), getHeight(node.right));
	}
}
