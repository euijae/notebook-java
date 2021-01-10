package codingproblems.ctci.ch4.q2;

import codingproblems.ctci.ch4.tree.TreeNode;

public class MinimalTree {

	public static void main(String[] args) {
		int [] arr = {0, 1, 2, 3, 4, 5, 6};
		TreeNode<Integer> root = minimalTree(arr);
		inOrder(root);
		preOrder(root);
		postOrder(root);
	}

	public static TreeNode<Integer> minimalTree(int [] arr) {
		return minimalTree(arr, 0, arr.length-1);
	}
	
	public static TreeNode<Integer> minimalTree(int [] arr, int start, int end) {
		if(start > end)
			return null;
		
		int mid = (start + end) / 2;
		
		TreeNode<Integer> node = new TreeNode<>(arr[mid]);
		
		node.left  = minimalTree(arr, start, mid-1);
		node.right = minimalTree(arr, mid+1, end  );
		
		return node;
	}
	
	public static void postOrder(TreeNode<Integer> root) {
		System.out.print("Post Order: \t");
		postOrderPrint(root);
		System.out.println("");
	}
	
	private static void postOrderPrint(TreeNode<Integer> root) {
		if(root != null) {
			postOrderPrint(root.left);
			postOrderPrint(root.right);
			System.out.print(root.data + " ");
		}
	}
	
	public static void preOrder(TreeNode<Integer> root) {
		System.out.print("Pre Order: \t");
		preOrderPrint(root);
		System.out.println("");
	}
	
	private static void preOrderPrint(TreeNode<Integer> root) {
		if(root != null) {
			System.out.print(root.data + " ");
			preOrderPrint(root.left);
			preOrderPrint(root.right);
		}
	}
	
	public static void inOrder(TreeNode<Integer> root) {
		System.out.print("In Order: \t");
		inOrderPrint(root);
		System.out.println("");
	}
	
	private static void inOrderPrint(TreeNode<Integer> root) {
		if(root != null) {
			inOrderPrint(root.left);
			System.out.print(root.data + " ");
			inOrderPrint(root.right);
		}
	}
}
