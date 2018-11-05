package go.there.soon.ctci.ch4.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tree<T extends Comparable<T>> {
	private TreeNode<T> root;
	
	public Tree() {}
	
	public void insert(TreeNode<T> rootNode, TreeNode<T> treeNode) {
		if(rootNode == null) {
			rootNode = treeNode;
		} else {
			if(rootNode.data.compareTo(treeNode.data) < 0) {
				if(rootNode.right == null)
					rootNode.right = treeNode;
				else
					insert(rootNode.right, treeNode);
			} else {
				if(rootNode.left == null)
					rootNode.left = treeNode;
				else
					insert(rootNode.left, treeNode);
			}
		}
	}

	public void printBFS(TreeNode<T> rootNode) {
		Queue<TreeNode<T>> q = new LinkedList<>();
		List<TreeNode<T>> list = new ArrayList<>();
		q.add(rootNode);
		list.add(rootNode);
		
		while(!q.isEmpty()) {
			TreeNode<T> node = q.poll();
			if(node.left != null) {
				q.add(node.left);
				list.add(node.left);
			} 
			
			if(node.right != null) {
				q.add(node.right);
				list.add(node.right);
			}
		}
		
		for(TreeNode<T> n : list) {
			System.out.print(n.data + " ");
		}
		
		System.out.println("");
	}
	
	public void inOrder(TreeNode<T> rootNode) {
		if(rootNode != null) {
			inOrder(rootNode.left);
			System.out.print(rootNode.data + " ");
			inOrder(rootNode.right);
		}
	}
	
	public TreeNode<T> getRoot() {
		return root;
	}

	public void setRoot(TreeNode<T> root) {
		this.root = root;
	}
}
