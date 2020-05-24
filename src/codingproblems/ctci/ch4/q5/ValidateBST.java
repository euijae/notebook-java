package codingproblems.ctci.ch4.q5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import codingproblems.ctci.ch4.tree.TreeNode;

public class ValidateBST {

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
		System.out.println("binary search tree? " + checkBST(n1));
	}
	
	public static boolean checkBST(TreeNode<Integer> root) {
		return checkBST(root, null, null);
	}
	
	public static boolean checkBST(TreeNode<Integer> root, Integer min, Integer max) {
		if(root == null) 
			return true;
		
		if((min != null && root.data <= min) || (max != null && root.data > max)) 
			return false;
		
		if(!checkBST(root.left, min, root.data) || !checkBST(root.right, root.data, max))
			return false;
		
		return true;
	}
	
	/****************************
	 * first solution from ctci * 
	 ****************************/
	public static boolean isBST(TreeNode<Integer> root) {
		List<TreeNode<Integer>> inOrder = new ArrayList<>();
		
		formBST(inOrder, root);
		
		for(TreeNode<Integer> n : inOrder) {
			System.out.print(n.data + " ");
		}
		
		System.out.println("");
		
		for(int i = 1; i < inOrder.size(); i++) {
			if(inOrder.get(i-1).data.compareTo(inOrder.get(i).data) > 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void formBST(List<TreeNode<Integer>> inOrder, TreeNode<Integer> root) {
		if(root != null) {
			formBST(inOrder, root.left);
			inOrder.add(root);
			formBST(inOrder, root.right);
		}
	}
	
	/**********************************
	 * followings are my first trials * 
	 **********************************/
	public static boolean iterative(TreeNode<Integer> root) {
		if(root == null) 
			return true;
		
		Queue<TreeNode<Integer>> q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()) {
			TreeNode<Integer> parent = q.poll();
			if(parent.left != null) {
				if(!iterativeHelper(true, parent.data, parent.left)) 
					return false;
				else
					q.add(parent.left);
			}
			
			if(parent.right != null) {
				if(!iterativeHelper(false, parent.data, parent.right))
					return false;
				else
					q.add(parent.right);
			}
		}
		
		return true;
	}
	
	/**
	 * 
	 * @param isLeft   true is it means a left subtree, otherwise false
	 * @param rootData data stored in root node
	 * @param root     root node
	 * @return
	 */
	public static boolean iterativeHelper(boolean isLeft, int rootData, TreeNode<Integer> root) {
		if(root == null)
			return true;
		
		Queue<TreeNode<Integer>> q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()) {
			TreeNode<Integer> first = q.poll();
		
			int parent = first.data;
			if(first.getLeft() != null) { 
				if(first.left.data <= parent) {
					if((isLeft && first.left.data < rootData) || (!isLeft && rootData < first.left.data)) {
						q.add(first.left);
					} else {
						return false;
					}
				} else {
					return false;
				}
			}
			
			if(first.right != null) { 
				if(parent < first.right.data) {
					if((isLeft && first.right.data < rootData) || (!isLeft && first.right.data > rootData)) {
						q.add(first.right);
					} else {
						return false;
					}
				} else {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public static boolean recursive(TreeNode<Integer> root) {
		if(root == null)
			return true;
		
		Queue<TreeNode<Integer>> q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()) {
			TreeNode<Integer> parent = q.poll();
			if(parent.left != null) {
				if(!recursiveHelper(true, parent.data, parent.left)) 
					return false;
				else
					q.add(parent.left);
			}
			
			if(parent.right != null) {
				if(!recursiveHelper(false, parent.data, parent.right))
					return false;
				else
					q.add(parent.right);
			}
		}
		
		return true;
	}
	
	public static boolean recursiveHelper(boolean isLeft, int rootData, TreeNode<Integer> root) {
		if(root == null) 
			return true;
		
		int parent = root.data;
		
		if(root.left != null) {
			int left = root.left.data;
			if(left < parent) {
				if((isLeft && left > rootData) || (!isLeft && left < rootData))
					return false;
			} else {
				return false;
			}
		}
		
		if(root.right != null) {
			int right = root.right.data;
			if(right > parent) {
				if((isLeft && right > rootData) || (!isLeft && right < rootData))
					return false;
			} else {
				return false;
			}
		}
		
		return recursiveHelper(true, rootData, root.left)
			&& recursiveHelper(true, rootData, root.right)
			&& recursiveHelper(false, rootData, root.left)
			&& recursiveHelper(false, rootData, root.right);
	}
}
