package go.there.soon.ctci.ch4.q6;

import java.util.ArrayList;
import java.util.List;

import go.there.soon.ctci.ch4.tree.TreeNode;

public class Successor {

	public static void main(String[] args) {
		TreeNode<Integer> n1 = new TreeNode<>(20);
		TreeNode<Integer> n2 = new TreeNode<>(10);
		TreeNode<Integer> n3 = new TreeNode<>(30);
		TreeNode<Integer> n4 = new TreeNode<>(8);
		TreeNode<Integer> n5 = new TreeNode<>(21);
		TreeNode<Integer> n6 = new TreeNode<>(24);
		TreeNode<Integer> n7 = new TreeNode<>(35);
		
		n1.setBoth(n2, n3);
		n2.setBoth(n4, n5);
		n3.setBoth(n6, n7);
		n7.parent = n3;
		n6.parent = n3;
		n5.parent = n2;
		n4.parent = n2;
		n3.parent = n1;
		n2.parent = n1;
		
		TreeNode<Integer> successor = getSuccessor2(n7); 
		System.out.println((successor == null) ? "null" : successor.data);
	}
	
	public static TreeNode<Integer> getSuccessor2(TreeNode<Integer> node) {
		if(node == null) 
			return null;
		
		if(node.right != null) {
			return leftmost(node.right);
		} else {
			TreeNode<Integer> curr = node;
			TreeNode<Integer> parent = node.parent;
			
			while(parent != null && parent.left != curr) {
				curr = parent;
				parent = parent.parent;
			}
			
			return parent;
		}
	}
	
	public static TreeNode<Integer> leftmost(TreeNode<Integer> node) {
		while(node.left != null) {
			node = node.left;
		}
		
		return node;
	}
	
	/**
	 * Solution is required to take one parameter. 
	 * It shouldn't traverse from first element to the end.
	 */
	public static TreeNode<Integer> getSuccessor(TreeNode<Integer> root, TreeNode<Integer> target) {
		List<TreeNode<Integer>> inOrder = new ArrayList<>();
		formBST(inOrder, root);
		TreeNode<Integer> successor = null;
		
		for(int i = 0; i < inOrder.size(); i++) {
			if(inOrder.get(i).equals(target)) {
				if(i != inOrder.size() - 1) {
					successor = inOrder.get(i+1);
				}
			}
		}
		
		return successor;
	}
	
	public static void formBST(List<TreeNode<Integer>> inOrder, TreeNode<Integer> root) {
		if(root != null) {
			formBST(inOrder, root.left);
			inOrder.add(root);
			formBST(inOrder, root.right);
		}
	}
}
