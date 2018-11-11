package go.there.soon.ctci.ch4.q11;

import go.there.soon.ctci.ch4.tree.BinarySearchTree;
import go.there.soon.ctci.ch4.tree.TreeNode;

public class RandomNode {

	public static void main(String[] args) {
		BinarySearchTree<Integer> root = new BinarySearchTree<>();
		TreeNode<Integer> n7 = new TreeNode<>(7);
		
		root.insert(n7, 2);
		root.insert(n7, 9);
		root.insert(n7, 1);
		root.insert(n7, 4);
		root.insert(n7, 8);
		root.insert(n7, 12);
		root.insert(n7, 0);
		root.insert(n7, 3);
		root.insert(n7, 6);
		System.out.println(root.delete(n7, 9));
		root.inOrder(n7);   System.out.println();
		root.preOrder(n7);  System.out.println();
		root.postOrder(n7); System.out.println();
	}
}
