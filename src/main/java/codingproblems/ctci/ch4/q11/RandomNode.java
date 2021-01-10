package codingproblems.ctci.ch4.q11;

import codingproblems.ctci.ch4.tree.BinarySearchTree;
import codingproblems.ctci.ch4.tree.TreeNode;

public class RandomNode {

	public static void main(String[] args) {
		
		TreeNode<Integer> n7 = new TreeNode<>(7);
		BinarySearchTree<Integer> root = new BinarySearchTree<>(n7);
		root.insert(n7, 2);
		root.insert(n7, 9);
		root.insert(n7, 1);
		root.insert(n7, 4);
		root.insert(n7, 8);
		root.insert(n7, 12);
		root.insert(n7, 0);
		root.insert(n7, 3);
		root.insert(n7, 6);
		System.out.println(root.delete(7));
		root.inOrder(root.getRoot());   System.out.println();
		root.preOrder(root.getRoot());  System.out.println();
		root.postOrder(root.getRoot()); System.out.println();
	}
}
