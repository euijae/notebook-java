package codingproblems.ctci.ch4.q2;

import codingproblems.ctci.ch4.tree.TreeNode;

public class MinimalTree2 {

	public static void main(String[] args) {
		int [] arr = new int[15];
		for(int i = 0; i < arr.length; i++)
			arr[i] = 2*(i+1);
		TreeNode<Integer> root = createMinimalBST(arr, 0, arr.length-1);
		print(root);
	}
	
	public static TreeNode<Integer> insert(TreeNode<Integer> node, int data) {
		if(node == null) {
			node =  new TreeNode<>(data);
		} else {
			if(node.data.compareTo(data) >= 0) {
				node.left = insert(node.left, data);
			} else {
				node.right = insert(node.right, data);
			}
		}
		
		return node;
	}
	
	public static TreeNode<Integer> createMinimalBST(int [] arr, int left, int right) {
		if(left > right)
			return null;
		
		int mid = (left + right) / 2;
		
		TreeNode<Integer> node = new TreeNode<>(arr[mid]);
		node.left = createMinimalBST(arr, left, mid-1);
		node.right = createMinimalBST(arr, mid+1, right);
		
		return node;
	}
	
	public static void print(TreeNode<Integer> root) {
		if(root != null) {
			print(root.left);
			System.out.print(root.data + " ");
			print(root.right);
		}
	}
}
